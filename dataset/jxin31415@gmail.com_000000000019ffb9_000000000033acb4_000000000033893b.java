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
		static List<List<Node>> adjList;
		public void solve(int testNumber, FastReader sc, PrintWriter out) {
			adjList = new ArrayList<>();
			int K  =sc.nextInt();
			int Q = sc.nextInt();
			for(int i = 0; i < K; i++) {
				adjList.add(new ArrayList<>());
			}
			String s = sc.nextLine();
			int[] partner = new int[K];
			Stack<Integer> opening = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					opening.push(i);
				} else if(s.charAt(i) == ')'){
					partner[i] = opening.peek();
					partner[opening.pop()] = i;
				}
			}
			sc.nextInt();
			for(int i = 1; i < K; i++) {
				adjList.get(i).add(new Node(i-1, sc.nextInt()));
			}
			for(int i = 0; i < K-1; i++) {
				adjList.get(i).add(new Node(i+1, sc.nextInt()));
			}
			sc.nextInt();
			for(int i = 0; i < K; i++) {
				adjList.get(i).add(new Node(partner[i], sc.nextInt()));
			}
			
			//System.out.println(adjList);
			DPQ dpq = new DPQ(K);
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			StringTokenizer st2 = new StringTokenizer(sc.nextLine());
			long sum = 0;
			while(Q --> 0) {
				sum += dpq.dijkstra(adjList, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st2.nextToken())-1);
			}
			out.println("Case #" + testNumber+ ": " + sum);
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
		int a, b;
		tup(int a,int b){
			this.a=a;
			this.b=b;
		}
		public tup() {
		}
		@Override
		public int compareTo(tup o){
			return Integer.compare(o.b,b);
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