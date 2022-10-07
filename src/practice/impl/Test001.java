package impl;

import java.util.Scanner;

// 책예제 1
public class Test001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int x = 1;
		int y = 1;
		
		String command = sc.nextLine();
		
		for (int i = 0; i < command.length(); i++) {
			switch (command.charAt(i)) {
				case 'U': {
					if (y > 1) y--;
					break;
				}
				case 'D': {
					if (y < n) y++;
					break;
				}
				case 'R': {
					if (x < n) x++;
					break;
				}
				case 'L': {
					if (x > 1) x--;
					break;
				}
			}
		}
		
		System.out.println(y + " " + x);
	}
}
