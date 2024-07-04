import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Solution implements Runnable{
	
    public static void main(String[] args) {
    	try{
            new Thread(null, new Solution(), "process", 1<<26).start();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
	public void run() {
		FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		//PrintWriter out = new PrintWriter("file.out");
		Task solver = new Task();
		int t = scan.nextInt();
		//int t = 1;
		for(int i = 1; i <= t; i++) solver.solve(i, scan, out);
		out.close();
	}

	static class Task {
		static final int inf = Integer.MAX_VALUE;
		static List<List<Integer>> adjList;
		public void solve(int testNumber, FastReader sc, PrintWriter out) {
			adjList = new ArrayList<>();
			Map<Integer, tup> queries = new HashMap<>();
			int C = sc.nextInt();
			int D = sc.nextInt();
			for(int i = 0; i <= C; i++) {
				adjList.add(new ArrayList<>());
			}
			int[] val = new int[C+1];
			for(int i = 2; i <= C; i++) {
				val[i] = sc.nextInt() * -1;
			}
			for(int d = 0; d < D; d++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				queries.put(d, new tup(i, j, -1));
				adjList.get(i).add(j);
				adjList.get(j).add(i);
			}
			PriorityQueue<tup> pq = new PriorityQueue<>(new tup());
			for(int each: adjList.get(1)) {
				pq.add(new tup(each, val[each], 1));
			}
			
			long[][] dists = new long[C+1][C+1];
			boolean[] visited = new boolean[C+1];
			visited[1] = true;
			long[] dist = new long[C+1];
			dist[1] = 0;
			
			long curTime = 0;
			while(pq.size() > 0) {
				//System.out.println(pq);
				tup t = pq.poll();
				if(!visited[t.a]) {
					visited[t.a] = true;
					long req = curTime - dist[t.parent] +1;
					dist[t.a] = curTime+1;
					dists[t.a][t.parent] = req;
					dists[t.parent][t.a] = req;
					for(int each: adjList.get(t.a)) {
						if(!visited[each])
							pq.add(new tup(each, val[each], t.a));
					}
				}
				while(pq.size() > 0 && pq.peek().b == t.b) {
					t = pq.poll();
					if(!visited[t.a]) {
						visited[t.a] = true;
						long req = curTime - dist[t.parent] +1;
						dist[t.a] = curTime+1;
						dists[t.a][t.parent] = req;
						dists[t.parent][t.a] = req;
						for(int each: adjList.get(t.a)) {
							if(!visited[each])
								pq.add(new tup(each, val[each], t.a));
						}
					}
				}
				curTime++;
			}
			
			//System.out.println();
			//System.out.println(Arrays.toString(dist));
			//for(long[] each: dists)
			//	System.out.println(Arrays.toString(each));
			
			out.print("Case #" + testNumber+ ":");
			for(int i = 0; i < D; i++) {
				tup t = queries.get(i);
				if(dists[t.a][t.b]== 0)
					dists[t.a][t.b] = 1000000;
				out.print(" " + dists[t.a][t.b]);
			}
			out.println();
		}
	}
	static long binpow(long a, long b, long m) {
		a %= m;
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				res = res * a % m;
			a = a * a % m;
			b >>= 1;
		}
		return res;
	}
	static void sort(int[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static void sort(long[] x){
		shuffle(x);
		Arrays.sort(x);
	}
	static class tup implements Comparator<tup>{
		int a, b, parent;
		tup(int a,int b, int c){
			this.a=a;
			this.b=b;
			parent = c;
		}
		public tup() {
		}
		@Override
		public int compare(tup o1, tup o2) {
			return Integer.compare(o1.b, o2.b);
		}
		
		@Override
	    public int hashCode() {
			return Objects.hash(a, b);
	    }
 
	    @Override
	    public boolean equals(Object obj) {
	    	if (this == obj)
                return true;
	    	if (obj == null)
                return false;
	    	if (getClass() != obj.getClass())
                return false;
	    	tup other = (tup) obj;
	    	return a==other.a && b==other.b;
	    }
	    
	    @Override
	    public String toString() {
	    	return a + " " + b;
	    }
	}
	
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}