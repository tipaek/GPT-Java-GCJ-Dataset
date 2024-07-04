import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);

	
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			int R = in.nextInt();
			int S = in.nextInt();
			int start[] = new int[R*S];
			int idd = 0;
			for(int i = 0; i < S; i++)
				for(int j = 0; j < R; j++) start[idd++] = j;
			
			ArrayDeque<State> q = new ArrayDeque<State>();
			HashMap<Long, State> prevState = new HashMap<Long, State>();
			
			State startState = new State(start, 0);
			prevState.put(startState.hash, null);
			q.add(startState);
			
			while(!q.isEmpty()) {
				State v = q.poll();
				if(v.finished()) {
					out.println("Case #"+runs+": "+v.moves);
					State cur = v;
					while(cur.toGetHere != null) {
						out.println(cur.toGetHere.a+" "+cur.toGetHere.b);
						cur = prevState.get(cur.hash);
					}
					break;
				}
				
				// Do edges
				for(State next : v.getEs()) {
					if(prevState.containsKey(next.hash)) continue;
					prevState.put(next.hash, v);
					q.add(next);
				}
				
			}
			
		}
		
	
		out.close();
	}
	
	static class State {
		int ar[];
		int moves;
		long hash;
		Pair toGetHere;
		public State(int a[], int mm) {
			ar = a;
			moves = mm;
			hash = hash(ar);
			toGetHere = null;
		}
		public boolean finished() {
			for(int i = 0; i < ar.length-1; i++) if(ar[i] > ar[i+1]) return false;
			return true;
		}
		
		public ArrayList<State> getEs() {
			ArrayList<State> list = new ArrayList<State>();
			for(int A = 1; A <= ar.length; A++) {
				for(int B = 1; B <= ar.length; B++) {
					if(A+B > ar.length) break;
					
					State next = new State(change(ar, A, B), moves+1);
					next.toGetHere = new Pair(A, B);
					list.add(next);
				}
			}
			
			return list;
		}
	}
	
	static int[] change(int ar[], int A, int B) {
		int res[] = new int[ar.length];
		int idd = 0;
		
		for(int i = A; i < A+B; i++) res[idd++] = ar[i];
		for(int i = 0; i < A; i++) res[idd++] = ar[i];
		for(int i = A+B; i < ar.length; i++) res[idd++] = ar[i];
		return res;
	}
	
	static long hash(int ar[]) {
		long x = 0;
		long shift = 0;
		for(int i = 0; i < ar.length; i++) {
			x |= ((long)ar[i])<<shift;
			shift += 4;
		}
		return x;
	}
	
	static class Pair {
		int a, b;
		public Pair(int aa, int bb) {
			a=aa;
			b=bb;
		}
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
