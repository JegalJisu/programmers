package practice.dataStructure;

import java.util.Scanner;
import java.util.Stack;

// 10828
public class Test001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt() + 1;
        String[] arr = new String[rows];

        for (int i = 0; i < rows; i++) {
            arr[i] = sc.nextLine();
        }

        Stack<Integer> stack = new Stack<>();
        for (String command : arr) {
            if (command.contains("push")) {
                String[] text = command.split(" ");
                stack.push(Integer.parseInt(text[1]));
            }

            if (command.contains("pop")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.pop());
                }
            }

            if (command.contains("size")) {
                System.out.println(stack.size());
            }

            if (command.contains("empty")) {
                if (stack.empty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }

            if (command.contains("top")) {
                if (stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
