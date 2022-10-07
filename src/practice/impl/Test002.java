package impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

// 책 문제 1
public class Test002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int answer = 0;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		while (true) {
			cal.add(Calendar.SECOND, 1);
			
			if (cal.get(Calendar.HOUR_OF_DAY) == n + 1) {
				break;
			}
			
			if (sdf.format(cal.getTime()).contains("3")) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
