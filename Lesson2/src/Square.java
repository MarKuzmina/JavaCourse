public class Square implements GeomInterface {
    private double a;
    public Square(double _a)
    {
        a = _a;
    }
    @Override
    public double GetArea() {
        return Math.pow(a,2);
    }

    @Override
    public double GetPerimetr() {
        return 4*a;
    }
}
