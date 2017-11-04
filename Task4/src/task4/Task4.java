/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class Task4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String name = in.nextLine();
        
        String result = "";
        for (int i = name.length()-1; i >= 0; i--) {
            result += name.charAt(i);
        }
        System.out.print(result);
    }
}

