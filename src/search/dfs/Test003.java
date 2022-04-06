package search.dfs;

import java.util.Scanner;

public class Test003 {
	static int[] positionX = {1, -1, 0, 0};
	static int[] positionY = {0, 0, 1, -1};
	static String[] arr;
	static int n;
	static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new String[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		System.out.println(dfs(0, 0, 1, arr[0].charAt(0) + ""));
	}
	
	static int dfs (int x, int y, int count, String road) {
		int answer = Integer.MIN_VALUE;
		
		for (int i = 0; i < positionX.length; i++) {
			int moveX = x + positionX[i];
			int moveY = y + positionY[i];
			
			if (0 <= moveX && moveX < m &&
				0 <= moveY && moveY < n) {
				String next = arr[moveY].charAt(moveX) + "";
				
				if (!road.contains(next)) {
					int num = dfs(moveX, moveY, count + 1, road + next);
					
					if (answer < num) {
						answer = num;
					}
				}
			}
		}
		
		return answer > count ? answer : count;
	}
}

class Node003 {
	int count;
	int x;
	int y;
	String name;
	StringBuffer road;
	
	Node003 (String name, String road, int count, int x, int y) {
		this.name = name;
		this.road = new StringBuffer(road);
		this.count = count;
		this.x = x;
		this.y = y;
	}
}