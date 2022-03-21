package dev_matching;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Test1_1 {
	public static int[] solution(String[] purchase) throws Exception {
		int[] answer = new int[5];
		String strFirstDate = purchase[0].split(" ")[0];
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(strFirstDate));
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		
		for (int day = 1; day <= 365; day++) {
			int totalPrice = 0;
			
			for (int i = 0; i < purchase.length; i++) {
				String[] strSplit = purchase[i].split(" ");
				String strDate = strSplit[0];
				String strPrice = strSplit[1];
				
				calendar.setTime(format.parse(strDate));
				int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
				
				if (day - dayOfYear < 30 && day - dayOfYear >= 0) {
					totalPrice += Integer.parseInt(strPrice);
				}
			}
			
			if (10000 <= totalPrice && totalPrice < 20000) {
				answer[1]++;
			}
			else if (20000 <= totalPrice && totalPrice < 50000) {
				answer[2]++;
			}
			else if (50000 <= totalPrice && totalPrice < 100000) {
				answer[3]++;
			}
			else if (100000 <= totalPrice) {
				answer[4]++;
			}
			else {
				answer[0]++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		String[] arr = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
		System.out.println(Arrays.toString(solution(arr)));
	}
}
