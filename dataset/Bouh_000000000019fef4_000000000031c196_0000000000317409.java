import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int X = scanner.nextInt();
			int Y = scanner.nextInt();
			String M = scanner.next();
			result+="Case #" + i + ": " + solveCase(X, Y, M) + "\n";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static String solveCase(int X, int Y, String M) {
		Position curPos = new Position(X, Y);
		
		for(int i = 0; i < M.length(); i++) {
			curPos = curPos.getNextPosition(curPos, M.substring(i, i + 1));
			if (curPos.getDistance() <= i + 1) {
				return Integer.toString(i+ 1);
			}
		}
		
		return "IMPOSSIBLE";
	}
	
	public static class Position {
		public int x;
		public int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Position getNextPosition(Position position, String direction) {
			if ("S".equals(direction)) {
				return new Position(this.x, this.y - 1);
			} else if ("N".equals(direction)) {
				return new Position(this.x, this.y + 1);
			} else if ("W".equals(direction)) {
				return new Position(this.x - 1, this.y);
			} else {
				return new Position(this.x + 1, this.y);
			}
		}
		
		public int getDistance() {
			return (Math.abs(x) + Math.abs(y));
		}
		
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	
	
}
