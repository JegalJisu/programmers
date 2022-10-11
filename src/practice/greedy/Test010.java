package practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 1946
// 문제 및 시간초과로 인해 참조
// https://zzang9ha.tistory.com/51 
public class Test010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 계속 값을 변경해줘야할때 String보다 메모리를 덜 사용한다.
		StringBuffer sb = new StringBuffer();
		
		// 처음입력한 n만큼 반복
		for (int i = 0; i < n; i++) {
			int person = sc.nextInt();
			int[][] arr = new int[person][2];
			// 정렬을 할건데 arr[0][0] 값이 1이므로 비교상대가 존재하지 않아 값을 1로 고정
			int answer = 1;
			int index = 0;
			
			for (int j = 0; j < arr.length; j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = sc.nextInt();
			}
			
			// arr을 [][0]의 값으로 정렬
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			// arr[0][1]을 기준으로 이 값이 더 낮은 사람을 찾으면 카운트하고
			// 기준값을 더 낮은 사람의 것으로 변경한다.
			
			// arr[][1]의 값이 낮으면
			// arr[][0]이 오름차순으로 정렬이 되있기 때문에
			// 두 가지 성적 다 낮은 사람이 되므로 카운트하지 않는다.
			index = arr[0][1];
			for (int j = 0; j < arr.length; j++) {
				if (index > arr[j][1]) {
					index = arr[j][1];
					answer++;
				}
			}
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
