package greedy;

import java.util.Scanner;

// 13305
// 각 주유소를 지날때마다 최저 금액을 기록하여 거리를 곱함
public class Test005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long answer = 0;
		long lowCost = Long.MAX_VALUE;
		int n = sc.nextInt();
		long[] km = new long[n - 1];
		long[] point = new long[n];
		
		for (int i = 0; i < km.length; i++) {
			km[i] = sc.nextLong();
		}
		
		for (int i = 0; i < point.length; i++) {
			point[i] = sc.nextLong();
		}
		
		for (int i = 0; i < km.length; i++) {
			if (lowCost > point[i]) {
				lowCost = point[i];
			}
			
			answer += lowCost * km[i];
		}
		
		System.out.println(answer);
	}
}
