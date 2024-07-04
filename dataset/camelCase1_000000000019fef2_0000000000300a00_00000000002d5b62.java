import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		outer:
		for(int l = 0; l < t; l++) {
			int x = nextInt();
			int y = nextInt();
			LinkedList<Point> arr = new LinkedList<Point>();
			arr.add(new Point(0,0, null));
			for(int i = 0; i < 31; i++) {
				ListIterator<Point> it = arr.listIterator();
				while(it.hasNext()) {
					Point t1 = it.next();
					if(t1.x == x && t1.y == y) {
						System.out.println("Case #" + (l + 1) + ": " + retrace(t1));
						continue outer;
					}
					if(Math.abs(x - t1.x) % (1 << i) != 0 ||Math.abs(y - t1.y) % (1 << i) != 0)  {
//						System.out.println(t1);
						it.remove();
						continue;
						}
					it.add(new Point(t1.x + (1 << i), t1.y, t1));
					it.add(new Point(t1.x, t1.y + (1 << i), t1));
					it.add(new Point(t1.x - (1 << i), t1.y, t1));
					it.add(new Point(t1.x, t1.y - (1 << i), t1));
				}
			}
			for(Point e: arr) if(e.x == x && e.y == y) {
				System.out.println("Case #" + (l + 1) + ": " + retrace(e));
				continue outer;
			}
			System.out.println("Case #" + (l + 1) + ": IMPOSSIBLE");
		}
	}
	public static String retrace(Point p) {
		StringBuilder str = new StringBuilder();
		while(p.par != null) {
			if(p.par.x != p.x) {
				if(p.par.x > p.x) str.append('W');
				else str.append('E');
			} else {
				if(p.par.y > p.y) str.append('S');
				else str.append('N');
			}
			p = p.par;
		}
		return str.reverse().toString();
	}
	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
class Point {
	int x; int y;
	Point par;
	public Point(int x, int y, Point par) {
		super();
		this.x = x;
		this.y = y;
		this.par = par;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}