public class Circle implements GeomInterface{
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Circle(double _x1, double _y1, double _x2, double _y2)
    {
        x1 = _x1;
        y1 = _y1;
        x2 = _x2;
        y2 = _y2;
    }

    @Override
    public double GetArea() {
        double radius = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double GetPerimetr() {
        double radius = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return 2 * Math.PI * radius;
    }
}
