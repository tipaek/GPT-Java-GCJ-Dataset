import java.io.*;
import java.util.*;
public class Solution{
	static class pair implements Comparable<pair>{
		int id;
		int val;
		public pair(int id, int val) {
			this.id = id;
			this.val = val;
		}
		public int compareTo(pair p) {
			return Integer.compare(this.val, p.val);
		}
	}
	public static List<Integer> adj[];
	public static int dist[];
	public static int edge[];
	public static int get[][];
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test:for(int t=1; t<=cas; t++) {
			int c = sc.nextInt();
			int d = sc.nextInt();
			//System.out.println(c + " " + d);
			dist = new int[c];
			edge = new int[d];
			get = new int[c][c];
			Arrays.fill(dist, Integer.MAX_VALUE);
			adj = new ArrayList[c];
			PriorityQueue<pair> pq = new PriorityQueue<>();
			adj[0] = new ArrayList<>();
			for(int i=1; i<c; ++i) {
				adj[i] = new ArrayList<>();
				int a = sc.nextInt();
				//System.out.println(a);
				pq.add(new pair(i, -a));
			}
			
			for(int i=0; i<d; ++i) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				adj[a].add(b);
				adj[b].add(a);
				get[a][b] = i;
				get[b][a] = i;
			}
			dist[0] = 0;
			while(!pq.isEmpty()) {
				pair p = pq.poll();
				dist[p.id] = p.val;
				for(int i:adj[p.id]) {
					if(dist[i]<=p.val) {
						edge[get[i][p.id]]= Math.max(p.val-dist[i], 1); 
					}
				}
			}
			out.print("Case #" + t + ": ");
			for(int i=0; i<d; ++i) {
				out.print(edge[i] + " ");
			}out.println();
		}
		out.close();
  	}
	static class FastIO {
		 
		// Is your Fast I/O being bad?
 
		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;
 
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
 
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
 
		int nextInt() throws IOException {
			int ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		long nextLong() throws IOException {
			long ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
 
		String next() throws IOException {
			StringBuffer ret = new StringBuffer();
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
 
			return ret.toString();
		}
 
	}
}