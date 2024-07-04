import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int caseNo = 1;
		while(caseNo<=T) {
			int x = s.nextInt();
			int y = s.nextInt();
			String str = s.next();
			
			int answer = findAnswer(x,y,str);
			if(answer == -1) {
				System.out.println("Case #"+caseNo+": IMPOSSIBLE");
			} else {
				System.out.println("Case #"+caseNo+": "+answer);
			}
			
			caseNo++;
		}
	}

	static int findAnswer(int x, int y, String str) {
		if(x == 0 && y == 0) {
			return 0;
		}
		int cAt = 0;
		int time = 1;
		while(cAt<str.length()) {
			char ch = str.charAt(cAt);
			if(ch == 'S') {
				y--;
			}
			if(ch == 'W') {
				x--;
			}
			if(ch == 'N') {
				y++;
			}
			if(ch == 'E') {
				x++;
			}
			
			int timeReq = Math.abs(x)+Math.abs(y);
			if(timeReq <= time) {
				return time;
			}
			time++;
			cAt++;
		}
		
		return -1;
	}
}
