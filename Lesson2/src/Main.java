import java.util.Scanner;

public class Main {

    public static int[] getStringFromRectangle(String s1) {
        int[] result = new int[4];
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                str.append(s1.charAt(i));
            }
            if (s1.charAt(i) == ' ') {
                result[count] = Integer.parseInt(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        result[count] = Integer.parseInt(str.toString());
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a geometric shape: circle, square, triangle, rectangle?");
        String Shape = sc.nextLine();
        Double areaShape = null;
        Double perimetrShape = null;

        try {
            switch (Shape) {
                case "circle":
                    System.out.print("Enter the radius:  ");
                    Circle circle1;
                    circle1 = new Circle(Double.parseDouble(sc.nextLine()));
                    areaShape = circle1.GetArea();
                    perimetrShape = circle1.GetPerimetr();
                    break;
                case "square":
                    System.out.print("Enter the side of the square:  ");
                    Square square1;
                    square1 = new Square(Double.parseDouble(sc.nextLine()));
                    areaShape = square1.GetArea();
                    perimetrShape = square1.GetPerimetr();
                    break;
                case "triangle":
                    System.out.print("Enter the sides of the triangle with a space:  ");
                    Triangle triangle1;
                    String inputS1 = sc.nextLine();
                    int[] s1 = new int[2];
                    s1 = getStringFromRectangle(inputS1);
                    triangle1 = new Triangle(s1[0], s1[1], s1[2]);
                    areaShape = triangle1.GetArea();
                    perimetrShape = triangle1.GetPerimetr();
                    break;
                case "rectangle":
                    System.out.print("Enter the sides of the rectangle with a space:  ");
                    Rectangle rectangle1;
                    String inputS2 = sc.nextLine();
                    int[] s2 = new int[1];
                    s2 = getStringFromRectangle(inputS2);
                    rectangle1 = new Rectangle(s2[0], s2[1]);
                    areaShape = rectangle1.GetArea();
                    perimetrShape = rectangle1.GetPerimetr();
                    break;
                default:
                    System.out.println("Verify the correctness of the data");
            }
        }
        catch (Exception e) {
            System.out.println("Verify the correctness of the data");
        }
        if ((areaShape!=null) && (perimetrShape!=null)) {
            System.out.println("areaShape = " + areaShape);
            System.out.println("perimetrShape = " + perimetrShape);
        }
    }
}
