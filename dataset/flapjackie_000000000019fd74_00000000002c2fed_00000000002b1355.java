import java.util.*;
import java.awt.Point;
import java.io.*;
public class Solution {
	static int ROWS, COLS;
	static int[][] board;
	static long ans;
	static boolean[][] in;
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for (int ca = 1 ; ca <= T ; ca++) {
			ROWS = sc.nextInt();
			COLS = sc.nextInt();
			board = new int[ROWS][COLS];
			ans = 0;
			in = new boolean[ROWS][COLS];
			
			for (int i = 0 ; i < ROWS ; i++) {
				Arrays.fill(in[i], true);
			}
			
			for (int r = 0;r < ROWS ; r++) {
				for (int c = 0 ; c < COLS ; c++) {
					board[r][c] = sc.nextInt();
				}
			}

			while(true) {
				ArrayList<Point> elims = new ArrayList<>();
				for (int r = 0 ; r < ROWS ; r++) {
					for (int c= 0 ; c< COLS ; c++) {
						if(!in[r][c]) {
							continue;
						}
						
						double nNeighbors = 0;
						double skill = 0;
						// up
						for (int nextR = r-1 ; nextR >= 0 ; nextR--) { 
							if (in[nextR][c]) {
								nNeighbors++;
								skill += board[nextR][c];
								break;
							}
						}
						

						// down
						for (int nextR = r+1 ; nextR <ROWS ; nextR++) { 
							if (in[nextR][c]) {
								nNeighbors++;
								skill += board[nextR][c];
								break;
							}
						}
						

						// left
						for (int nextC = c-1 ; nextC >=0; nextC--) { 
							if (in[r][nextC]) {
								nNeighbors++;
								skill += board[r][nextC];
								break;
							}
						}
						
						// right
						for (int nextC = c+1 ; nextC <COLS; nextC++) { 
							if (in[r][nextC]) {
								nNeighbors++;
								skill += board[r][nextC];
								break;
							}
						}
						
						if (nNeighbors != 0 && skill/nNeighbors > board[r][c]) {
							elims.add(new Point(r,c));
						}

						ans += board[r][c];
					}
				}

				if(elims.size() == 0) break;
				
				for (Point p : elims) {
					in[p.x][p.y] = false;
				}
				
			}
			
			
			out.printf("Case #%d: %d\n", ca, ans);
		}
		out.close();
	}
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}
}