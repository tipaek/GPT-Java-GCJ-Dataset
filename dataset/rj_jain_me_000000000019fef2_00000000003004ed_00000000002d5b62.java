import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int testCase = 1;
		while(T>0) {
			boolean checkX = false;
			boolean checkY = false;
			int x = s.nextInt();
			if(x<0) {
				checkX = true;
				x = Math.abs(x);
			}
			int y = s.nextInt();
			if(y<0) {
				checkY = true;
				y = Math.abs(y);
			}
			String answer = findAnswer(x,y,0,0,0, "");
			StringBuilder s = new StringBuilder();
			if(answer != "IMPOSSIBLE") {
				for(int i = 0; i<answer.length(); i++) {
					if(answer.charAt(i) == 'E') {
						if(checkX) {
							s.append('W');
						} else {
							s.append('E');
						}
					}
					if(answer.charAt(i) == 'W') {
						if(checkX) {
							s.append('E');
						} else {
							s.append('W');
						}
					}
					if(answer.charAt(i) == 'S') {
						if(checkY) {
							s.append('N');
						} else {
							s.append('S');
						}
					}
					if(answer.charAt(i) == 'N') {
						if(checkY) {
							s.append('S');
						} else {
							s.append('N');
						}
					}
				}
			} else {
				System.out.println("Case #"+testCase+": "+answer);
				testCase++;
				T--;
				continue;
			}
			String str = s.toString();
			System.out.println("Case #"+testCase+": "+str);
			testCase++;
			T--;
		}
	}
	
	private static String findAnswer(int x, int y, int myX, int myY, int count, String ans) {
		if(myX == x && myY == y) {
			return ans;
		}
		if(myX>x || myY>y) {
			return "IMPOSSIBLE";
		}
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		if(myX + (int)Math.pow(2, count) <= x) {
			a = findAnswer(x, y,myX+(int)Math.pow(2, count), myY, count+1, ans+"E");
			if(a != "IMPOSSIBLE") {
				return a;
			}
		}
		if(myY + (int)Math.pow(2, count) <= y) {
			b = findAnswer(x, y,myX, myY+(int)Math.pow(2, count), count+1, ans+"N");
			if(b != "IMPOSSIBLE") {
				return b;
			}
		}
		if(Math.abs(myX - (int)Math.pow(2, count)) <= x) {
			c = findAnswer(x, y,myX-(int)Math.pow(2, count), myY, count+1, ans+"W");
			if(c != "IMPOSSIBLE") {
				return c;
			}
		}
		if(Math.abs(myY - (int)Math.pow(2, count)) <= y) {
			d = findAnswer(x, y,myX, myY-(int)Math.pow(2, count), count+1, ans+"S");
			if(d != "IMPOSSIBLE") {
				return d;
			}
		}
		
		return "IMPOSSIBLE";
	}

}
