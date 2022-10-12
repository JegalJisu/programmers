package practice.math;

import java.util.Scanner;

// 2588
public class Test007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(n * (m % 10));
        System.out.println(n * (m % 100 / 10));
        System.out.println(n * (m / 100));
        System.out.println(n * m);
    }
}
