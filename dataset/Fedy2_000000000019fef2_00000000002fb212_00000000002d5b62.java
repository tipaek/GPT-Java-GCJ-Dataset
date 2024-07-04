/**
 * 
 */

import java.util.*;
import java.io.*;

/**
 * @author fedy2
 *
 */
public class Solution {
	
	static class Point {
		int x;
		int y;
		char d;
		int i;
		Point parent;
		
		public Point(int x, int y, char d, int i, Point parent) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.i = i;
			this.parent = parent;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", d=" + d + ", i=" + i + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		//System.out.println("t: " + t);

		for (int tc = 1; tc <= t; tc++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			solve(tc, x, y);
		}
		in.close();
	}
	
	private static void solve(int tc, int x, int y) {
		//System.out.println("tc: " + tc);
		//System.out.println("x: " + x);
		//System.out.println("y: " + y);
		

		Point origin = new Point(0, 0, ' ', -1, null);
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(origin);
		
		Set<Point> saw = new HashSet<Point>();
		
		String sequence = " IMPOSSIBLE";
		
		while(!q.isEmpty() && saw.size() < 100000) {
			Point p = q.poll();
			//System.out.println("checking: " + p);
			
			if (p.x == x && p.y == y) {
				//System.out.println("found: " + p);
				// build sequence
				Point c = p;
				sequence = "";
				while(c != null) {
					sequence = c.d + sequence;
					c = c.parent;
				}
				break;
			}
			
			//if (p.x > 100 || p.x < -100 || p.y > 100 || p.y < -100) continue;
			
			if (saw.contains(p)) continue;
			saw.add(p);
			
			int delta = (int)Math.pow(2, p.i + 1);
			q.add(new Point(p.x, p.y + delta, 'N', p.i + 1, p));
			q.add(new Point(p.x, p.y - delta, 'S', p.i + 1, p));
			q.add(new Point(p.x + delta, p.y, 'E', p.i + 1, p));
			q.add(new Point(p.x - delta, p.y, 'W', p.i + 1, p));
		}
		
		System.out.println("Case #" + tc + ":" + sequence);
	}

}
