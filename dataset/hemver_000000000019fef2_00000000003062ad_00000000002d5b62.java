import java.util.*;
import java.io.*;

/**
 * problem 1
 */
public class Solution {
	
	public static void main(String[] args) {
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//fetch the number of test cases
		int testCaseNumber = in.nextInt();
		//fetch the first matrix number
		for (int test = 1; test <= testCaseNumber; test++) {
			List<Double> listOfMoves = new ArrayList<Double>();
			int xcor = in.nextInt();
			int ycor = in.nextInt();
			String move = findMoves(listOfMoves, xcor, ycor);
			System.out.println("Case #" + test + ": " + move);
		}
		in.close();
	}

	private static String findMoves(List<Double> listOfMoves, int xcor, int ycor) {
		StringBuilder result = new StringBuilder();
		int modx = Math.abs(xcor);
		int mody = Math.abs(ycor);
		List<Integer> movex = new ArrayList<Integer>();
		List<Integer> movey = new ArrayList<Integer>();
		boolean xdone = false;
		boolean ydone = false;
		for (int i = 0; i <= Math.max(modx, mody); i++) {
			listOfMoves.add(Math.pow(2, i));
		}
		for (Double move : listOfMoves) {
			if (move.intValue() == modx && !xdone) {
				movex.add(xcor < 0 ? move.intValue() * -1 : move.intValue());
				xdone = true;
				listOfMoves.remove(move);
				break;
			} 
		}
		for (Double move : listOfMoves) {
			if (move.intValue() == mody && !ydone) {
				movey.add(ycor < 0 ? move.intValue() * -1 : move.intValue());
				ydone = true;
				listOfMoves.remove(move);
				break;
			}
		}
		if (xcor == 0) {
			xdone = true;
		}
		if (ycor == 0) {
			ydone = true;
		}
		if (!xdone) {
			if (modx == 3) { 
				if (mody == 2) {
					if (xcor > 0) {
						movex.add(-1);
						movex.add(4);
						xdone = true;
					} else {
						movex.add(1);
						movex.add(-4);
						xdone = true;
					}
				} else if (mody == 0) {
					if (xcor > 0) {
						movex.add(1);
						movex.add(2);
						xdone = true;
					} else {
						movex.add(-1);
						movex.add(-2);
						xdone = true;
					}
				} else {
				return "IMPOSSIBLE";
				}
			}
		}
		if (!ydone) {
			if (mody == 3) { 
				if (modx == 2) {
					if (ycor > 0) {
						movey.add(-1);
						movey.add(4);
						ydone = true;
					} else {
						movey.add(1);
						movey.add(-4);
						ydone = true;
					}
				} else if (modx == 0) {
					if (ycor > 0) {
						movey.add(1);
						movey.add(2);
						ydone = true;
					} else {
						movey.add(-1);
						movey.add(-2);
						ydone = true;
					}
				} else {
				return "IMPOSSIBLE";
				}
			}
		}
		if (!xdone || !ydone) {
			return "IMPOSSIBLE";
		}
		int xindex = 0;
		int yindex = 0;
		boolean done = false;
		while (!done) {
			if (xindex < movex.size() && yindex < movey.size()) {
				if (Math.abs(movey.get(yindex)) > Math.abs(movex.get(xindex))) {
					result.append(movex.get(xindex) > 0 ? "E" : "W");
					xindex++;
				} else {
					result.append(movey.get(yindex) > 0 ? "N" : "S");
					yindex++;
				}
			} else if (yindex >= movey.size() && xindex < movex.size()) {
				result.append(movex.get(xindex) > 0 ? "E" : "W");
				xindex++;
			} else if (yindex < movey.size() && xindex >= movex.size()) {
				result.append(movey.get(yindex) > 0 ? "N" : "S");
				yindex++;
			} else {
				done = true;
			}
		}
		return result.toString();
	}
}