import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class E {
    static Stack<Node> sta= new Stack<Node>();
    static class Node{
        int no;
        boolean J;
        boolean vis1;
        boolean vis2;
        int g_no = -1;
        List<Node> edges = new LinkedList<Node>();
        List<Node> bedges = new LinkedList<Node>();
        Node(){
        }
    }
    static void edge(Node a, Node b) {
        a.edges.add(b);
        b.bedges.add(a);
    }
    static int group_num = 0;
    static void dfs1(Node a) {
	if(a.vis1)return;
        a.vis1=true;
        for(Node n :a.edges) {
            dfs1(n);
        }
        sta.push(a);
    }
    static void dfs2(Node a) {
        if(a.vis2)return;
        a.vis2=true;
        for(Node n :a.bedges) {
            dfs2(n);
        }
        a.g_no = group_num;
    }
    static int conv(char c){
	return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c);
    }
    public static String one() throws Exception{
	rl();
	char[] cars = nca();
	boolean[] avail = new boolean[62];
	int n = 62;
	for(char c:cars)avail[conv(c)]=true;
	/*for(int i=0;i<n;++i){
	    cars[i] = cars[j]
	    }*/
	int m = nin();
	group_num = 0;
	Node[] nodes =  new Node[n];
	ArrayList<Integer>[] arrs = new ArrayList[n];
	for(int i=0;i<n;++i){
	    arrs[i] = new ArrayList<>();
	    nodes[i] = new Node();
	}
	rl();
	while(m-->0){
	    char[] blah = nca();
	    int a=conv(blah[0]);
	    int b=conv(blah[1]);
	    edge(nodes[a],nodes[b]);
	    arrs[a].add(b);
	}
        for(int j=0;j<n;++j) {
	    dfs1(nodes[j]);
        }
        while(!sta.isEmpty()) {
	    Node e = sta.pop();
	    if(!e.vis2) {
		dfs2(e);
		++group_num;
	    }
        }
        
        int N = n;
        n = group_num;
	int[] gs = new int[n];
        int[] mc = new int[n];
	boolean[][] g2 = new boolean[n][n];
	for(int j=0;j<N;++j){
	    int sg = nodes[j].g_no;
	    for(int y : arrs[j]){	
		int tg = nodes[y].g_no;
		g2[sg][tg]=true;
	    }
	    ++gs[sg];
	    if(avail[j])++mc[sg];
        }
	int res = 0;
	//start from bottom, go up
	Dinic d = new Dinic(2*n);
        for(int i=n-1;i>=0;--i){
	    
	    
	    if(gs[i]==mc[i]){
		//actually worry about children to pass off the extra to 

		if(mc[i]==1){
		    for(int j=0;j<n;++j){
			if(g2[i][j]){
			    --mc[i];
			    break;
			}
		    }
		    
		}
		else{
		    --mc[i];
		}
		d.add(d.s,i,1,0);
	    }
	    d.add(i+n,d.t,gs[i]-mc[i],0);
	    boolean[] seen = new boolean[n];
	    Stack<Integer> t = new Stack<Integer>();
	    t.push(i);
	    while(!t.isEmpty()){
		int k = t.pop();
		if(k!=i)d.add(i,n+k,1,0);
		for(int j=0;j<n;++j){
		    if(g2[k][j]&&!seen[j]){
			t.push(j);
			seen[j]=true;
		    }
		}
	    }
	    res+=mc[i];
	    //bfs
	    
        }
	res+=d.flow();
	return res+"";
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    
	    bw.write(String.format("Case #%d: %s\n",cn,one()));
	    //if(cn!=cases)rl();
	}
	bw.flush();
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static void rl() throws Exception{
    st = new StringTokenizer(br.readLine());
    }
    static long nlo(){
    return Long.parseLong(st.nextToken());
    }
    static int nin(){
    return Integer.parseInt(st.nextToken());
    }
    /*private static void te(){
      }*/
    static double ndo(){
    return Double.parseDouble(st.nextToken());
    }
    static char[] nca(){
    return st.nextToken().toCharArray();
    }

    static class Dinic {

    ArrayDeque<Integer> q;
    ArrayList<Edge>[] adj;
    int n, s, t, oo = (int) 1E9;
    boolean[] blocked;
    int[] dist;


    public Dinic(int N) {
      n = N;
      s = n++;
      t = n++;
      blocked = new boolean[n];
      dist = new int[n];
      q = new ArrayDeque<Integer>();
      adj = new ArrayList[n];
      for (int i = 0; i < n; ++i)
        adj[i] = new ArrayList<Edge>();
    }

    // Specifying flow can represent minimum flow for circulation.
    Edge add(int v1, int v2, int cap, int flow) {
      Edge e = new Edge(v1, v2, cap, flow);
      Edge rev = new Edge(v2, v1, 0, 0);
      adj[v1].add(rev.rev = e);
      adj[v2].add(e.rev = rev);
      return e;
    }

    boolean bfs() {
      q.clear();
      Arrays.fill(dist, -1);
      dist[t] = 0;
      q.add(t);

      while (!q.isEmpty()) {
        int node = q.poll();
        if (node == s)
          return true;
        for (Edge e : adj[node]) {
          if (e.rev.cap > e.rev.flow && dist[e.v2] == -1) {
            dist[e.v2] = dist[node] + 1;
            q.add(e.v2);
          }
        }
      }
      return dist[s] != -1;
    }

    int dfs(int pos, int min) {
      if (pos == t)
        return min;
      int flow = 0;
      for (Edge e : adj[pos]) {
        int cur = 0;
        if (!blocked[e.v2] && dist[e.v2] == dist[pos] - 1 && e.cap - e.flow > 0) {
          cur = dfs(e.v2, Math.min(min - flow, e.cap - e.flow));
          e.flow += cur;
          e.rev.flow = -e.flow;
          flow += cur;
        }
        if (flow == min)
          return flow;
      }
      blocked[pos] = flow != min;
      return flow;
    }

    int flow() {
      int ret = 0;
      while (bfs()) {
        Arrays.fill(blocked, false);
        ret += dfs(s, oo);
      }
      return ret;
    }
    }
    static class Edge {
    int v1, v2;
    int cap, flow;
    Edge rev;
    int id;

    Edge(int V1, int V2, int Cap, int Flow) {
      v1 = V1;
      v2 = V2;
      cap = Cap;
      flow = Flow;
    }
  }
}

