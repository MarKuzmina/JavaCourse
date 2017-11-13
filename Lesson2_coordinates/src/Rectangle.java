public class Rectangle implements GeomInterface {
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public double x3;
    public double y3;

    public Rectangle(double _x1, double _y1, double _x2, double _y2, double _x3, double _y3)
    {
        x1 = _x1;
        y1 = _y1;
        x2 = _x2;
        y2 = _y2;
        x3 = _x3;
        y3 = _y3;
    }

    @Override
    public double GetArea() {
        double ab = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double bc = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        return ab * bc;
    }

    @Override
    public double GetPerimetr() {
        double ab = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double bc = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        return 2 * (ab + bc);
    }
}
