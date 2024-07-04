import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			StringBuilder result = buildPath(new StringBuilder(), 1, 0, 0, X, Y);
		
			System.out.println(String.format("Case #%d: %s" , tCurr, result == null ? "IMPOSSIBLE" : result));
			
		}

		System.out.flush();
	}
	
	static class Tuple {
		char c;
		int x, y;
		public Tuple(char c, int x, int y) {
			this.c = c; this.x = x; this.y = y;
		}
		@Override
		public String toString() {
			return c + ":" + x + ',' + y;
		}
	}
	static Tuple S = new Tuple('S', 0, -1), N = new Tuple('N', 0, 1), E = new Tuple('E', 1, 0), W = new Tuple('W', -1, 0);
	static Tuple[] ALL_TUPLES = new Tuple[] {S, N, E, W};
	
	static StringBuilder buildPath(StringBuilder path, int step, long curX, long curY, int X, int Y) {
		long distX = Math.abs(curX - X);
		long distY = Math.abs(curY - Y);
		
		if (Math.abs(curX-X) < step/2 && curX != X || Math.abs(curY-Y) < step/2 && curY != Y) {
			return null;
		}
		
		if (curX == X && curY == Y) {
			return path;
		}
		List<StringBuilder> variants = new ArrayList<StringBuilder>();
		for(Tuple tuple: ALL_TUPLES) {
			StringBuilder subPath = new StringBuilder(path);
			subPath.append(tuple.c);
			if (curX == X && tuple.x != 0 || curY == Y && tuple.y != 0) {
				continue;
			}
			
			
			long subX = curX + tuple.x * step;
			long subY = curY + tuple.y * step;

			long newDistX = Math.abs(subX - X);
			long newDistY = Math.abs(subY - Y);
			
			if (newDistX > distX && distX < step*2 || newDistY > distY && distY < step*2) {
				continue;
			}
						
			
			StringBuilder subResult = buildPath(subPath, step * 2, subX, subY, X, Y);
			if (subResult != null) {
				variants.add(subResult);
			}
		}
		if (variants.isEmpty()) {
			return null;
		}
		return Collections.min(variants, (a, b) -> a.length() - b.length() );
	}
	

}
