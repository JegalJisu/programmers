package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 1026
// 두번째 배열은 건드리지 말라는 문구때문에 효율은 안좋아도 건들지 않음.
public class Test007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int answer = 0;
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		
		for (int a = 0; a < n; a++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					
					if (arr2[i] < arr2[j] && arr1[i] < arr1[j]) {
						int temp = arr1[i];
						arr1[i] = arr1[j];
						arr1[j] = temp;
					}
					else if (arr2[i] > arr2[j] && arr1[i] > arr1[j]) {
						int temp = arr1[i];
						arr1[i] = arr1[j];
						arr1[j] = temp;
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			answer += arr1[i] * arr2[i];
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(answer);
		
		answer = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for (int i = 0; i < n; i++) {
			answer += arr1[i] * arr2[n - 1 - i];
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(answer);
	}
}
