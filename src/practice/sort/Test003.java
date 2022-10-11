package practice.sort;

import java.util.Arrays;
import java.util.Scanner;

// 책 3번문제
public class Test003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int change = sc.nextInt();
		
		int[] arrMain = new int[length];
		int[] arrSub = new int[length];
		
		int count = 0;
		int mainPointer = 0;
		int subPointer = length - 1;
		int sum = 0;
		
		for (int i = 0; i < length; i++) {
			arrMain[i] = sc.nextInt();
		}
		
		for (int i = 0; i < length; i++) {
			arrSub[i] = sc.nextInt();
		}
		
		Arrays.sort(arrMain);
		Arrays.sort(arrSub);
		
		while (count < change) {
			count++;
			
			if (arrMain[mainPointer] < arrSub[subPointer]) {
				arrMain[mainPointer] = arrSub[subPointer];
				mainPointer++;
				subPointer--;
			}
			else {
				break;
			}
		}
		
		for (int num : arrMain) {
			sum += num;
		}
		System.out.println(sum);
	}
}
