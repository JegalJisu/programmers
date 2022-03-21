package greedy;

import java.util.Scanner;

// 11047
public class Test001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 갯수측정
		for (int i = n - 1; i >= 0; i--) {
			answer += k / arr[i];
			k %= arr[i];
		}
		
		System.out.println(answer);
	}
}
