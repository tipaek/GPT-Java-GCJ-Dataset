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
		static List<List<tup>> adjList;
		public void solve(int testNumber, FastReader sc, PrintWriter out) {
			adjList = new ArrayList<>();
			Map<Integer, tup> queries = new HashMap<>();
			int C  =sc.nextInt();
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
				adjList.get(i).add(new tup(j, val[j], -1));
				adjList.get(j).add(new tup(i, val[i], -1));
			}
			PriorityQueue<tup> pq = new PriorityQueue<>(new tup());
			for(tup each: adjList.get(1)) {
				pq.add(new tup(each.a, each.b, 1));
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
					for(tup each: adjList.get(t.a)) {
						if(!visited[each.a])
							pq.add(new tup(each.a, each.b, t.a));
						else if (dists[each.a][t.a]== 0 )
							dists[each.a][t.a]= 1000000; 
					}
				} else if(dists[t.a][t.parent]== 0 ){
					dists[t.a][t.parent] = 1000000; 
				}
				while(pq.size() > 0 && pq.peek().b == t.b) {
					t = pq.poll();
					if(!visited[t.a]) {
						visited[t.a] = true;
						long req = curTime - dist[t.parent] +1;
						dist[t.a] = curTime+1;
						dists[t.a][t.parent] = req;
						dists[t.parent][t.a] = req;
						for(tup each: adjList.get(t.a)) {
							if(!visited[each.a])
								pq.add(new tup(each.a, each.b, t.a));
							else if (dists[each.a][t.a]== 0 )
								dists[each.a][t.a]= 1000000; 
						}
					} else if(dists[t.a][t.parent]== 0){
						dists[t.a][t.parent] = 1000000; 
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
	static class tup implements Comparable<tup>, Comparator<tup>{
		int a, b, parent;
		tup(int a,int b, int c){
			this.a=a;
			this.b=b;
			parent = c;
		}
		public tup() {
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(b,o.b);
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
	

	static class Node implements Comparator<Node> { 
	    public int node; 
	    public long cost; 
	  
	    public Node(int node, long cost) 
	    { 
	        this.node = node; 
	        this.cost = cost; 
	    } 
	  
	    public Node() {
		}

		@Override
	    public int compare(Node node1, Node node2) 
	    { 
	        if (node1.cost < node2.cost) 
	            return -1; 
	        if (node1.cost > node2.cost) 
	            return 1; 
	        return 0;
	    } 
		public String toString() {
			return node + " " + cost;
		}
	} 
	static class DPQ { 
	    private long dist[]; 
	    private Set<Integer> settled; 
	    private PriorityQueue<Node> pq; 
	    private int V;
	  
	    public DPQ(int V) 
	    { 
	        this.V = V; 
	        dist = new long[V]; 
	        settled = new HashSet<Integer>(); 
	        pq = new PriorityQueue<Node>(V, new Node()); 
	    } 
	  
	    public long dijkstra(List<List<Node>> adj, int src, int dest) 
	    { 	  
	    	Arrays.fill(dist, Integer.MAX_VALUE);
	    	settled.clear();
	    	pq.clear();
	        pq.add(new Node(src, 0)); 
	        dist[src] = 0; 
	        
	        while (settled.size() != V-1 && pq.size() > 0) {
	            int u = pq.remove().node; 
	            if(!settled.contains(u)) {
	            	settled.add(u);
	            	if(u == dest)
	            		return dist[u];
			        // All the neighbors of v 
			        for (int i = 0; i < adj.get(u).size(); i++) { 
			            Node v = adj.get(u).get(i); 
			            
			            if (!settled.contains(v.node)) {
			                if (dist[u] + v.cost < dist[v.node]) {
			                    dist[v.node] = dist[u] + v.cost; 
			                    pq.add(new Node(v.node, dist[v.node])); 
			                }
			            }
			        }
	            }
	        }
	        return -1;
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