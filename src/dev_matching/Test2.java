package dev_matching;

public class Test2 {
	public static int solution(int h, int w, int n, String[] board) {
		int answer = 0;
		
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length(); x++) {
				if (board[y].charAt(x) == '0') {
					continue;
				}
				
				int count = 1;
				
				// 가로
				if (w - x >= n) {
					for (int i = 1; i < board[y].length() - x; i++) {
						if (board[y].charAt(x + i) == '0') {
							break;
						}
						else {
							count++;
						}
					}
					
					if (count == n && (x == 0 || board[y].charAt(x - 1) == '0')) {
						answer++;
					}
					count = 1;
				}
				
				// 세로
				if (h - y >= n) {
					for (int i = 1; i < board.length - y; i++) {
						if (board[y + i].charAt(x) == '0') {
							break;
						}
						else {
							count++;
						}
					}
					
					if (count == n && (y == 0 || board[y - 1].charAt(x) == '0')) {
						answer++;
					}
					count = 1;
				}
				
				// 우측 사선
				if (w - x >= n && h - y >= n) {
					for (int i = 1; i < board[y].length() - x && i < board.length - y; i++) {
						if (board[y + i].charAt(x + i) == '0') {
							break;
						}
						else {
							count++;
						}
					}
					
					if (count == n && (y == 0 || x == 0 || board[y - 1].charAt(x - 1) == '0')) {
						answer++;
					}
					count = 1;
				}
				
				// 좌측 사선
				if (w - (w - x) >= n - 1 && h - y >= n) {
					for (int i = 1; i < board[y].length() - (w - x - 1) && i < board.length - y; i++) {
						if (board[y + i].charAt(x - i) == '0') {
							break;
						}
						else {
							count++;
						}
					}
					
					if (count == n && (y == 0 || x == w || board[y - 1].charAt(x + 1) == '0')) {
						answer++;
					}
					count = 1;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] arr = {"11111", "11111", "11111", "11111", "11111"};
		System.out.println(solution(5,5,5, arr));
	}
}
