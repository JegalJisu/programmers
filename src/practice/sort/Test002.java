package practice.sort;

import java.util.Arrays;
import java.util.Scanner;

// 책 2번문제
public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] numArr = new int[length];
		String[] nameArr = new String[length];
		
		for (int i = 0; i < length; i++) {
			nameArr[i] = sc.next();
			numArr[i] = sc.nextInt();
		}
		
		int[] tempArr = Arrays.copyOf(numArr, length);
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (tempArr[i] > tempArr[j]) {
					int temp = tempArr[j];
					tempArr[j] = tempArr[i];
					tempArr[i] = temp;
				}
			}
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (tempArr[i] == numArr[j]) {
					System.out.print(nameArr[j] + " ");
					numArr[j] = -1;
				}
			}
		}
	}
}
