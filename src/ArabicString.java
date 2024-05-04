public class ArabicString implements CalcString{
    @Override
    public String Parse(byte[] bytes) {
        try{
            int a = (int)bytes[0]-'0';
            byte operation = bytes[1];
            int b = bytes[2]-'0';
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
