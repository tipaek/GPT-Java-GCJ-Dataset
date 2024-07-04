import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	
	private static int next2pow(long val) {
		int result = 1;
		while(result <= val) 
			result *= 2;
		return result;
	}
	
	private static boolean is2pow(int val) {
		if (val == 1)
			return true;
		if (val % 2 == 1)
			return false;
		return is2pow(val / 2);
	}
	
	private static boolean test(int xnext, int xd, int ynext, int yd) {
		if ((xnext & xd) != 0)
			return false;
		if ((xnext & ynext) != 0)
			return false;
		if ((xnext & yd) != 0)
			return false;
		if ((xd & ynext) != 0)
			return false;
		if ((xd & yd) != 0)
			return false;
		if ((ynext & yd) != 0)
			return false;
		int stuff = xnext | xd | ynext | yd;
		stuff++;
		return is2pow(stuff);
	}
	
	private static String translate(int xnext, int xd, int ynext, int yd) {
		StringBuilder result = new StringBuilder();
		int i = 1;
		while(i <= xnext || i <= xd || i <= ynext || i <= yd) {
			if ((i & xnext) != 0)
				result.append("E");
			else if ((i & xd) != 0)
				result.append("W");
			else if ((i & ynext) != 0)
				result.append("N");
			else if ((i & yd) != 0)
				result.append("S");
			i *= 2;
		} 
		return result.toString();
	}
	
	private static String process(Scanner in) {
		int X = in.nextInt();
		int Y = in.nextInt();
		
		int x = Math.abs(X);
		int y = Math.abs(Y);
		
		int xnext = next2pow(x);
		int xd = xnext - x;
		int ynext = next2pow(y);
		int yd = ynext - y;
		
		//System.out.println(x + " " + y + " " + xnext + " " + xd + " " + ynext + " " + yd);
		
		String result = null;		
		
		if (test(x, 0, y, 0)) {
			//System.out.println("ok1");
			result = translate(x, 0, y, 0);
		}
		else if (test(xnext, xd, y, 0)) {
			//System.out.println("ok2");
			result = translate(xnext, xd, y, 0);
		}
		else if (test(x, 0, ynext, yd)) {
			//System.out.println("ok3");
			result = translate(x, 0, ynext, yd);
		}
		else if (test(xnext, xd, ynext, yd)) {
			//System.out.println("ok4");
			result = translate(xnext, xd, ynext, yd);
		}

		if (result == null)
			return "IMPOSSIBLE";
				
		if (X < 0) 
			result = exchange(result, "E", "W");
		
		if (Y < 0) 
			result = exchange(result, "S", "N");
					
		return result;					
	}

	private static String exchange(String result, String c1, String c2) {
		result = result.replaceAll(c1, "X");
		result = result.replaceAll(c2, c1);
		result = result.replaceAll("X", c2);
		return result;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}
