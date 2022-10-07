package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 11399
// short in first out
public class Test003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int answer = 0;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int num : arr) {
			sum += num;
			answer += sum;
		}
		
		System.out.println(answer);
	}
}
