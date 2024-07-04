import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testcase = 1; testcase <= t; ++testcase) {
			int X = in.nextInt();
			int Y = in.nextInt();
			String jumpPossible = findJump(Math.abs(X), Math.abs(Y));
			
			if (jumpPossible != null) {
				jumpPossible = setQuadrant(X, Y, jumpPossible);
				System.out.println("Case #" + testcase + ": " + jumpPossible);
			} else {
				System.out.println("Case #" + testcase + ": IMPOSSIBLE");
			}
		}
	}

	private static String setQuadrant(int x, int y, String jumpPossible) {
		if (x >=0 && y >= 0)
			return jumpPossible;
		if (x >=0 && y <= 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < jumpPossible.length(); i++) {
				switch (jumpPossible.charAt(i)) {
				case 'N':
					sb.append('S');
					break;
				case 'S':
					sb.append('N');
					break;
				default:
					sb.append(jumpPossible.charAt(i));
					break;
				}
			}
			return sb.toString();
		}
		if (x <=0 && y >= 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < jumpPossible.length(); i++) {
				switch (jumpPossible.charAt(i)) {
				case 'E':
					sb.append('W');
					break;
				case 'W':
					sb.append('E');
					break;
				default:
					sb.append(jumpPossible.charAt(i));
					break;
				}
			}
			return sb.toString();
		}
		if (x <=0 && y <= 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < jumpPossible.length(); i++) {
				switch (jumpPossible.charAt(i)) {
				case 'E':
					sb.append('W');
					break;
				case 'W':
					sb.append('E');
					break;
				case 'N':
					sb.append('S');
					break;
				case 'S':
					sb.append('N');
					break;
				default:
					break;
				}
			}
			return sb.toString();
		}
		return null;
	}

	private static String findJump(int x, int y) {
		String binX = Integer.toBinaryString(x);
		String binY = Integer.toBinaryString(y);
		StringBuffer sbSouth = new StringBuffer();
		StringBuffer sbNorth = new StringBuffer();
		int curYSouth = 0;
		int curYNorth = 0;
		int curX = 0;
		int jump = 1;
		for (int i = 0; i < binX.length(); i++) {
			if ((x & jump) == 0) {
				sbNorth.append('N');
				sbSouth.append('S');
				curYSouth = curYSouth - jump;
				curYNorth = curYNorth + jump;
			} else {
				sbNorth.append('E');
				sbSouth.append('E');
				curX = curX + jump;
			}
			jump = jump * 2;
		}
		if (curYNorth > y) {
			int newJump = jump;
			while (curYNorth > y) {
				curYNorth = curYNorth - newJump;
				sbNorth.append('S');
				newJump = newJump * 2;
			}
			if (curYNorth == y)
				return sbNorth.toString();
		} else {
			int newJump = jump;
			while (curYNorth < y) {
				curYNorth = curYNorth + newJump;
				sbNorth.append('N');
				newJump = newJump * 2;
			}
			if (curYNorth == y)
				return sbNorth.toString();
		}
		int newJump = jump;
		while (curYSouth < y) {
			curYSouth = curYSouth + newJump;
			sbSouth.append('N');
			newJump = newJump * 2;
		}
		if (curYSouth == y)
			return sbSouth.toString();
		return null;
	}
}