public class ArabicString implements CalcString{
    @Override
    public String Parse(byte[] bytes) {
        try{
            int a = (int)bytes[0]-'0';
            byte operation = bytes[1];
            int b = bytes[2] - '0';
            boolean firstArgumentIsTwoDigit = false;
            boolean secondArgumentIsTwoDigit = false;

            if ((a==1) && (operation == '0'))//if first argument is 10
            {
                a = 10;
                operation = bytes[2];
                b = bytes[3]-'0';
                firstArgumentIsTwoDigit = true;
            }else if( ( (a > 1) || (operation-'0' > 0)) && ((operation != 45) && (operation != 42) && (operation != 43) && (operation != 47))){
                throw new Exception("First argument is too big!\n");
            }
            if ((b==1) && (((bytes[3] == '0') && (!firstArgumentIsTwoDigit))
                    || ((firstArgumentIsTwoDigit)&&(bytes[4] == '0')) ) )
            {
                b = 10;
                if (firstArgumentIsTwoDigit) operation = bytes[2];
                else operation = bytes[1];
            }else if ( firstArgumentIsTwoDigit )
            {
                operation = bytes[2];
                b = bytes[3];//here add another condition
                if((bytes[4] != 10) && (bytes[4] != 43) && (bytes[4] != 45) && (bytes[4] !=42) && (bytes[4] != 47)) secondArgumentIsTwoDigit = true;
                if( (secondArgumentIsTwoDigit) && ((b > 1) || (bytes[4]-'0' > 0)) ) throw new Exception("Second argument is too big!\n");
                if (bytes[5] != 10) throw new Exception("Too many arguments!");
            }else if ( !firstArgumentIsTwoDigit){
                operation = bytes[1];
                b = bytes[2];
                if((bytes[3] != 10) && (bytes[3] != 43) && (bytes[3] != 45) && (bytes[3] != 42) && (bytes[3] != 47)) secondArgumentIsTwoDigit = true;
                if( (secondArgumentIsTwoDigit) && ((b > 1) || (bytes[3]-'0' > 0) )) throw new Exception("Second argument is too big!\n");
                if (bytes[4] != 10 ) throw new Exception("Too many arguments!");
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
