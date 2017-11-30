import java.util.ArrayList;

public class Calculate {
    public String str;
    public double[] arrayNumber;
    public  char [] arraySymbol;
    public MyCache myCache;
    public int numberCount;

    Calculate(String _str, MyCache cache){
        str = _str;
        numberCount = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                numberCount++;
            }
        }
        arrayNumber = new double[numberCount + 1];
        arraySymbol = new char[numberCount];
        myCache = cache;
    }


    public void Parse(String ip) {
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) != '+' && ip.charAt(i) != '-' && ip.charAt(i) != '*' &&ip.charAt(i) != '/') {
                str.append(ip.charAt(i));
            }
            if (ip.charAt(i) == '+' || ip.charAt(i) == '-' || ip.charAt(i) == '*' || ip.charAt(i) == '/') {
                arraySymbol [count] = ip.charAt(i);
                arrayNumber[count] = Double.parseDouble(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        arrayNumber[count] = Double.parseDouble(str.toString());
    }


    public double fCalculate() {
        Parse(str);
        int countLowPriority=0;
        double result = arrayNumber[0];
        for(int i=0;i<numberCount;i++)
        {
            if (arraySymbol[i]=='+' || arraySymbol[i]=='-')
                countLowPriority++;
        }

        if (countLowPriority==0)
        {
            if(arraySymbol[0]=='*') {
                Operation currentOperation = new Operation(arrayNumber[0],arrayNumber[ 1],'*');
                return  myCache.GetResult(currentOperation);
            }
            if(arraySymbol[0]=='/') {
                Operation currentOperation = new Operation(arrayNumber[0],arrayNumber[1],'/');
                return  myCache.GetResult(currentOperation);
            }
        }

        double []arrayNumberHelp = new double[countLowPriority+1];
        char []arraySymbolHelp = new char[countLowPriority];
        int counterNumberHelp=0;
        int k=0;

        boolean []allowTake = new boolean[numberCount+1];
        for(int i=0;i<numberCount+1;i++)
            allowTake[i]=true;
        for (int i = 0; i < numberCount-1; i++) {
            if (arraySymbol[i] == '*') {
                Operation currentOperation = new Operation(arrayNumber[i],arrayNumber[i + 1],'*');
                System.out.println("Check CACHE :");
                arrayNumberHelp[i-k] = myCache.GetResult(currentOperation);
                allowTake[i] = false;
                allowTake[i+1] = false;
                k++;
            }else if (arraySymbol[i] == '/') {
                Operation currentOperation = new Operation(arrayNumber[i],arrayNumber[i + 1],'/');
                arrayNumberHelp[i-k] = myCache.GetResult(currentOperation);
                k++;
                allowTake[i] = false;
                allowTake[i+1] = false;
            }
        }
        //заполняем оставшийся массив
        k=0;
        int index=0;
        for(int i=0;i<numberCount+1;i++)
        {
            if (allowTake[i]) {
                arrayNumberHelp[index] = arrayNumber[i];
                index++;
            }
            else {
                k++;
                if(k%2==0)
                {
                    k=0;
                    index++;
                }
            }

        }
        //Создаем вспомогательный массив для знаков операций
        int helpCount = 0;
        for (int i = 0; i < numberCount; i++)
        {
            if(arraySymbol[i] == '+' || arraySymbol[i] == '-') {
                arraySymbolHelp[helpCount] = arraySymbol[i];
                helpCount++;
            }
        }

        for(int i=0;i<countLowPriority;i++)
        {
            if(arraySymbolHelp[i]=='+') {
                Operation currentOperation = new Operation(arrayNumber[i],arrayNumber[i + 1],'+');
                arrayNumberHelp[i + 1] = myCache.GetResult(currentOperation);
            }
            if(arraySymbolHelp[i]=='-') {
                Operation currentOperation = new Operation(arrayNumber[i], arrayNumber[i + 1], '-');
                arrayNumberHelp[i + 1] = myCache.GetResult(currentOperation);
            }
           // System.out.println(" i ="+ i);
        }
       // System.out.println(" countLowPriority ="+ countLowPriority);
        result = arrayNumberHelp[countLowPriority];






        /*switch (operand) {
            case '+':
                for(int i = 1; i < arrayNumber.length; i++)
                    result += arrayNumber[i];
                break;
            case '-':
                for(int i = 1; i < arrayNumber.length; i++)
                    result -= arrayNumber[i];
                break;
            case '*':
                for(int i = 1; i < arrayNumber.length; i++)
                    result *= arrayNumber[i];
                break;
            case '/':
                for(int i = 1; i < arrayNumber.length; i++)
                    result /= arrayNumber[i];
                break;
            default:
                break;
        }*/

        return result;
    }
}
