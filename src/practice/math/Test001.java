package practice.math;

import java.util.Calendar;
import java.util.Scanner;

// 2884
public class Test001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.add(Calendar.MINUTE, -45);

        System.out.println(cal.get(Calendar.HOUR_OF_DAY) + " " + cal.get(Calendar.MINUTE));
    }
}
