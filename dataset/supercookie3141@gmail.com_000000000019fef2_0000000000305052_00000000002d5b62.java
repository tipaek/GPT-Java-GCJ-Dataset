import java.util.Scanner;

public class Solution {
	public static String answer(int x, int y, int curX, int curY, int curJump, String answer) {
		if(curX == x && curY == y) {
			return answer;
		}
		
		int jumpLength = (int) Math.pow(2, curJump);
		
		if(jumpLength > (Math.abs(x) + Math.abs(y))) {
			return "IMPOSSIBLE";
		}
		
		if(curX + jumpLength == x) {
			return answer(x, y, curX + jumpLength, curY, curJump + 1, answer + "E");
		}
		else if(curX - jumpLength == x) {
			return answer(x, y, curX - jumpLength, curY, curJump + 1, answer + "W");
		}
		else if(curY + jumpLength == y) {
			return answer(x, y, curX, curY + jumpLength, curJump + 1, answer + "N");
		}
		else if(curY - jumpLength == x) {
			return answer(x, y, curX, curY - jumpLength, curJump + 1, answer + "S");
		}
		else {
			String test = answer(x, y, curX + jumpLength, curY, curJump + 1, answer + "E");
			if(test.equals("IMPOSSIBLE")) {
				test = answer(x, y, curX - jumpLength, curY, curJump + 1, answer + "W");
				if(test.equals("IMPOSSIBLE")) {
					test = answer(x, y, curX, curY + jumpLength, curJump + 1, answer + "N");
					if(test.equals("IMPOSSIBLE")) {
						test = answer(x, y, curX, curY - jumpLength, curJump + 1, answer + "S");
					}
				}
			}
			return test;
		}
	}
	
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int x = kboard.nextInt();
			int y = kboard.nextInt();
			String answer = "";
			
			if((x + y) % 2 == 0) {
				answer = "IMPOSSIBLE";
			}
			else {
				answer = answer(x, y, 0, 0, 0, "");
			}
			
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
