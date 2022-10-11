package practice.greedy;

import java.util.Scanner;

// 2839
public class Test006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		int answer = -1;
		
		for (int i = 0; i < 5; i++) {
			if (kg - (3 * i) >= 0 && (kg - (3 * i)) % 5 == 0) {
				answer = i + ((kg - (3 * i)) / 5);
				break;
			}
		}
		
		System.out.println(answer);
	}
}
