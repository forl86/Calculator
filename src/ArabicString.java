public class ArabicString implements CalcString{
    @Override
    public String Parse(byte[] bytes) {
        try{
            int a = (int)bytes[0]-'0';
            byte operation = bytes[1];
            int b = bytes[2] - '0';
            boolean firstArgumentIsTwoDigit = false;
            if ((a==1) && (operation == '0'))//if first argument is two-digit
            {
                a = 10;
                operation = bytes[2];
                b = bytes[3]-'0';
                firstArgumentIsTwoDigit = true;
            }
            if ((b==1) && (((bytes[3] == '0') && (!firstArgumentIsTwoDigit))
                    || ((firstArgumentIsTwoDigit)&&(bytes[4] == '0')) ) )
            {
                b = 10;
                if (firstArgumentIsTwoDigit) operation = bytes[2];
                else operation = bytes[1];
            }
            if ((a > 10) || (b > 10)) throw new Exception("Too big numbers!");
            switch (operation) {
                case (43)://plus
                    return Integer.toString(a + b);
                case (45)://minus
                    return Integer.toString(a - b);
                case (42)://multiply
                    return Integer.toString(a * b);
                case (47)://divide
                    return Integer.toString(a / b);
                default:
                    throw new Exception("Invalid operation!");
            }    //System.out.println(MyNumber.ConvertFromRomanian(bytes));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return "Arabic";
    }
}
