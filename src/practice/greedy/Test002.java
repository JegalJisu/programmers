package practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 1931
// 활동 선택 문제
// 간단하게 끝나는시간을 정렬해서 찾는 방법
public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		int endTime = 0;
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				else {
					return o1[1] - o2[1];
				}
			}
		});
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				endTime = arr[i][1];
				answer++;
			}
			else if (endTime <= arr[i][0]) {
				endTime = arr[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
