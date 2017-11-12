public class Triangle implements GeomInterface {
    private double Tri1;
    private double Tri2;
    private double Tri3;

    public Triangle(double _Tri1, double _Tri2, double _Tri3)
    {
        Tri1 = _Tri1;
        Tri2 = _Tri2;
        Tri3 = _Tri3;
    }

    @Override
    public double GetPerimetr() {
        return  Tri1 + Tri2 + Tri3;
    }

    @Override
    public double GetArea() {
       double p = GetPerimetr() / 2;
       return Math.sqrt(p * ((p - Tri1) * (p - Tri2) *  (p - Tri3)));
    }


}
