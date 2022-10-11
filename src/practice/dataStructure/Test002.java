package practice.dataStructure;

import java.util.Scanner;

// 9012
public class Test002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] rows = new String[t];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = sc.next();
        }

        for (String row : rows) {
            int count = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '(') {
                    count++;
                }
                else if (row.charAt(i) == ')') {
                    count--;
                }

                if (count < 0) {
                    System.out.println("NO");
                    break;
                }
            }

            if (count == 0) {
                System.out.println("YES");
            }
            else if (count > 0){
                System.out.println("NO");
            }
        }
    }
}
