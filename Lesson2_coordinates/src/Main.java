

import java.util.*;

public class Main {

    public static int[] getStringFromShape(String s1) {
        int[] result = new int[6];
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
        Circle circle1 = null;
        Square square1 = null;
        Triangle triangle1 = null;
        Rectangle rectangle1 = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a geometric shape: circle, square, triangle, rectangle?");
            String Shape = sc.nextLine();
            Double areaShape = null;
            Double perimetrShape = null;

            try {
                switch (Shape) {
                    case "circle":
                        System.out.print("Enter the coordinates of the center and the points on the circle with a space:  ");
                        String inputS1 = sc.nextLine();
                        int[] s1 = getStringFromShape(inputS1);
                        if (circle1 == null)
                            circle1 = new Circle(s1[0], s1[1], s1[2], s1[3]);
                        else
                        {
                            if (s1[0]==circle1.x1 && s1[1]==circle1.y1 && s1[2]==circle1.x2 && s1[3]==circle1.y2)
                                System.out.println("Already exist!");
                            else
                            {
                                System.out.println("This is new Point! Do you want to rewrite your Circle?");
                                String answ = sc.nextLine();
                                if (answ.equals("yes"))
                                {
                                    circle1 = new Circle(s1[0], s1[1], s1[2], s1[3]);
                                }
                                else
                                {
                                    System.out.println("Your answer is NO");
                                }
                            }
                        }
                        areaShape = circle1.GetArea();
                        perimetrShape = circle1.GetPerimetr();
                        break;
                    case "square":
                        System.out.print("Enter the coordinates of two points:  ");
                        String inputS2 = sc.nextLine();
                        int[] s2 = getStringFromShape(inputS2);
                        if (square1 ==null)
                            square1 = new Square(s2[0], s2[1], s2[2], s2[3]);
                        else
                        {
                            if (s2[0]==square1.x1 && s2[1]==square1.y1
                                    && s2[2]==square1.x2 && s2[3]==square1.y2)
                                System.out.println("Already exist!");
                            else
                            {
                                System.out.println("This is new Point! Do you want to rewrite your Square?");
                                String answ = sc.nextLine();
                                if (answ.equals("yes"))
                                {
                                    square1 = new Square(s2[0], s2[1], s2[2], s2[3]);
                                }
                                else
                                {
                                    System.out.println("Your answer is NO");
                                }
                            }
                        }
                        areaShape = square1.GetArea();
                        perimetrShape = square1.GetPerimetr();
                        break;
                    case "triangle":
                        System.out.print("Enter the coordinates of the three vertices of the triangle with a space:  ");
                        String inputS3 = sc.nextLine();
                        int[] s3 = getStringFromShape(inputS3);
                        if (triangle1 ==null)
                            triangle1 = new Triangle(s3[0], s3[1], s3[2], s3[3], s3[4], s3[5]);
                        else
                        {
                            if (s3[0]==triangle1.x1 && s3[1]==triangle1.y1
                                    && s3[2]==triangle1.x2 && s3[3]==triangle1.y2
                                    && s3[4]==triangle1.x3 && s3[5]==triangle1.y3)
                                System.out.println("Already exist!");
                            else
                            {
                                System.out.println("This is new Point! Do you want to rewrite your Triangle?");
                                String answ = sc.nextLine();
                                if (answ.equals("yes"))
                                {
                                    triangle1 = new Triangle(s3[0], s3[1], s3[2], s3[3], s3[4], s3[5]);
                                }
                                else
                                {
                                    System.out.println("Your answer is NO");
                                }
                            }
                        }
                        perimetrShape = triangle1.GetPerimetr();
                        areaShape = triangle1.GetArea();
                        break;
                    case "rectangle":
                        System.out.print("Enter the coordinates of the three vertices of the rectangle with a space:  ");
                        String inputS4 = sc.nextLine();
                        int[] s4 = getStringFromShape(inputS4);
                        if (rectangle1 ==null)
                            rectangle1 = new Rectangle(s4[0], s4[1], s4[2], s4[3], s4[4], s4[5]);
                        else
                        {
                            if (s4[0]==rectangle1.x1 && s4[1]==rectangle1.y1
                                    && s4[2]==rectangle1.x2 && s4[3]==rectangle1.y2
                                    && s4[4]==rectangle1.x3 && s4[5]==rectangle1.y3)
                                System.out.println("Already exist!");
                            else
                            {
                                System.out.println("This is new Point! Do you want to rewrite your Triangle?");
                                String answ = sc.nextLine();
                                if (answ.equals("yes"))
                                {
                                    rectangle1 = new Rectangle(s4[0], s4[1], s4[2], s4[3], s4[4], s4[5]);
                                }
                                else
                                {
                                    System.out.println("Your answer is NO");
                                }
                            }
                        }
                        areaShape = rectangle1.GetArea();
                        perimetrShape = rectangle1.GetPerimetr();
                        break;
                    default:
                        System.out.println("Incorrectly entered the name of the figure!");
                }
            } catch (Exception e) {
                System.out.println("Verify the correctness of the data!");
            }
            if ((areaShape != null) && (perimetrShape != null)) {
                System.out.println("areaShape = " + areaShape);
                System.out.println("perimetrShape = " + perimetrShape);
            }
        }
    }
}
