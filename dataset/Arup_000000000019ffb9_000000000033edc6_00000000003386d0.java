import java.util.*;

public class Solution {
	
	public static int n;
	public static pt[] list;
	public static long[] y;

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			n = stdin.nextInt();
			list = new pt[n];
			
			for (int i=0; i<n; i++) {
				long x = stdin.nextLong();
				long y = stdin.nextLong();
				list[i] = new pt(x,y);
			}
			
			
			int res = 1;
			if (n <= 4) res = n;
			else {
			res = 4;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (i == j) continue;
					long deltaN = list[j].y - list[i].y;
					long deltaD = list[j].x - list[i].x;
					int tmp = solve(deltaN,deltaD);
					if (tmp > res) res = tmp;
				}
			}
			
			}
			
			
			System.out.println("Case #"+loop+": "+res);
		}
	}
	
	public static boolean signSame(long a, long b) {
		if (a < 0 && b < 0) return true;
		if (a > 0 && b > 0) return true;
		if (a == 0 && b == 0) return true;
		return false;
	}
	
	public static int solve(long deltaN, long deltaD) {
		
		Dinic g = new Dinic(2*n);
		for (int i=0; i<n; i++)
			g.add(2*n,i,1,0);
		for (int i=0; i<n; i++)
			g.add(n+i,2*n+1,1,0);
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i == j) continue;
				
				// if i to j same slope add edge.
				long thisN = list[j].y - list[i].y;
				long thisD = list[j].x - list[i].x;
				
				if (!signSame(thisN, deltaN) || !signSame(thisD, deltaD)) continue;
				
				if (thisN*deltaD == thisD*deltaN)
					g.add(i,n+j,1,0);
			}
		}
		
		int res = g.flow();
		
		res = Math.min(n, 2*res+2);
		
		return res;
		
	}
}

class pt {
	public long x;
	public long y;
	
	public pt(long myx, long myy) {
		x = myx;
		y = myy;
	}
}
// An edge connects v1 to v2 with a capacity of cap, flow of flow.
class Edge {
	int v1, v2, cap, flow;
	Edge rev;
	Edge(int V1, int V2, int Cap, int Flow) {
		v1 = V1;
		v2 = V2;
		cap = Cap;
		flow = Flow;
	}
}

class Dinic {

	// Queue for the top level BFS.
	public ArrayDeque<Integer> q;

	// Stores the graph.
	public ArrayList<Edge>[] adj;
	public int n;

	// s = source, t = sink
	public int s;
	public int t;


	// For BFS.
	public boolean[] blocked;
	public int[] dist;

	final public static int oo = (int)1E9;

	// Constructor.
	public Dinic (int N) {

		// s is the source, t is the sink, add these as last two nodes.
		n = N; s = n++; t = n++;

		// Everything else is empty.
		blocked = new boolean[n];
		dist = new int[n];
		q = new ArrayDeque<Integer>();
		adj = new ArrayList[n];
		for(int i = 0; i < n; ++i)
			adj[i] = new ArrayList<Edge>();
	}

	// Just adds an edge and ALSO adds it going backwards.
	public void add(int v1, int v2, int cap, int flow) {
		Edge e = new Edge(v1, v2, cap, flow);
		Edge rev = new Edge(v2, v1, 0, 0);
		adj[v1].add(rev.rev = e);
		adj[v2].add(e.rev = rev);
	}

	// Runs other level BFS.
	public boolean bfs() {

		// Set up BFS
		q.clear();
		Arrays.fill(dist, -1);
		dist[t] = 0;
		q.add(t);

		// Go backwards from sink looking for source.
		// We just care to mark distances left to the sink.
		while(!q.isEmpty()) {
			int node = q.poll();
			if(node == s)
				return true;
			for(Edge e : adj[node]) {
				if(e.rev.cap > e.rev.flow && dist[e.v2] == -1) {
					dist[e.v2] = dist[node] + 1;
					q.add(e.v2);
				}
			}
		}

		// Augmenting paths exist iff we made it back to the source.
		return dist[s] != -1;
	}

	// Runs inner DFS in Dinic's, from node pos with a flow of min.
	public int dfs(int pos, int min) {

		// Made it to the sink, we're good, return this as our max flow for the augmenting path.
		if(pos == t)
			return min;
		int flow = 0;

		// Try each edge from here.
		for(Edge e : adj[pos]) {
			int cur = 0;

			// If our destination isn't blocked and it's 1 closer to the sink and there's flow, we
			// can go this way.
			if(!blocked[e.v2] && dist[e.v2] == dist[pos]-1 && e.cap - e.flow > 0) {

				// Recursively run dfs from here - limiting flow based on current and what's left on this edge.
				cur = dfs(e.v2, Math.min(min-flow, e.cap - e.flow));

				// Add the flow through this edge and subtract it from the reverse flow.
				e.flow += cur;
				e.rev.flow = -e.flow;

				// Add to the total flow.
				flow += cur;
			}

			// No more can go through, we're good.
			if(flow == min)
				return flow;
		}

		// mark if this node is now blocked.
		blocked[pos] = flow != min;

		// This is the flow
		return flow;
	}

	public int flow() {
		clear();
		int ret = 0;

		// Run a top level BFS.
		while(bfs()) {

			// Reset this.
			Arrays.fill(blocked, false);

			// Run multiple DFS's until there is no flow left to push through.
			ret += dfs(s, oo);
		}
		return ret;
	}

	// Just resets flow through all edges to be 0.
	public void clear() {
		for(ArrayList<Edge> edges : adj)
			for(Edge e : edges)
				e.flow = 0;
	}
}