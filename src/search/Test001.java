package search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 1260
public class Test001 {
	static int n;
	static int m;
	static int v;
	static Node[] nodes;
	static Stack<Node> stack;
	static Queue<Node> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		nodes = new Node[n];
		
		for (int i = 1; i <= n; i++) {
			nodes[i - 1] = new Node(i);
		}
		
		for (int i = 0; i < m; i++) {
			int linkA = sc.nextInt();
			int linkB = sc.nextInt();
			
			if (!nodes[linkA - 1].adjacent.contains(nodes[linkB - 1])) {
				nodes[linkA - 1].adjacent.add(nodes[linkB - 1]);
			}
			if (!nodes[linkB - 1].adjacent.contains(nodes[linkA - 1])) {
				nodes[linkB - 1].adjacent.add(nodes[linkA - 1]);
			}
		}
		
		stack = new Stack<Node>();
		queue = new LinkedList<Node>();
		
		stack.add(nodes[v - 1]);
		queue.add(nodes[v - 1]);
		
		dfs();
		reset();
		bfs();
	}

	private static void dfs() {
		while(!stack.empty()) {
			Node node = stack.pop();
			node.adjacent.sort(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o2.value - o1.value;
				}
			});
			node.adjacent.forEach(nextNode -> {
				if (nextNode.isFirst) {
					stack.add(nextNode);
				}
			});
			
			if (node.isFirst) {
				System.out.print(node.value + " ");
				node.isFirst = false;
			}
		}
		System.out.println();
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			node.adjacent.sort(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.value - o2.value;
				}
			});
			node.adjacent.forEach(nextNode -> {
				if (nextNode.isFirst) {
					queue.add(nextNode);
				}
			});
			
			if (node.isFirst) {
				System.out.print(node.value + " ");
				node.isFirst = false;
			}
		}
		System.out.println();
	}
	
	private static void reset() {
		for (int i = 0; i < n; i++) {
			nodes[i].isFirst = true;
		}
	}
}

class Node {
	int value;
	boolean isFirst;
	LinkedList<Node> adjacent;
	
	Node(int value) {
		this.value = value;
		isFirst = true;
		adjacent = new LinkedList<Node>();
	}
}