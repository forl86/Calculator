package MyNumber;
public class MyNumber {
    int value;

    MyNumber(byte[] bytes) {
    }

    public static boolean IsRomanian(byte[] bytes) {
        if ((bytes[0] == 88) || (bytes[0] == 86) || (bytes[0] == 73)) {
            return true;//1,2,3,4,5,6,7,8,9,10
        } else return false;
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
}
