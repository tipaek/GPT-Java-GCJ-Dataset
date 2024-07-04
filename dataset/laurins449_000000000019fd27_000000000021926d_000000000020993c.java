package jam2020_qualification;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Sol1 {
	 
	
	static FScanner sc = null;
	static PrintWriter out = null ;

	
	static void run(String contexte , int ... params) throws Exception {
		
		int from =  params.length > 0 ? params[0] : -1;
		int to =  params.length > 1 ? params[1] : -1;
		if( from > 0) to = Math.max(from, to);	
		
		String fin = "";
		
		if( to <= from) {
			
			fin = String.format("inputs/%s/input%d.txt",contexte,  from);
			sc = from < 0 ? new FScanner() : new FScanner(fin);	
			solve(); 
			out.close();
			
		}			
				
	}
	
	static void _d(String value, Object... list) {
		System.out.print(String.format(value, list));
	}
			

	public static void main(String[] args) throws Exception {
		
		String contexte = "jam2020_qualification/Sol1";	
			
		out = new PrintWriter(System.out);		
		run(contexte, -1 );
			
	}
	
	
	static int dim ;
	
	static void solve() {	
		
		dim = sc.nextInt();		
		for(int i=1;i<=dim;i++) {			
			solveByKase(i); 
		}
		
	}
	
	static void solveByKase(int kk) {
		out.printf("Case #%d: ",kk);
		int size  = sc.nextInt();
		grid g = new grid(size, size);
		
		out.printf("%d %d %d\n", g.trace, g.countRow , g.countCol);	
	}	
	
	

	static class grid {
	
		public int row , col;
		public int[][] g;
				
		public grid(int _r , int _c , int[][] _g) {
			row = _r ; col = _c; g = _g;
		}
		
		long trace ;
		int countRow , countCol ;
		
		
		public grid(int _r , int _c) {
			
			trace = 0;
			countCol = 0 ; countRow = 0;
			
			row = _r ; col = _c;
			g = new int [row][col];	
			HashSet<Integer> hs = new HashSet<>();
			countRow = 0;
			for(int r=0;r<row;r++) {
				hs = new HashSet<>();
				for( int c = 0; c < col;c++) {
					g[r][c] = sc.nextInt();	
					hs.add(g[r][c]);
					if( c == r ) trace += g[r][c];
				}	
				if( hs.size()!= row) countRow ++;
			} 	
			iterate();
		}
		
		
		public void iterate() {
			
			HashSet<Integer> hs = new HashSet<>();
			for(int c=0;c<col;c++) {
				hs = new HashSet<>();
				for(int r=0;r<row;r++) {
					hs.add(g[r][c]);
				}
				if( hs.size() != col) countCol ++;
			}
		}
		
	}

	
	static class FScanner {
		BufferedReader br; StringTokenizer st;		
		public FScanner(String  fileName) throws Exception {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		}
		
		public FScanner(InputStream in) {		
			br = new BufferedReader(new InputStreamReader(in));
		}
		public FScanner() {		
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try { st = new StringTokenizer(br.readLine()); } 
				catch (IOException e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}

		int nextInt() { return Integer.parseInt(next()); }

		long nextLong() { return Long.parseLong(next()); }

		double nextDouble() { return Double.parseDouble(next()); }

		String nextLine() {
			String str = "";
			try { str = br.readLine(); } 
			catch (IOException e) { e.printStackTrace();}
			return str;
		}
	}

}