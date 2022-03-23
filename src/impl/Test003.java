package impl;

import java.util.Scanner;

// 책 문제 2
public class Test003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String position = sc.next();
		
		int x = position.charAt(0) - 'a';
		int y = position.charAt(1) - '1';
		int[][] arr = {{1, -2}, {-1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int moveX = x + arr[i][0];
			int moveY = y + arr[i][1];
			
			if (0 <= moveX && moveX < 8 &&
				0 <= moveY && moveY < 8) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
