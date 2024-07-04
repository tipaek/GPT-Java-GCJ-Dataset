
import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T;
	
	int X, Y;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int merp = 1; merp <= T; merp++) {
			Solution s = new Solution();
			s.solve(merp);
		}
		
		in.close();
	}
	
	void solve(int c) {
		readInput();
		
		int n =(int) Math.floor((Math.log(Math.abs(X) + Math.abs(Y)) / Math.log(2)));
		String result = findPath(0, 0, n);
		
		if(result == null)
			System.out.println("Case #" + c + ": " + "IMPOSSIBLE");
		else
			System.out.println("Case #" + c + ": " + result);
	}
	
	void readInput() {
		X = in.nextInt();
		Y = in.nextInt();
	}
	
	String findPath(int x, int y, int n) {
		if(n == -1) {
			if(x == X && y == Y)
				return "";
			else
				return null;
		}
		
		String ret;
		int x2, y2, n2;
		if(Math.abs(X - x) > Math.abs(Y - y)) {
			if(X > x) {
				// go right
				ret = "E";
				x2 = x + (int) Math.pow(2, n);
			} else {
				// go left
				ret = "W";
				x2 = x - (int) Math.pow(2, n);
			}
			
			y2 = y;
		} else {
			if(Y > y) {
				// go up
				ret = "N";
				y2 = y + (int) Math.pow(2, n);
			} else {
				// go down
				ret = "S";
				y2 = y - (int) Math.pow(2, n);
			}
			
			x2 = x;
		}
		
		n2 = n - 1;
		
		String result = findPath(x2, y2, n2);
		if(result == null) {
			return null;
		} else {
			return result + ret; 
		}
	}
}
