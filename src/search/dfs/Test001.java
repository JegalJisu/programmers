package search.dfs;

import java.util.Scanner;

// 책 문제1
public class Test001 {
	static int[][] valueArr;
	static boolean[][] isFirstArr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		
		valueArr = new int[n][m];
		isFirstArr = new boolean[n][m]; 
		
		for(int i = 0; i < valueArr.length; i++) {
			for (int j = 0; j < valueArr[i].length; j++) {
				valueArr[i][j] = sc.nextInt();
				isFirstArr[i][j] = true;
			}
		}
		
		for (int i = 0; i < valueArr.length; i++) {
			for (int j = 0; j < valueArr[i].length; j++) {
				if (valueArr[i][j] == 0 && isFirstArr[i][j]) {
					dfs(i, j);
					answer ++;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int i, int j) {
		if (0 <= i && i < valueArr.length &&
			0 <= j && j < valueArr[i].length &&
			valueArr[i][j] == 0 && isFirstArr[i][j]) {
			isFirstArr[i][j] = false;
			
			dfs(i + 1, j);
			dfs(i - 1, j);
			dfs(i, j + 1);
			dfs(i, j - 1);
		}
		else {
			return;
		}
	}
}
