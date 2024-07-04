import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i=0; i<testCase; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String path = sc.next();
			
			System.out.println("Case #" + (i+1) + ": " + solution(X, Y, path));
		}
	}

	private static String solution(int x, int y, String path) {
		if (x+y ==0) {
			return "0";
		}
		for (int i=1; i<=path.length(); i++) {
			char dir = path.charAt(i-1);
			if (dir == 'S') {
				y--;
			} else if (dir == 'N') {
				y++; 
			} else if (dir == 'E') {
				x++;
			} else if (dir == 'W') {
				x--;
			}
			int dis = Math.abs(x)+Math.abs(y);
			if (dis <= i) {
				return i + "";
			}
		}
		
		return "IMPOSSIBLE";
	}
}
