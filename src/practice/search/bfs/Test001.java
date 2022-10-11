package practice.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1697
public class Test001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[100001];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		int num = 0;
		arr[n] = 1;
		
		while(!queue.isEmpty()) {
			num = queue.poll();
			
			if (num == m) {
				System.out.println(arr[num] - 1);
				queue.clear();
			}
			else {
				if (num-1 >= 0 && arr[num-1] == 0) {
					arr[num - 1] = arr[num] + 1;
					queue.add(num - 1);
				}
				if (num + 1 <= 100000 && arr[num+1] == 0) {
					arr[num + 1] = arr[num] + 1;
					queue.add(num + 1);
				}
				if (num * 2 <= 100000 && arr[num * 2] == 0) {
					arr[num * 2] = arr[num] + 1;
					queue.add(num * 2);
				}
			}
		}
	}
}
