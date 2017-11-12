public class Rectangle implements GeomInterface {
    private double Rec1;
    private double Rec2;
    public Rectangle(double _Rec1, double _Rec2)
    {
        Rec1 = _Rec1;
        Rec2 = _Rec2;
    }

    @Override
    public double GetArea() {
        return Rec1 * Rec2;
    }

    @Override
    public double GetPerimetr() {
        return 2 * (Rec1 + Rec2);
    }
}
