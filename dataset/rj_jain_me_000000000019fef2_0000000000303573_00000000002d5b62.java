import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	static ArrayList<String> list = new ArrayList();
	public static void main(String[] args) {
		int T = s.nextInt();
		int testCase = 1;
		while(T>0) {
		    list.clear();
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
			findAnswer(x,y,0,0,0, "");
			int min = 0;
			for(int i = 1; i<list.size(); i++) {
				if(list.get(i).length() < list.get(min).length()) {
					min = i;
				}
			}
			String answer = "IMPOSSIBLE";
			if(list.size() != 0) {
				answer = list.get(min);
			}
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

	private static void findAnswer(int x, int y, int myX, int myY, int count, String ans) {
		if(myX == x && myY == y) {
			list.add(ans);
		}
		if(myX>x || myY>y) {
			return;
		}
		if(myX + (int)Math.pow(2, count) <= x) {
			findAnswer(x, y,myX+(int)Math.pow(2, count), myY, count+1, ans+"E");
		}
		if(myY + (int)Math.pow(2, count) <= y) {
			findAnswer(x, y,myX, myY+(int)Math.pow(2, count), count+1, ans+"N");
		}
		if(Math.abs(myX - (int)Math.pow(2, count)) <= x) {
			findAnswer(x, y,myX-(int)Math.pow(2, count), myY, count+1, ans+"W");
		}
		if(Math.abs(myY - (int)Math.pow(2, count)) <= y) {
			findAnswer(x, y,myX, myY-(int)Math.pow(2, count), count+1, ans+"S");
		}
		
		return;
	}

}
