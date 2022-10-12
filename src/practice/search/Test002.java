package practice.search;

import java.util.Arrays;
import java.util.Scanner;

public class Test002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int m = sc.nextInt();
        int[] results = new int[m];

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int low = 0;
            int high = n - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (num == arr[mid]) {
                    results[i] = 1;
                    break;
                }
                else if (num > arr[mid]) {
                    low = mid + 1;
                }
                else if (num < arr[mid]) {
                    high = mid - 1;
                }
            }
        }

        for(int result : results) {
            System.out.println(result);
        }
    }
}
