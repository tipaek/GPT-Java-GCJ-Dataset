import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	class Point{
		long x;
		long y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (int) (x ^ (x >>> 32));
			result = prime * result + (int) (y ^ (y >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		private Solution getOuterType() {
			return Solution.this;
		}
		
		public String toString() {
			return x + "," + y;
		}
	}
	public String solve(long x, long y) {
		Map<Point, String> map = new HashMap<>();
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(0, 0));
		map.put(new Point(0, 0), "");
		
		long power = 1;
		while(!Q.isEmpty()) {
			//System.out.println(map);
			int size = Q.size();
			Map<Point, String> newmap = new HashMap<>();
			for(int i = 0; i < size; i++) {
				Point cur = Q.poll();
				long curX = cur.x;
				long curY = cur.y;
				if(curX != x && power > Math.abs(curX - x) * 2) continue;
				if(curY != y && power > Math.abs(curY - y) * 2) continue;
				String curStr = map.get(cur);
				//System.out.println(curX + "," + curY + ":" + curStr);
				if(curX == x && curY == y) return curStr;
				Point newcur = new Point(curX+power, curY);
				
				Q.add(newcur);
				newmap.put(newcur, curStr+"E");
				
				newcur = new Point(curX-power, curY);
				
				Q.add(newcur);
				newmap.put(newcur, curStr+"W");
				
				newcur = new Point(curX, curY+power);
				
				Q.add(newcur);
				newmap.put(newcur, curStr+"N");
				
				newcur = new Point(curX, curY-power);
				
				Q.add(newcur);
				newmap.put(newcur, curStr+"S");
			}
			map = newmap;
			power *= 2;
			if(power >= 1000000000) break;
		}
		
		return "IMPOSSIBLE";
	}
	
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(4, 1));
		
		
		for(long X = -4; X <= 4; X++) {
			for(long Y = -4; Y <= 4 ; Y++) {
				System.out.println(X + "," + Y + ":" + Q.solve(X, Y));
			}
		}
		
		System.out.println(Q.solve(2, 3));
		System.out.println(Q.solve(-2, -3));
		System.out.println(Q.solve(3, 0));
		System.out.println(Q.solve(-1, 1));
		System.out.println(Q.solve(-4, 3));
		System.out.println(Q.solve(1000000000, 1000000000));
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			long X = in.nextLong();
			long Y = in.nextLong();
			in.nextLine();
			String output = Q.solve(X, Y);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
