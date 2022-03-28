package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2178
public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] textArr = new String[n];
		int[][] roadArr = new int[n][m];
		int[][] valueArr = new int[n][m];
		
		for (int i = 0; i < textArr.length; i++) {
			textArr[i] = sc.next();
		}
		
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				roadArr[y][x] = textArr[y].charAt(x) - '0';
			}
		}
		
		valueArr[0][0] = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.add("0,0");
		
		while (!queue.isEmpty()) {
			String text = queue.poll();
			
			int x = Integer.parseInt(text.split(",")[0]);
			int y = Integer.parseInt(text.split(",")[1]);
			
			if (x == m - 1 && y == n - 1) {
				System.out.println(valueArr[y][x]);
				queue.clear();
			}
			else {
				if (x + 1 < m && roadArr[y][x + 1] == 1 && valueArr[y][x + 1] == 0) {
					valueArr[y][x + 1] = valueArr[y][x] + 1;
					queue.add((x + 1) + "," + y);
				}
				
				if (x - 1 >= 0 && roadArr[y][x - 1] == 1 && valueArr[y][x - 1] == 0) {
					valueArr[y][x - 1] = valueArr[y][x] + 1;
					queue.add((x - 1) + "," + y);
				}
				
				if (y + 1 < n && roadArr[y + 1][x] == 1 && valueArr[y + 1][x] == 0) {
					valueArr[y + 1][x] = valueArr[y][x] + 1;
					queue.add(x + "," + (y + 1));
				}
				
				if (y - 1 >= 0 && roadArr[y - 1][x] == 1 && valueArr[y - 1][x] == 0) {
					valueArr[y - 1][x] = valueArr[y][x] + 1;
					queue.add(x + "," + (y - 1));
				}
			}
		}
	}
}
