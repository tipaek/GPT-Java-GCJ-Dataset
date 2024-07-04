import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	public static class Point {
		long x, y;
	}
	
	public static boolean getEdge(Scanner sc, long lx, long ly, long ux, long uy, Point point){
		//while(Math.abs(lx) + 1 < Math.abs(ux) && Math.abs(ly) + 1 < Math.abs(uy)) {
		while(true) {
			if(lx < ux && lx + 1 >= ux) { break; }
			if(lx > ux && lx <= ux + 1) { break; }
			if(ly < uy && ly + 1 >= uy) { break; }
			if(ly > uy && ly <= uy + 1) { break; }
			
			final long mx = (lx + ux) / 2;
			final long my = (ly + uy) / 2;
			
			System.out.println(mx + " " + my);
			System.out.flush();
			
			final String result = sc.next();
			if("CENTER".equals(result)) {
				return true;
			}else if("HIT".equals(result)) {
				lx = mx; ly = my;
			}else if("MISS".equals(result)) {
				ux = mx; uy = my;
			}else if("WORNG".equals(result)) {
				System.exit(0);
			}
		}
		
		point.x = lx;
		point.y = ly;
		return false;
	}
	
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			final int T = sc.nextInt();
			final long A = sc.nextLong();
			final long B = sc.nextLong();
			final long SIZE = 1000000000;
			//final long SIZE = 5;
			
			LOOP:
			for(int tt = 0; tt < T; tt++){
				Point uu = new Point(); 
				Point ud = new Point();
				Point du = new Point();
				Point dd = new Point();
				
				long px = 0, py = 0;
				{
					final long x = 0, y = 0;
					System.out.println(x + " " + y);
					System.out.flush();
					final String result = sc.next();
					if(result.equals("CENTER")) { continue LOOP; }
					if(result.equals("HIT")) { px = x; py = y; }
					if(result.equals("WRONG")) { return; }
				}
				if(A != B){
					final long x = SIZE / 2, y = SIZE / 2;
					System.out.println(x + " " + y);
					System.out.flush();
					final String result = sc.next();
					if(result.equals("CENTER")) { continue LOOP; }
					if(result.equals("HIT")) { px = x; py = y; }
					if(result.equals("WRONG")) { return; }
				}
				if(A != B){
					final long x = SIZE / 2, y = -SIZE / 2;
					System.out.println(x + " " + y);
					System.out.flush();
					final String result = sc.next();
					if(result.equals("CENTER")) { continue LOOP; }
					if(result.equals("HIT")) { px = x; py = y; }
					if(result.equals("WRONG")) { return; }
				}
				if(A != B){
					final long x = -SIZE / 2, y = SIZE / 2;
					System.out.println(x + " " + y);
					System.out.flush();
					final String result = sc.next();
					if(result.equals("CENTER")) { continue LOOP; }
					if(result.equals("HIT")) { px = x; py = y; }
					if(result.equals("WRONG")) { return; }
				}
				if(A != B){
					final long x = -SIZE / 2, y = -SIZE / 2;
					System.out.println(x + " " + y);
					System.out.flush();
					final String result = sc.next();
					if(result.equals("CENTER")) { continue LOOP; }
					if(result.equals("HIT")) { px = x; py = y; }
					if(result.equals("WRONG")) { return; }
				}
				
				if(getEdge(sc, px, py, px + SIZE, py + SIZE, uu)) { continue LOOP; }
				if(getEdge(sc, px, py, px + SIZE, py - SIZE, ud)) { continue LOOP; }
				if(getEdge(sc, px, py, px - SIZE, py + SIZE, du)) { continue LOOP; }
				//if(getEdge(sc, cy, cy,cx -SIZE, -SIZE, dd)) { continue LOOP; }
				
				final double x0 = uu.x, y0 = uu.y, x1 = ud.x, y1 = ud.y, x2 = du.x, y2 = du.y;
				final double l_x_1 = 2 * (x1 - x0);
				final double l_x_2 = 2 * (x2 - x1);
				final double l_y_1 = 2 * (y1 - y0);
				final double l_y_2 = 2 * (y2 - y1);
				
				final double l_o_1 = -(x0 * x0 - x1 * x1 + y0 * y0 - y1 * y1);
				final double l_o_2 = -(x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2);
				
				final double cx = (l_o_1 - ((l_o_2 / l_y_2) * l_y_1)) / (l_x_1 - ((l_x_2 / l_y_2) * l_y_1));
				final double cy = (l_o_1 - l_x_1 * cx) / l_y_1;
				
				for(int x = (int)(cx - 2); x <= (int)(cx + 2); x++) {
					for(int y = (int)(cy - 2); y <= (int)(cy + 2); y++) {
						System.out.println(x + " " + y);
						System.out.flush();
						
						final String result = sc.next();
						if(result.equals("CENTER")) {
							continue LOOP;
						}else if(result.equals("WRONG")) {
							return;
						}
					}
				}
			}
		}
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
		
		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}
 
		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() {
			getLine();
			return tok.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
