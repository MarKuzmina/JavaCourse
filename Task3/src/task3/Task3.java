package task3;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Task3 {

    long Fact(int n) {
        long result;

        if ((n == 1) || (n == 0)) {
            return 1;
        }

        result = Fact(n - 1) * n;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        try {
            Task3 f = new Task3();
            int num = Integer.parseInt(in.nextLine());
            System.out.print(f.Fact(num));
        } catch (Exception e) {
            System.out.print("Введите число!");
        }
    }
}
