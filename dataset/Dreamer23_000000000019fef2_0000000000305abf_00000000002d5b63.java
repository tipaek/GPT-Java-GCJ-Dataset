

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final String[] settings = in.nextLine().split(" ");
		final int t = Integer.parseInt(settings[0]);
		final int A = Integer.parseInt(settings[1]);
		final int B = Integer.parseInt(settings[2]);
	    for (int c = 1; c <= t; ++c) {
	        processCase(in, A, B);
	    }
	    in.close();
	}
	
	final static int halfDistance = 500000000;
	final static int fullDistance = 1000000000;
	
	private static void processCase(final Scanner in, final int minWidth, final int maxWidth) {
		// Okay, so if I find a point that's on the board, I can find all four of its edges (binary search
		// in each direction).
		// Once I have those, take the middle of both and done. Easy?? :)
		// Even for large, we are guaranteed that even the center, or one of the quarter centers are on the board.
		// Try those. Approx 30 throws per direction?	
		try {
			Point pointOnBoard = getStartingPoint(in);
			//System.out.println("What?");
			int left = binarySearchLeft(in, -fullDistance, pointOnBoard.x, pointOnBoard.y).x;
			int right = binarySearchRight(in, pointOnBoard.x, fullDistance, pointOnBoard.y).x;
			int up = binarySearchUp(in, -fullDistance, pointOnBoard.y, pointOnBoard.x).x;
			int down = binarySearchDown(in, pointOnBoard.y, fullDistance, pointOnBoard.x).x;
			//System.out.println((left+right)/2 + " / " + (up+down)/2);
			// Off by one errors :)
			for(int i = -1; i < 2; i++) for(int j = -1; j < 2; j++) throwDart(in, (left+right)/2+i, (up+down)/2+j);
		} catch (FoundCenterException e) {

		}
	}

	private static Point binarySearchLeft(Scanner in, int min, int max, int y) throws FoundCenterException {
		if(max - min <= 1) {
			return new Point(min, y);
		}
		int nextPoint = min + (Math.abs(max - min)/2);
		String r = throwDart(in, nextPoint, y);
		if (r.equals("HIT")) return binarySearchLeft(in, min, nextPoint, y);
		else return binarySearchLeft(in, nextPoint, max, y);
	}
	
	private static Point binarySearchRight(Scanner in, int min, int max, int y) throws FoundCenterException {
		if(max - min <= 1) {
			return new Point(max, y);
		}
		int nextPoint = min + (Math.abs(max - min)/2);
		String r = throwDart(in, nextPoint, y);
		if (r.equals("MISS")) return binarySearchRight(in, min, nextPoint, y);
		else return binarySearchRight(in, nextPoint, max, y);
	}
	
	private static Point binarySearchUp(Scanner in, int min, int max, int x) throws FoundCenterException {
		if(max - min <= 1) {
			return new Point(x, min);
		}
		int nextPoint = min + (Math.abs(max - min)/2);
		String r = throwDart(in, x, nextPoint);
		if (r.equals("HIT")) return binarySearchUp(in, min, nextPoint, x);
		else return binarySearchUp(in, nextPoint, max, x);
	}
	
	private static Point binarySearchDown(Scanner in, int min, int max, int x) throws FoundCenterException {
		if(max - min <= 1) {
			return new Point(x, max);
		}
		int nextPoint = min + (Math.abs(max - min)/2);
		String r = throwDart(in, x, nextPoint);
		if (r.equals("MISS")) return binarySearchDown(in, min, x, nextPoint);
		else return binarySearchDown(in, nextPoint, x, max);
	}
	
	private static Point getStartingPoint(Scanner in) throws FoundCenterException {
		String r = throwDart(in, 0, 0);
		if(r.equals("HIT")) return new Point(0, 0);
		r = throwDart(in, -halfDistance, 0);
		if(r.equals("HIT")) return new Point(-halfDistance, 0);
		r = throwDart(in, halfDistance, 0);
		if(r.equals("HIT")) return new Point(halfDistance, 0);
		r = throwDart(in, 0, halfDistance);
		if(r.equals("HIT")) return new Point(0, halfDistance);
		return new Point(0, -halfDistance);
	}
	
	private static String throwDart(Scanner in, int x, int y) throws FoundCenterException {
		System.out.println(x + " " + y);
		String res = in.nextLine();
		if(res.equals("CENTER")) throw new FoundCenterException();
		return res;
	}
	
	private static class FoundCenterException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private FoundCenterException() {
		}
	}
	
	private static class Point {
		private final int x, y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}