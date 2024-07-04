
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	// task 1
  
	
	public static String partialSolve (int x, int y) {
		String result ="";
		String xString = Integer.toBinaryString(Integer.max(x, -x));
		String yString = Integer.toBinaryString(Integer.max(y, -y));
		boolean xPos = (x<0) ? false : true;
		boolean yPos = (y<0) ? false : true;
	
		while (xString.length()<yString.length()) {
			xString="0"+xString;
		}
		while (yString.length()<xString.length()) {
			yString="0"+yString;
		}
		
		for (int i=0; i<xString.length();i++) {
			boolean xChar = (xString.charAt(xString.length()-1-i) == '1');
			boolean yChar = (yString.charAt(yString.length()-1-i) == '1');
			if ((xChar && yChar) || (!xChar && !yChar)) {
				return "IMPOSSIBLE";
			} else if (xChar) {
				if (xPos) {
					result += "E";
				} else {
					result += "W";
				}
			} else { // yChar
				if (yPos) {
					result += "N";
				} else {
					result += "S";
				}
			}
		}
		
		//result+=" ("+xString+","+yString+")";		
		// result berechnung - kann in falsche richting gehen => hiommelsrichtuing switchen
		return result;
	}
	
	public static int getNextBiggest (int x, int y) {
		String xString = Integer.toBinaryString(Integer.max(x, -x));
		String yString = Integer.toBinaryString(Integer.max(y, -y));
	
		while (xString.length()<yString.length()) {
			xString="0"+xString;
		}
		while (yString.length()<xString.length()) {
			yString="0"+yString;
		}
		
		return (int) Math.pow(2, xString.length());
	}
	
	public static String solve (int x, int y) {
		String result = Solution.partialSolve(x, y);
		if (!result.equals("IMPOSSIBLE")) return result;
		
		if (x>0) {
			result = Solution.partialSolve(x-Solution.getNextBiggest(x, y), y);
			if (!result.equals("IMPOSSIBLE")) return result+"E";
		} else {
			result = Solution.partialSolve(x+Solution.getNextBiggest(x, y), y);
			if (!result.equals("IMPOSSIBLE")) return result+"W";
		}

		if (y>0) {
			result = Solution.partialSolve(x, y-Solution.getNextBiggest(x, y));
			if (!result.equals("IMPOSSIBLE")) return result+"N";
		} else {
			result = Solution.partialSolve(x, y+Solution.getNextBiggest(x, y));
			if (!result.equals("IMPOSSIBLE")) return result+"S";
		}

		return "IMPOSSIBLE";
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
            System.out.println("Case #"+i+": "+Solution.solve (x,y));
		}
	}
}
