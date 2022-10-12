package practice.math;

import java.util.Scanner;

// 4344
public class Test009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            double avg;
            double result = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }

            avg = (float) sum / n;

            for (int num : arr) {
                if (num > avg) {
                    result += (100.0 / n);
                }
            }

            System.out.printf("%.3f%%%n", result);
        }
    }
}