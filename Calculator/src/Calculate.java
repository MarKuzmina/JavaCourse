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



       /*
        System.out.print("Numbers: ");
        for(int i=0;i<numberCount+1;i++)
            System.out.print(arrayNumber[i] + " ");
        System.out.println("Operations: ");
        for(int i=0;i<numberCount;i++)
            System.out.print(arraySymbol[i] + " ");
       */



    }

    public void makeOperation (char operation1, char operation2)
    {
        Operation currentOperation = null;
        int operationIndex = 0;

        for (int i = 0; i < numberCount; i++) {
            if (arraySymbol[i] == operation1) {
                operationIndex = i;
                break;
            }
            if (arraySymbol[i] == operation2) {
                operationIndex = i;
                break;
            }
            if (i == numberCount - 1) {
                operationIndex = -1;
            }
        }
        while (operationIndex != -1 && numberCount>0) {

            double resultOperation;
            if (arraySymbol[operationIndex] == operation1)
                currentOperation = new Operation(arrayNumber[operationIndex], arrayNumber[operationIndex + 1], operation1);
            if (arraySymbol[operationIndex] == operation2)
                currentOperation = new Operation(arrayNumber[operationIndex], arrayNumber[operationIndex + 1], operation2);

            if (myCache.inCacheL1(currentOperation) || myCache.inCacheL2(currentOperation))
                resultOperation = myCache.GetResult(currentOperation);
            else
            {
                resultOperation = currentOperation.result;
            }
            if (currentOperation != null) {
                arrayNumber[operationIndex + 1] = resultOperation;
                for (int j = operationIndex; j < numberCount - 1; j++)
                    arraySymbol[j] = arraySymbol[j + 1];
                for (int j = operationIndex; j < numberCount; j++)
                    arrayNumber[j] = arrayNumber[j + 1];
                numberCount--;
            }
            for (int i = 0; i < numberCount; i++) {
                if (arraySymbol[i] == operation1) {
                    operationIndex = i;
                    break;
                }
                if (arraySymbol[i] == operation2) {
                    operationIndex = i;
                    break;
                }
                if (i == (numberCount - 1)) {
                    operationIndex = -1;
                }
            }


           /*
            System.out.println("After OPERATION: ");
            System.out.print("Numbers: ");
            for (int i = 0; i < numberCount + 1; i++)
                System.out.print(arrayNumber[i] + " ");
            System.out.println("Operations: ");
            for (int i = 0; i < numberCount; i++)
                System.out.print(arraySymbol[i] + " ");
                */


        }
    }


    public double fCalculate() {
        Parse(str);
        makeOperation('*','/');
        //на этом шаге имеем два массива с числами и операциями, в которых остутствуют операции умножения и деления
        makeOperation('+','-');
        return arrayNumber[0];
    }
}
