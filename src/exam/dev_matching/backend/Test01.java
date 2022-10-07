package dev_matching.backend;

import java.util.Arrays;

public class Test01 {
	public static int[][] solution(int[][] dist) {
		int[][] answer = new int[2][dist.length];
		Line line = new Line();
		int longest = Integer.MIN_VALUE;
		
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				if (dist[i][j] != 0 && longest < dist[i][j]) {
					longest = dist[i][j];
					line = new Line(i, j, dist[i][j]);
				}
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			int index = 0;
			
			if (i % 2 == 0) {
				index = line.x;
			}
			else {
				index = line.y;
			}
			
			int[] arr = Arrays.copyOf(dist[index], dist.length);
			Arrays.sort(arr);
			
			for (int j = 1; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					if (arr[j] == dist[index][k]) {
						answer[i][j] = k;
					}
				}
			}
			answer[i][0] = index;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println('?' - 'a');
	}
}

class Line {
	int x;
	int y;
	int m;
	
	Line () {
		x = 0;
		y = 0;
		m = 0;
	}
	
	Line (int x, int y, int m) {
		if (x > y) {
			this.x = y;
			this.y = x;
		}
		else {
			this.x = x;
			this.y = y;
		}
		
		this.m = m;
	}

	@Override
	public String toString() {
		return "Line [x=" + x + ", y=" + y + ", m=" + m + "]";
	}
}
