import java.util.*;

public class Solution {
	
	static class Node {
		char c;
		Node prev;
		
		public Node(char c, Node prev) {
			this.c = c; this.prev = prev;
		}
		
		@Override
		public String toString() {
			if (this.prev == null) return "";
			Node node = this;
			int i = 1;
			for(; node.prev != null; i++) {
				node = node.prev;
			}
			char[] chars = new char[i];
			node = this;
			while(node != null) {
				chars[--i] = node.c; 
				node = node.prev;
			}				
			return String.valueOf(chars);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			class Variant {
				Node result;
				long x, y;
				public Variant(Node result, long x, long y) {
					this.result = result; this.x = x; this.y = y;
				}
			}
			
			List<Variant> variants = new ArrayList<Variant>();
			variants.add(new Variant(null, 0, 0));
			
			Variant result = null;
			
			long step = 1;
			out:
			for(int i = 0; i < 25; i++, step *= 2) {
				
				List<Variant> newVariants = new ArrayList<Variant>();
				
				for(Variant v : variants) {
					if (v.x == X && v.y == Y) {
						result = v;
						break out;
					}
					
					long curX = v.x;
					long curY = v.y;
					
					long distX = Math.abs(curX - X);
					long distY = Math.abs(curY - Y);
					
					if (distX < step && curX != X || distY < step && curY != Y) {
						continue;
					}
					for(Tuple tuple: ALL_TUPLES) {
						if (curX == X && tuple.x != 0 || curY == Y && tuple.y != 0) {
							continue;
						}
						
						long subX = curX + tuple.x * step;
						long subY = curY + tuple.y * step;

						long newDistX = Math.abs(subX - X);
						long newDistY = Math.abs(subY - Y);
						
						if (newDistX > distX && (subX-X)*(curX-X) < 0 || newDistY > distY && (subY-Y)*(curY-Y) < 0) {
							continue;
						}
									
						Variant subresult = new Variant(new Node(tuple.c, v.result), subX, subY);
						
						newVariants.add(subresult);
						
					}
					
				}
				variants = newVariants;
			}
			
			//StringBuilder result = buildPath(new StringBuilder(), 1, 0, 0, X, Y, new int[] {100}, 0);
		
			System.out.println(String.format("Case #%d: %s" , tCurr, result == null ? "IMPOSSIBLE" : result.result));
			
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
	/*
	static StringBuilder buildPath(StringBuilder path, int step, long curX, long curY, int X, int Y, int[] maxDepth, int curDepth) {
		if (curDepth > maxDepth[0]) {
			return null;
		}
		if (curX == X && curY == Y) {
			return path;
		}

		long distX = Math.abs(curX - X);
		long distY = Math.abs(curY - Y);
		
		if (distX < step && curX != X || distY < step && curY != Y) {
			return null;
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
			
			if (newDistX > distX && (subX-X)*(curX-X) < 0 || newDistY > distY && (subY-Y)*(curY-Y) < 0) {
				continue;
			}
						
			
			StringBuilder subResult = buildPath(subPath, step * 2, subX, subY, X, Y, maxDepth, curDepth+1);
			if (subResult != null) {
				variants.add(subResult);
				maxDepth[0] = Math.min(maxDepth[0], subResult.length());
			}
		}
		if (variants.isEmpty()) {
			return null;
		}
		return Collections.min(variants, (a, b) -> a.length() - b.length() );
	}
	*/

}