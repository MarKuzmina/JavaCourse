public class Calculate {
    public String str;
    public char operation;
    public double[] array;

    Calculate(String _str, char _operation){
        str = _str;
        operation = _operation;
        int numberCount = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                numberCount++;
            }
        }
        array = new double[numberCount + 1];
    }

    public void Parse(String ip) {

        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) != '+' && ip.charAt(i) != '-' && ip.charAt(i) != '*' &&ip.charAt(i) != '/') {
                str.append(ip.charAt(i));
            }
            if (ip.charAt(i) == '+' || ip.charAt(i) == '-' || ip.charAt(i) == '*' || ip.charAt(i) == '/') {
                array [count] = Double.parseDouble(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        array[count] = Double.parseDouble(str.toString());
    }


    public double fCalculate() {
        int operand = operation;
        Parse(str);
        double result = array[0];
        switch (operand) {
            case '+':
                for(int i=1; i < array.length; i++)
                    result += array[i];
                break;
            case '-':
                for(int i=1; i < array.length; i++)
                    result -= array[i];
                break;
            case '*':
                for(int i=1; i < array.length; i++)
                    result *= array[i];
                break;
            case '/':
                for(int i=1; i < array.length; i++)
                    result /= array[i];
                break;
            default:
                break;
        }
        return result;
    }
}
