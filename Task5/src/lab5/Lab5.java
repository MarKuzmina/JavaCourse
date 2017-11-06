package lab5;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab5 {

    public static int[] getStringFromIP(String ip) {
        int[] result = new int[4];
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) != '.') {
                str.append(ip.charAt(i));
            }
            if (ip.charAt(i) == '.') {
                result[count] = Integer.parseInt(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        result[count] = Integer.parseInt(str.toString());
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputIP1 = in.nextLine();
        int[] IP1 = new int[4];
        IP1 = getStringFromIP(inputIP1);

        String inputIP2 = in.nextLine();
        int[] IP2 = new int[4];
        IP2 = getStringFromIP(inputIP2);

        String inputMask = in.nextLine();
        int[] mask = new int[4];
        mask = getStringFromIP(inputMask);

        for (int i = 0; i < 4; i++) {
            IP1[i] = IP1[i] & mask[i];
        }
        System.out.print(IP1[0] + ".");
        System.out.print(IP1[1] + ".");
        System.out.print(IP1[2] + ".");
        System.out.println(IP1[3]);

        for (int i = 0; i < 4; i++) {
            IP2[i] = IP2[i] & mask[i];
        }
        System.out.print(IP2[0] + ".");
        System.out.print(IP2[1] + ".");
        System.out.print(IP2[2] + ".");
        System.out.println(IP2[3]);

        boolean result = true;
        for(int i=0;i<4;i++)
        {
            if (IP1[i]!=IP2[i])
                result = false;
        }
        System.out.println("Принадлежат одной сети? " + result);
    }
}
