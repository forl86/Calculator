public class RomanianString implements  CalcString{

    public static boolean IsRomanian(byte[] bytes, int size) {
        boolean result = false;
        try{
            for (int i = 0; i < size; i++) {
                if ((bytes[i] == 88) || (bytes[i] == 86) || (bytes[i] == 73)) {
                    result = true;//1,2,3,4,5,6,7,8,9,10
                    break;
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
        String result = "";
        int q = a / 10;
        int r = a % 10;
        int i = 0;
        switch (q) {
            case (10):
                result = result.concat("C");
                break;
            case (9):
                result = result.concat("XC");
                break;
            case (8):
                result = result.concat("LXXX");
                break;
            case (7):
                result = result.concat("LXX");
                break;
            case (6):
                result = result.concat("LX");
                break;
            case (5):
                result = result.concat("L");
                break;
            case (4):
                result = result.concat("XL");
                break;
            case (3):
                result = result.concat("XXX");
                break;
            case (2):
                result = result.concat("XX");
                break;
            case (1):
                result = result.concat("X");
            case (0):
        }
        switch (r) {
            case (1):
                result = result.concat("I");
                break;
            case(2):
                result = result.concat("II");
                break;
            case(3):
                result = result.concat("III");
                break;
            case(4):
                result = result.concat("IV");
                break;
            case(5):
                result = result.concat("V");
                break;
            case(6):
                result = result.concat("VI");
                break;
            case(7):
                result = result.concat("VII");
                break;
            case(8):
                result = result.concat("VIII");
                break;
            case(9):
                result = result.concat("IX");
                break;
        }
        return result;
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
