public class RomanianString implements  CalcString{

    public static boolean IsRomanian(byte[] bytes) {
        boolean result = false;
        try{
            if ((bytes[0] == 88) || (bytes[0] == 86) || (bytes[0] == 73)) {
                result = true;//1,2,3,4,5,6,7,8,9,10
                for(byte b: bytes)
                {
                        if((47<b) && (b<57)) {
                            throw new Exception("Wrong Format!");
                        }
                }

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static int ConvertFromRomanian(byte[] bytes,int shift) {
        if ((bytes[shift] == 73) && (bytes[shift+1] == 73) && (bytes[shift+2]) == 73) {
            return 3;
        } else if ((bytes[shift] == 73) && (bytes[shift+1] == 73)) {
            return 2;
        } else if ((bytes[shift] == 73) && (bytes[shift+2] == 83)) {
            return 4;
        } else if ((bytes[shift] == 73) && (bytes[shift+2] == 88)) {
            return 9;
        } else if ((bytes[shift] == 86) && (bytes[shift+1] == 73) && (bytes[shift+2] == 73) && (bytes[shift+3] == 73)) {
            return 8;
        } else if ((bytes[shift] == 86) && (bytes[shift+1] == 73) && (bytes[shift+2] == 73)) {
            return 7;
        } else if ((bytes[shift] == 86) && (bytes[shift+1] == 73)) {
            return 6;
        } else if (bytes[shift] == 86) {
            return 5;
        } else if (bytes[shift] == 88) {
            return 10;
        } else if (bytes[shift] == 73) {
            return 1;
        }
        return -1;
    }
    public static String ConvertToRomanian(int a){
        switch (a) {
            case (1):
                return "I";
            case(2):
                return "II";
            case(3):
                return "III";
            case(4):
                return "IV";
            case(5):
                return "V";
            case(6):
                return "VI";
            case(7):
                return "VII";
            case(8):
                return "VIII";
            case(9):
                return "IX";
            case(10):
                return "X";
            case(11):
                return "XI";
            case(12):
                return "XII";
            case(13):
                return "XIII";

        }
        return "III";
    }
    @Override
    public String Parse(byte[] bytes) {
        int a = ConvertFromRomanian(bytes, 0);
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
        b = ConvertFromRomanian(bytes, secondOperandPosition);
        switch (operation) {
            case (43)://plus
                return ConvertToRomanian(a+b);
            case (45)://minus
                return ConvertToRomanian(a - b);
            case (42)://multiply
                return ConvertToRomanian(a * b);
            case (47)://divide
                return ConvertToRomanian(a / b);
        }

        return "RomanianString";
    }
}
