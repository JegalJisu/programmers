package exam.dev_matching.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test03 {
	public static int solution(int n, int[][] edges, int k, int a, int b) {
		int answer = 0;
		boolean[] useRoad = new boolean[edges.length];
		Stack<Node> stack = new Stack<Node>();
		stack.add(new Node(a, 0, a + ""));
		List<Node> sucessList = new ArrayList<Node>();
		
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			
			for (int i = 0; i < edges.length; i++) {
				if (edges[i][0] == node.x && node.count + 1 <= k) {
					if (edges[i][1] == b) {
						sucessList.add(new Node(edges[i][1], node.count + 1, node.road + edges[i][1]));
					}
					else {
						stack.add(new Node(edges[i][1], node.count + 1, node.road + edges[i][1]));
					}
				}
				
				if (edges[i][1] == node.x && node.count + 1 <= k) {
					if (edges[i][0] == b) {
						sucessList.add(new Node(edges[i][0], node.count + 1, node.road + edges[i][0]));
					}
					else {
						stack.add(new Node(edges[i][0], node.count + 1, node.road + edges[i][0]));
					}
				}
			}
		}
		
		for (Node node : sucessList) {
			String road = node.road;
			System.out.println(road);
			
			for (int i = 0; i < road.length() - 1; i++) {
				int x = road.charAt(i) - '0';
				int y = road.charAt(i + 1) - '0';
				
				for (int j = 0; j < edges.length; j++) {
					if ((edges[j][0] == x && edges[j][1] == y) || (edges[j][0] == y && edges[j][1] == x)) {
						useRoad[j] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < useRoad.length; i++) {
			if (useRoad[i]) {
				System.out.println(Arrays.toString(edges[i]));
				answer++;
			}
		}
		
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
		
		solution(8, arr, 4, 0, 3);
	}
}

class Node {
	int x;
	int count;
	String road;
	
	Node (int x, int count,String road) {
		this.x = x;
		this.count = count;
		this.road = road;
	}
}