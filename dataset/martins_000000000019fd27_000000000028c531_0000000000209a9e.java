import java.util.*;
import java.io.*;
public class Solution {

	static String[][] change = {
			{null, "DBCA", "BDAC", null},
			{null, null, null, null},
			{null, null, null, null},
			{null, "CADB", "ACBD", null}
	};
	static int len = 3; //every 2*len queries everything gets messed up
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int B = sc.nextInt();
		while(T-- > 0) {
			int k = B / len / 2;
			Group[] gs = new Group[k];
			for(int i = 0; i < k; i++) {
				gs[i] = new Group();
				for(int j = 0; j < len; j++) {
					System.out.println(i*len + j + 1);
					int a = sc.nextInt();
					System.out.println(B - (i*len + j));
					int b = sc.nextInt();
					gs[i].add(new Pair(a, b));
				}
			}
			int q = 0, ind = 0;
			Group bigg = new Group();
			while(ind < k) {
				int[] c = new int[4];
				for(int i = 0; i < 4; i++) {
					c[i] = gs[ind].inds[i].size(); 
				}
				
				int[] codes = gs[ind].indpair();
				if(codes[1] == -1) {
					int inda = gs[ind].geta(codes[0]);
					System.out.println(ind*len+inda+1);
					int a = sc.nextInt();
					System.out.println(1);
					sc.nextInt();
					if(gs[ind].ps.get(inda).a != a) {
						gs[ind] = gs[ind].invert();
					}
				}
				else {
					int inda = gs[ind].geta(codes[0]);
					System.out.println(ind*len+inda+1);
					int a = sc.nextInt();
					int indb = gs[ind].geta(codes[1]);
					System.out.println(ind*len+indb+1);
					int b = sc.nextInt();
					
					char ch = change[gs[ind].typeof(inda)][gs[ind].typeof(indb)].charAt(2*a+b);
					gs[ind] = gs[ind].convert(ch);
				}
				for(Pair pa: gs[ind].ps) {
					bigg.add(pa);
				}
				
				q += 2;
				if(ind == k-1) break; // we're done
				if(q % (2*len) == 0) {
					codes = bigg.indpair();
					if(codes[1] == -1) {
						int inda = bigg.geta(codes[0]);
						System.out.println(inda+1);
						int a = sc.nextInt();
						System.out.println(1);
						sc.nextInt();
						if(bigg.ps.get(inda).a != a) {
							bigg = bigg.invert();
						}
					}
					else {
						int inda = bigg.geta(codes[0]);
						System.out.println(inda+1);
						int a = sc.nextInt();
						int indb = bigg.geta(codes[1]);
						System.out.println(indb+1);
						int b = sc.nextInt();
						
						char ch = change[bigg.typeof(inda)][bigg.typeof(indb)].charAt(2*a+b);
						bigg = bigg.convert(ch);
					}
					q += 2;
				}
				ind++;
			}
			System.out.println(bigg.toString());
			String ans = sc.next(); // :)
			if(ans.equals("N")) break;
		}
	}
	static class Group{
		ArrayList<Pair> ps;
		HashSet<Integer>[] inds;
		public Group() {
			ps = new ArrayList<>();
			inds = new HashSet[4];
			for(int i = 0; i < 4; i++) inds[i] = new HashSet<>();
		}
		public void add(Pair p) {
			inds[p.type()].add(ps.size());
			ps.add(p);
		}
		public int[] indpair(){
			int[] res = new int[2];
			if(inds[0].size() > 0 || inds[3].size() > 0) {
				res[0] = inds[0].size() > 0 ? 0 : 3;
				if(inds[1].size() > 0 || inds[2].size() > 0) {
					res[1] = inds[1].size() > 0 ? 1 : 2;
				}
				else res[1] = -1;
				return res;
			}
			else {
				res[0] = inds[1].size() > 0 ? 1 : 2;
				res[1] = -1;
				return res;
			}
		}
		public int typeof(int ind) {
			return ps.get(ind).type();
		}
		public int geta(int code) {
			if(inds[code].size() == 0) return -1;
			else return inds[code].iterator().next();
		}
		public Group invert() {
			Group g = new Group();
			for(Pair p: ps) g.add(p.invert());
			return g;
		}
		public Group convert(char ch) {
			Group g = new Group();
			for(Pair p: ps) g.add(p.convert(ch));
			return g;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			int n = ps.size();
			for(int i = 0; i < n; i++) {
				sb.append(ps.get(i).a+"");
			}
			for(int i = n-1; i >= 0; i--) {
				sb.append(ps.get(i).b+"");
			}
			return sb.toString();
		}
	}
	static int[][][] conv = {
		{ {1, 1}, {0, 0}, {1, 1}, {0, 0} },
		{ {1, 0}, {1, 0}, {0, 1}, {0, 1} },
		{ {0, 1}, {0, 1}, {1, 0}, {1, 0} },
		{ {0, 0}, {1, 1}, {0, 0}, {1, 1} },
	};
	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		public String toString() {
			return a+" "+b;
		}
		public int type() {
			return 2*a + b;
		}
		public Pair invert() {
			return new Pair(1-a, 1-b);
		}
		public Pair convert(char ch) {
			int[] p = conv[type()][ch-'A']; 
			return new Pair(p[0], p[1]);
		}
	}
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
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
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
