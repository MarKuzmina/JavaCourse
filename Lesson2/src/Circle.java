public class Circle implements GeomInterface{
    private double radius;

    public Circle(double _radius)
    {
        radius = _radius;
    }

    @Override
    public double GetArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double GetPerimetr() {
        return 2 * Math.PI * radius;
    }
}
