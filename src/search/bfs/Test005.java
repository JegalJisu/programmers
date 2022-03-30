package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1012
public class Test005 {
	static boolean[][] overlap;
	static int[][] arr;
	
	static int[] positionX = {0, 0, 1, -1};
	static int[] positionY = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int			n		= sc.nextInt();
			int			m		= sc.nextInt();
			int			k		= sc.nextInt();
			int			answer	= 0;
			Queue<Dot2>	queue	= new LinkedList<Dot2>();
			
			arr = new int [n][m];
			overlap = new boolean[n][m];
			
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = 1;
			}
			
			for (int y = 0; y < arr.length; y++) {
				for (int x = 0; x < arr[y].length; x++) {
					if (arr[y][x] == 1 && !overlap[y][x]) {
						answer++;
						overlap[y][x] = true;
						queue.add(new Dot2(x,y));
						
						while (!queue.isEmpty()) {
							Dot2 dot = queue.poll();
							
							for (int j = 0; j < positionX.length; j++) {
								int nX = dot.x + positionX[j];
								int nY = dot.y + positionY[j];
								
								if (0 <= nX && nX < m && 0 <= nY && nY < n &&
									arr[nY][nX] == 1 && !overlap[nY][nX]) {
									overlap[nY][nX] = true;
									queue.add(new Dot2(nX, nY));
								}
							}
						}
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}

class Dot2 {
	int x;
	int y;
	
	Dot2 (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
