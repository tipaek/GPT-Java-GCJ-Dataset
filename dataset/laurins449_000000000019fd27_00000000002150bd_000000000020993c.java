package jam2020_qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Sol1 implements Runnable {
	
	FScanner sc = null;
	PrintWriter out = null ;
	reader r;
	utils ut; 
	
	void init(String contexte , int ... params) throws Exception {
		
		r = new reader();
		ut = new utils();
		
		
		int from =  params.length > 0 ? params[0] : -1;
		int to =  params.length > 1 ? params[1] : -1;
		if( from > 0) to = Math.max(from, to);
		
		
		String fin = "", fout = "";
		
		// Lecture de plusieurs flux
		if( to > from) {
			
			for(int i = from ; i > 0 && i<= to ; i++) {
				
				fin = String.format("inputs/%s/input%d.txt",contexte,  i);				
				sc = new FScanner(fin);
				
				fout = String.format("outputs/%s/out%d.out",contexte,i);
				out = new PrintWriter(new File(fout));
							
				solve(); 
				out.close();
			}
			
		}
		else {
			
			// Lecture d'un seul flux ayant une sortie dÃƒÂ©ja dÃƒÂ©fini
			
			fin = String.format("inputs/%s/input%d.txt",contexte,  from);	
			
			sc = from < 0 ? new FScanner() : new FScanner(fin);	
			
				
			solve(); 
			out.close();
		}	
		
				
	}
	
	void _d(String value, Object... list) {
		System.out.print(String.format(value, list));
	}
			

	public static void main(String[] args) {		
		new Thread(new Sol1()).start();		
	}
	
	@Override
	public void run() {
		
		try {
			// TODO Auto-generated method stub
			String contexte = "jam2020_qualification/Sol1";	
			
			//*
			out = new PrintWriter(System.out);		
			init(contexte, -1 );
			//*/
		
			/*
			int fileNum = 2;
			out = new PrintWriter(new File(String.format("outputs/%s/out%d.out",contexte, fileNum)));	
			//out = new PrintWriter(new File(String.format("D:\\projects\\449\\Cplusplus\\EclipseCPP\\eclipse\\workspace\\CodeJam\\Debug\\myOut.txt")));	
			init(contexte, fileNum );
			//*/	
			
		}catch(Exception e) {}
		
	}
	
	int dim ;
	
	void solve() {	

		dim = sc.nextInt();		
		for(int i=1;i<=dim;i++) {
			 solveByKase(i);
		}
				
		/*
		
		lab();	
		
		dim = Integer.valueOf(sc.nextLine());
		
		dim = sc.nextInt();
		
		for(int i=1;i<=dim;i++) {
			out.printf("Case #%d: ",i);
			solveByKase(); 
		}
		
		for(int i=0;i<dim;i++) {  }
		
		solveScoope();
		
		//*/
		
	}
	//static void lab() {}
	//static void solveScoope() {}	
	
	void solveByKase(int i) {
		out.printf("Case #%d: ",i);
		int size  = sc.nextInt();
		grid g = new grid(size, size);
		
		out.printf("%d %d %d\n", g.trace, g.countRow , g.countCol);	
	}	
	
	

 class grid {
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
		public boolean isOnGrid (int r , int c) {
			return 0 <= r && r < row && 0 <= c && c < col;
		}
		
		public grid transpose() {
			int[][] gtr = new int [col][row];
			for(int r=0;r<row;r++) {
				for(int c=0;c<col;c++) {
					gtr[c][r] = g[r][c];
				}
			}
			return new grid(col, row, gtr);
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
		
		public StringBuilder line;
		
		public void printGrid() {
			StringBuilder sb;
			for(int r=0;r<row;r++) {
				sb = new StringBuilder();
				for(int c=0;c<col;c++) {
					sb.append(g[r][c]);
					sb.append(" ");
				}
				System.out.println(sb);
			}
		}	
		
		
}

	
	class utils {

		 <E, F> HashMap<E, F> mapInit(E[] kk , F[] vv){		
			 HashMap<E, F> mp = new HashMap<>();		 
			 for(int i=0;i<kk.length;i ++) { mp.put(kk[i], vv[i]); }
			 return mp;
		}
		 
		 <T,E> void mapAdd (HashMap<T, ArrayList<E>> mp , T key , E value) {
			if( !mp.containsKey(key) ) { mp.put(key, new ArrayList<E>()); }
			mp.get(key).add(value);
		 }
		 <T> void mapIncrement (HashMap<T, Integer> mp , T key , int value) {
				if( !mp.containsKey(key) ) { mp.put(key, 0 ); }
				int tp = mp.get(key);
				mp.put(key, tp+value);
		 }
		 
		 <T> ArrayList<T> toList(T[] val){
			ArrayList<T> ans = new ArrayList<T>(Arrays.asList(val));
			return ans;
		}
		 
		 <T> void  printTabList(T[] t) {    	
			 for( T item : t) {
				 _d("%s\n",item.toString());
			 }
		 }
		 
		 <T> void  printArrayList(ArrayList<T> t) {    	
			 for( T item : t) {
				 _d("%s\n",item.toString());
			 }
		 }
		 
		 <T> void printTabInline(T[] t) {			
			 for(int i=0;i<t.length;i++) { _d("%s ",t[i]); } 
			 _d("\n");
		 }
		 
		 <T> String arrayJoin (List<T> ls , String glue) {				
				String ans = "";				
				for(int i=0;i<ls.size();i++) {					
					ans+= String.format("%s%s", 
							i==0 ? "": glue , ls.get(i).toString());
				}				
				return ans;
		 }
		
	}
	
	class reader{
		
		int[] readInts(int dim) {			
			int[] ints = new int [dim];
			for(int i=0;i<dim;i++) { 
				ints[i] = sc.nextInt();
			}
			return ints;
		}
		 ArrayList<Integer> readIntsArray(int dim) {			
			ArrayList<Integer> ints = new ArrayList<>();
			for(int i=0;i<dim;i++) { 
				ints.add(sc.nextInt());
			}
			return ints;
		}
				
		int[] readInts(int dim , long[] somme ) {			
			int[] ints = new int [dim];		
			for(int i=0;i<dim;i++) { 
				ints[i] = sc.nextInt();
				somme[i] = ints[i];
				if( i > 0) somme[i] = somme[i]+ somme[i-1];			
			}			
			return ints;		
		}
			
		int[] readInts(int dim , BigInteger[] somme) {
			
			int[] ints = new int [dim];
			
			for(int i=0;i<dim;i++) { 
				ints[i] = sc.nextInt();
				somme[i] = BigInteger.valueOf(ints[i]) ;
				if( i > 0) somme[i] = somme[i].add(somme[i-1]);			
			}
			return ints;		
		}
		
		String[] readStringInlineTab() {
			String[] strs = sc.nextLine().trim().split(" ");
			return strs;
		}	
		String[] readStringMultipleNext(int dim) {
			String[] strs = new String[dim];
			for(int i=0;i<dim;i++) { 
				strs[i] = sc.next();
			}
			return strs;
		}	
		String[] readStringMultipleNextLines(int dim) {
			String[] strs = new String[dim];
			for(int i=0;i<dim;i++) { 
				strs[i] = sc.nextLine();
			}
			return strs;
		}
		
		
	}
	
	class FScanner {
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