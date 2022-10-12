package practice.math;

import java.util.Scanner;

// 2739
public class Test002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}
