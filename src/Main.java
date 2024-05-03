import java.io.IOException;
import MyNumber.MyNumber;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String inputString;
        byte[] bytes = new byte[10];
        int nBytesRead = 0;
        try
        {
            nBytesRead = System.in.read(bytes);
            if( MyNumber.IsRomanian(bytes)) {
                //Romanian
                int a = MyNumber.ConvertFromRomanian(bytes, 0);
                byte operation = 43;
                int secondOperandPosition = 0;
                int b;
                switch (a) {
                    case (1):
                    case (5):
                    case (10):
                        operation = bytes[1];
                        secondOperandPosition = 2;
                        break;
                    case (2):
                    case (4):
                    case (6):
                    case (9):
                        operation = bytes[2];
                        secondOperandPosition = 3;
                        break;
                    case (3):
                    case (7):
                        operation = bytes[3];
                        secondOperandPosition = 4;
                        break;
                    case (8):
                        operation = bytes[4];
                        secondOperandPosition = 5;
                        break;
                }
                b = MyNumber.ConvertFromRomanian(bytes, secondOperandPosition);
                switch (operation) {
                    case (43)://plus
                        System.out.println(MyNumber.ConvertToRomanian(a+b));
                        break;
                    case (45)://minus
                        System.out.println(MyNumber.ConvertToRomanian(a - b));
                        break;
                    case (42)://multiply
                        System.out.println(MyNumber.ConvertToRomanian(a * b));
                        break;
                    case (47)://divide
                        System.out.println(MyNumber.ConvertToRomanian(a / b));
                        break;
                    }
                return;
            }
            else
            {
                //Arabic
                int a = (int)bytes[0]-'0';
                byte operation = bytes[1];
                int b = bytes[2]-'0';
                switch (operation) {
                    case (43)://plus
                        System.out.println(a+b);
                        break;
                    case (45)://minus
                        System.out.println(a-b);
                        break;
                    case (42)://multiply
                        System.out.println(a*b);
                        break;
                    case (47)://divide
                        System.out.println(a/b);
                        break;

                    //System.out.println(MyNumber.ConvertFromRomanian(bytes));
                }
            }
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
//        System.out.println(bytes.toString());
//        for(byte b:bytes){
//            System.out.println(b);
//        }

    }
}