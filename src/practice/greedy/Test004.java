package practice.greedy;

import java.util.Scanner;

// 1541
public class Test004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String text = sc.next();
		int answer = 0;
		String[] minus = text.split("-");
		
		for (int i = 0; i < minus.length; i++) {
			int sum = 0;
			
			if (minus[i].contains("+")) {
				for (String plus : minus[i].split("\\+")) {
					sum += Integer.parseInt(plus);
				}
			}
			else {
				sum += Integer.parseInt(minus[i]);
			}
			
			if (i == 0) {
				answer += sum;
			}
			else {
				answer -= sum;
			}
		}
		
		System.out.println(answer);
	}
}
