package sort;

import java.util.Scanner;

// 책 1번문제
public class Test001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		int[] arr = new int[length];
		
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
