package practice.search;

import java.util.Arrays;
import java.util.Scanner;

public class Test002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tar = new int[n];

        for (int i = 0; i < n; i++) {
            tar[i] = sc.nextInt();
        }

        Arrays.sort(tar);
        int m = sc.nextInt();
        int[] results = new int[m];

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int low = 0;
            int high = n - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (num == tar[mid]) {
                    results[i] = 1;
                    break;
                }
                else if (num > tar[mid]) {
                    low = mid + 1;
                }
                else if (num < tar[mid]) {
                    high = mid - 1;
                }
            }
        }

        for(int result : results) {
            System.out.println(result);
        }
    }
}
