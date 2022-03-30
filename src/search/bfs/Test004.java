package search.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 2667
public class Test004 {
	static boolean[][] overlap;
	static int[][] arr;
	
	static int[] positionX = {0, 0, 1, -1};
	static int[] positionY = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String text = new String();
		overlap = new boolean[n][n];
		arr = new int[n][n];
		Queue<Dot> queue = new LinkedList<Dot>();
		List<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			text = sc.next();
			for (int j = 0; j < text.length(); j++) {
				arr[i][j] = text.charAt(j) - '0';
			}
		}
		
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				if (arr[y][x] == 1 && !overlap[y][x]) {
					answer++;
					int count = 0;
					overlap[y][x] = true;
					queue.add(new Dot(x, y));
					
					while (!queue.isEmpty()) {
						count++;
						Dot dot = queue.poll();
						
						for (int i = 0; i < positionX.length; i++) {
							int nX = dot.x + positionX[i];
							int nY = dot.y + positionY[i];
							
							if (0 <= nX && nX < n && 0 <= nY && nY < n &&
								arr[nY][nX] == 1 && !overlap[nY][nX]) {
								overlap[nY][nX] = true;
								queue.add(new Dot(nX, nY));
							}
						}
					}
					
					list.add(count);
				}
			}
		}
		
		System.out.println(answer);
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

class Dot {
	int x;
	int y;
	
	Dot (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
