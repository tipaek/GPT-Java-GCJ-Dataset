import java.io.*;
import java.util.*;

public class Solution {

	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() { 
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	static class Timepair implements Comparable<Timepair>{
		int start, end, idx;
		
		Timepair(){}
		Timepair(int s, int e, int idx1){
			this.start = s; this.end = e; this.idx = idx1;
		}

		@Override
		public int compareTo(Timepair o) {
			if(this.start == o.start) Integer.compare(this.end, o.end);
			return Integer.compare(this.start, o.start);
		}
	}
	
	static int T, N;
	static char charArr[];
	static Timepair tp[];
	
	public static void main(String[] args) throws IOException{
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tp = new Timepair[N]; charArr = new char[N];
			for(int i = 0; i < N; i++) {
				tp[i] = new Timepair(sc.nextInt(), sc.nextInt(), i);
			}Arrays.sort(tp);
			
			boolean isOkay = true;
			out.printf("Case #%d: ", tc);
			int cTime = 0, jTime = 0;
			for(int i = 0; i < N; i++) {
				if(cTime <= tp[i].start) {
					cTime = tp[i].end;
					charArr[tp[i].idx] = 'C';
				}else if(jTime <= tp[i].start) {
					jTime = tp[i].end;
					charArr[tp[i].idx] = 'J';
				}else {
					isOkay = false; break;
				}
			}
			
			if(isOkay) {
				for(int i = 0; i < N; i++) {
					out.print(charArr[i]);
				}
			}else {
				out.print("IMPOSSIBLE");
			}out.println();
			out.flush();
		}
		
	}

}
