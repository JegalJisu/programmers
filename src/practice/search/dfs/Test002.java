package search.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

// 2606
public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		Node002[] nodes = new Node002[n];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node002(i + 1);
		}
		
		for (int i = 0; i < m; i++) {
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();
			
			nodes[input1 - 1].addContact(nodes[input2 - 1]);
			nodes[input2 - 1].addContact(nodes[input1 - 1]);
		}
		
		Stack<Node002> stack = new Stack<Node002>();
		Set<Integer> set = new HashSet<Integer>();
		stack.add(nodes[0]);
		
		while (!stack.isEmpty()) {
			Node002 mainNode = stack.pop();
			
			for (Node002 contactNode : mainNode.contact) {
				contactNode.removeContact(mainNode);
				stack.add(contactNode);
			}
			
			mainNode.resetContact();
			set.add(mainNode.num);
		}
		
		System.out.println(set.size() - 1);
	}
}

class Node002 {
	int num;
	Set<Node002> contact;
	
	Node002 (int num) {
		this.num = num;
		contact = new HashSet<Node002>();
	}
	
	void addContact(Node002 node) {
		contact.add(node);
	}
	
	void removeContact(Node002 node) {
		contact.remove(node);
	}
	
	void resetContact () {
		contact = new HashSet<Node002>();
	}
}