package practice.greedy;

import java.util.Scanner;

// 5585
public class Test008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int answer = 0;
		int[] coin = {500, 100, 50, 10, 5, 1};
		int money = 1000;
		money -= n;
		
		for (int i = 0; i < coin.length; i++) {
			if (money / coin[i] > 0) {
				answer += money / coin[i];
				money %= coin[i];
			}
		}
		
		System.out.println(answer);
	}
}
