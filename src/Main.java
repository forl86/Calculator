import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String inputString;
        byte[] bytes = new byte[10];
        int nBytesRead = 0;
        String calcString = "";
        try {
            nBytesRead = System.in.read(bytes);
            if (bytes[0] == 45) throw new Exception("First argument must be greater!\n");
            if (RomanianString.IsRomanian(bytes)) {
                //Romanian
                RomanianString romanianString = new RomanianString();
                calcString = romanianString.Parse(bytes);
            } else {
                //Arabic
                ArabicString arabicString = new ArabicString();
                calcString = arabicString.Parse(bytes);
            }
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