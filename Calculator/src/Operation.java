public class Operation {

    double operand1;
    double operand2;
    public  enum operation{
        Sum, Difference, Multiplication, Division
    }
    public  double result;
    public operation myOperation;
    Operation(double _operand1, double _operand2, char _operation){
        operand1 = _operand1;
        operand2 = _operand2;
        if (_operation == '+'){
            myOperation = operation.Sum;
            result = operand1 + operand2;
        }
        if (_operation == '-'){
            myOperation = operation.Difference;
            result = operand1 - operand2;
        }
        if (_operation == '*'){
            myOperation = operation.Multiplication;
            result = operand1 * operand2;
        }
        if (_operation == '/'){
            myOperation = operation.Division;
            result = operand1 / operand2;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (Double.compare(operation.operand1, operand1) != 0) return false;
        if (Double.compare(operation.operand2, operand2) != 0) return false;
        if (Double.compare(operation.result, result) != 0) return false;
        return myOperation == operation.myOperation;
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        temp = Double.doubleToLongBits(operand1);
        result1 = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(operand2);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(result);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        result1 = 31 * result1 + (myOperation != null ? myOperation.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "a" + operand1 +
                ", b=" + operand2 +
                ", Operation=" + myOperation +
                '}';
    }
}
