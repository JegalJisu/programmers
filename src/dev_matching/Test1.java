package dev_matching;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test1 {
	public static int[] solution(String[] purchase) throws Exception {
		int[] answer = new int[5];
		
		for (int i = 0; i < purchase.length; i ++) {
			String[] strSplit = purchase[i].split(" ");
			String strDate = strSplit[0];
			String strPrice = strSplit[1];
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(format.parse(strDate));
			int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
			int totalPrice = Integer.parseInt(strPrice);
			
			for (int j = 0; j < i; i ++) {
				String[] strSplit2 = purchase[j].split(" ");
				String strDate2 = strSplit2[0];
				String strPrice2 = strSplit2[1];
				
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(format.parse(strDate2));
				int dayOfYear2 = calendar2.get(Calendar.DAY_OF_YEAR);
				
				if (dayOfYear - dayOfYear2 <= 30) {
					totalPrice += Integer.parseInt(strPrice2);
				}
			}
			
			if (10000 <= totalPrice && totalPrice < 20000) {
				
			}
			else if (20000 <= totalPrice && totalPrice < 50000) {
				
			}
			else if (50000 <= totalPrice && totalPrice < 100000) {
				
			}
			else if (100000 <= totalPrice) {
				
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		String[] arr = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
		solution(arr);
	}
}
