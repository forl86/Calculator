import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static int findOperationIndex(byte[] b,int BytesNumber)
    {
        for (int i = 0; i < BytesNumber; i++) {
            if((b[i] == 43) || (b[i] == 45) || (b[i] == 42) || (b[i] == 47)) {
                return i;
            }
        }
        // if got here, there is no operation found
        return -1;
    }
    public static int retrieveArabianArgument(byte[] b, int n)
    {
        int result = 0;
        int digit = 0;
        for (int i = n; i >= 0; i--) {
            int symbol = b[i];
            if (symbol >= 48) {
                if(digit == 0)
                    result = result + (symbol - 48);
                if(digit == 1)
                    result = result + (symbol - 48)*10*digit;
                digit++;
            }
        }
        return result;
    }
    public static int retrieveRomanianArgument(byte[] b,int n)
    {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((b[i] == 73) && (b[i+1] != 73)) return 1;
            else if((b[i] == 73) && (b[i+1]==83)) return  4;
            else if((b[i] == 83) && (b[i+1] != 73)) return 5;
            else if((b[i] == 73) && (b[i+1] == 88) ) return 9;
            else if((b[i] == 88) && (b[i+1] != 73)) return 10;
            else if((b[i] == 73) && (b[i+1] == 73) && (b[i+2] != 73)) return 2;
            else if((b[i] == 73) && (b[i+1] == 73) && (b[i+2] == 73)) return 3;
            else if((b[i] == 83) && (b[i+1] == 73) && b[i+2] != 73) return 6;
            else if((b[i] == 83) && (b[i+1] == 73) && (b[i+2] == 73)) return 7;
            else if((b[i] == 83) && (b[i+1] == 73) && (b[i+3] == 73) && (b[i+4] == 73)) return 8;
            else result = 11;
        }
        return result;
    }
    /*public static byte[] copy(byte[] b,int startIndex, int endIndex)
    {
        byte[] result = new byte[endIndex-startIndex];
        if (endIndex - startIndex >= 0) System.arraycopy(b, startIndex + 0, result, 0, endIndex - startIndex);

    }*/
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String inputString;
        byte[] bytes = new byte[15];
        int nBytesRead = 0;
        String calcString = "";
        try {
            nBytesRead = System.in.read(bytes);
            int operationIndex = findOperationIndex(bytes,nBytesRead);
            if (operationIndex == -1) throw new Exception("No arithmetical operation found!");
            byte[] firstArgument = new byte[nBytesRead];
            byte[] secondArgument = new byte[nBytesRead];
            int a = 0;
            int b = 1;
            System.arraycopy(bytes,0,firstArgument,0,operationIndex);
            System.arraycopy(bytes, operationIndex + 1,secondArgument, 0,nBytesRead-operationIndex);
            if(RomanianString.IsRomanian(bytes)) {
                a = retrieveRomanianArgument(firstArgument,operationIndex);
                b = retrieveRomanianArgument(secondArgument, nBytesRead - operationIndex);
            }
            else {
                a = retrieveArabianArgument(firstArgument, operationIndex);
                b = retrieveArabianArgument(secondArgument, nBytesRead - operationIndex);
            }
            if ((a > 10) || (b > 10)) throw new Exception("Too big arguments!");
            else if ((a < 1) || (b < 1)) throw  new Exception("Increase arguments!");
            switch (bytes[operationIndex])
            {
                case (43)://plus
                    if(RomanianString.IsRomanian(bytes)){
                        System.out.println(RomanianString.ConvertToRomanian(a+b));
                    }
                    else
                        System.out.println(Integer.toString(a + b));
                    break;
                case (45)://minus
                    if(RomanianString.IsRomanian(bytes)){
                        System.out.println(RomanianString.ConvertToRomanian(a-b));
                    }
                    else
                        System.out.println(Integer.toString(a - b));
                    break;
                case (42)://multiply
                    if(RomanianString.IsRomanian(bytes)){
                        System.out.println(RomanianString.ConvertToRomanian(a*b));
                    }
                    else
                        System.out.println(Integer.toString(a * b));
                    break;
                case (47)://divide
                    if(RomanianString.IsRomanian(bytes)){
                        System.out.println(RomanianString.ConvertToRomanian(a / b));
                    }
                    else
                        System.out.println(Integer.toString(a / b));
                    break;
                default:
                    throw new Exception("Invalid operation!");
            }    //Sy
            /*if (bytes[0] == 45) throw new Exception("First argument must be greater!\n");
            if (RomanianString.IsRomanian(bytes)) {
                //Romanian
                RomanianString romanianString = new RomanianString();
                calcString = romanianString.Parse(bytes);
            } else {
                //Arabic
                ArabicString arabicString = new ArabicString();
                calcString = arabicString.Parse(bytes);
            }*/
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println(calcString);
//        System.out.println(bytes.toString());
//        for(byte b:bytes){
//            System.out.println(b);
//        }

    }
}