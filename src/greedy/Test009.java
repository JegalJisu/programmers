package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 2217
public class Test009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if (answer < arr[n - 1 - i] * (i + 1)) {
				answer = arr[n - 1 - i] * (i + 1);
			}
		}
		
		System.out.println(answer);
	}
}
