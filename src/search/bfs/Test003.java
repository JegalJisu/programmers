package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 7576
public class Test003 {
	static int[][] arr;
	static int n;
	static int m;
	static boolean[][] overlap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m][n];
		overlap = new boolean[m][n];
		Queue<String> queue = new LinkedList<String>();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		if (noTomato()) {
			System.out.println(-1);
			return;
		}
		
		while(true) {
			answer++;
			
			for (int y = 0; y < arr.length; y++) {
				for (int x = 0; x < arr[y].length; x++) {
					if (arr[y][x] == 1 && !overlap[y][x]) {
						overlap[y][x] = true;
						queue.add(x + "," + y);
					}
				}
			}
			
			while (!queue.isEmpty()) {
				String text = queue.poll();
				
				int x = Integer.parseInt(text.split(",")[0]);
				int y = Integer.parseInt(text.split(",")[1]);
				
				if (x + 1 < arr[y].length && arr[y][x + 1] == 0) {
					arr[y][x + 1] = 1;
				}
				
				if (x - 1 >= 0 && arr[y][x - 1] == 0) {
					arr[y][x - 1] = 1;
				}
				
				if (y + 1 < arr.length && arr[y + 1][x] == 0) {
					arr[y + 1][x] = 1;
				}
				
				if (y - 1 >= 0 && arr[y - 1][x] == 0) {
					arr[y - 1][x] = 1;
				}
			}
			
			if (allTomato()) {
				break;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean noTomato() {
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				if (arr[y][x] == 0) {
					if ((x + 1 >= arr[y].length || arr[y][x + 1] == -1) &&
						(x - 1 < 0 || arr[y][x - 1] == -1) &&
						(y + 1 >= arr.length || arr[y + 1][x] == -1) &&
						(y - 1 < 0 || arr[y - 1][x] == -1)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	static boolean allTomato() {
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				if (arr[y][x] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
