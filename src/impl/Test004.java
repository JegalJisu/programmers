package impl;

import java.util.Scanner;

//책 문제 3
public class Test004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < arr.length; i++) {
			for (int  j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int direction = sc.nextInt();
		int answer = 0;
		
		while (true) {
			if ((x + 1 < n && arr[x + 1][y] != 0) &&
				(x - 1 >= 0 && arr[x - 1][y] != 0) &&
				(y + 1 < m && arr[x][y + 1] != 0) &&
				(y - 1 >= 0 && arr[x][y - 1] != 0)) {
				if (direction == 0) {
					y++;
				}
				else if (direction == 1) {
					x++;
				}
				else if (direction == 2) {
					y--;
				}
				else if (direction == 3) {
					x--;
				}
				
				if (arr[x][y] == 1) {
					System.out.println("!!!!");
					break;
				}
				else {
					answer++;
				}
			}
			else {
				direction = (direction + 1) % 4;
				
				switch (direction) {
					case 0 : 
						if (y + 1 >= m || arr[x][y + 1] != 0) {
							break;
						}
						else {
							arr[x][y] = 2;
							y++;
							answer++;
						}
					case 1 : 
						if (x + 1 >= n || arr[x + 1][y] != 0) {
							break;
						}
						else {
							arr[x][y] = 2;
							x++;
							answer++;
						}
					case 2 : 
						if (y - 1 < 0 || arr[x][y - 1] != 0) {
							break;
						}
						else {
							arr[x][y] = 2;
							y--;
							answer++;
						}
					case 3 : 
						if (x - 1 < 0 || arr[x - 1][y] != 0) {
							break;
						}
						else {
							arr[x][y] = 2;
							x--;
							answer++;
						}
				}
			}
		}
		
		System.out.println(answer);
	}
}
