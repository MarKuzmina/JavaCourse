package task2;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        String str1 = in.nextLine();
        System.out.println("Введите второе число: ");
        String str2 = in.nextLine();
        System.out.println("Введите знак операции: ");
        char operand = in.nextLine().charAt(0);
        double num3 = 0;
        try {
            switch (operand) {
                case '+':
                    num3 = Double.parseDouble(str1) + Double.parseDouble(str2);
                    break;
                case '-':
                    num3 = Double.parseDouble(str1) - Double.parseDouble(str2);
                    break;
                case '*':
                    num3 = Double.parseDouble(str1) * Double.parseDouble(str2);
                    break;
                case '/':
                    num3 = Double.parseDouble(str1) / Double.parseDouble(str2);
                    break;
                default:
                    throw new Exception("operand");
            }
            System.out.println(num3);
        } catch (Exception e) {
                System.out.println("Вы ввели некорректные данные. Программа поддерживает знаки сложения, вычитания, умножения и деления.");
        }
    }
}
