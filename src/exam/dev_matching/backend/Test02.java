package exam.dev_matching.backend;

import java.util.Arrays;

public class Test02 {
	public int solution(String[] grid) {
		int answer = 0;
		int useIndex = 0;
		int[][] arr = new int[grid.length][grid[0].length()];
		boolean[][] preArr = new boolean[grid.length][grid[0].length()];
		int[] disX = {0 ,0 ,1, -1};
		int[] disY = {1, -1, 0, 0};
		int[] useNum = new int[3];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = grid[i].charAt(j) - 'a' + 1;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != ('?' - 'a' + 1) && !preArr[i][j]) {
					useNum[useIndex++] = arr[i][j];
					preArr[i][j] = true;
					
					for (int k = 0; k < disX.length; k++) {
						int ni = i + disX[k];
						int nj = j + disY[k];
						
						if (0 <= ni && ni < arr.length &&
							0 <= nj && nj < arr[i].length &&
							arr[ni][nj] == arr[i][j]) {
							preArr[ni][nj] = true;
						}
					}
				}
			}
		}
		
		return 0;
	}
}
