import java.io.*;
import java.util.*;
import java.math.*;
//@SuppressWarnings("unused")
public class Solution {
    private static int[] abc(int n, int t){
	for(int a=1;a<=n;++a)
	    for(int b=1;b<=n;++b)
		for(int c=1;c<=n;++c)
		    if(a!=b&&b!=c&&c!=a&&(n-2)*a+b+c==t){
			int[] res ={a,b,c};
			return res;
		    }

	return null;
    }
    private static String one()throws Exception{
	rl();
	int n = nin();
	int t = nin();
	return one(n,t);
    }
    private static String one(int n,int t){
	
	int[][] res = new int[n][n];
	if(t%n==0){
	    for(int i=0;i<n;++i){
		for(int j=0;j<n;++j){
		    res[i][j]= ((n+j-i+t/n-1)%n)+1;
		}
	    }
	}else if(t==10 &&n==4){
	    return "POSSIBLE\n2314\n3241\n1432\n4123\n";
	}
	else if(t>= n+3 && t<= n*n-3){
	    //find a,b,c such that t=(n-2)a+b+c
	    //ab___..__
	    //cab__..__
	    //_cab_..__
	    //.......__
	    //..___cab_
	    //b.    _ca
	    //     _cab
	    //crazy permute'
	    int[] abc = abc(n,t);
	    int a=abc[0];
	    int b=abc[1];
	    int c=abc[2];
	    
	    int[] rep = new int[n];
	    rep[0]=a;
	    rep[1]=b;
	    rep[n-1]=c;
	    int curr = 2;
	    for(int i=1;i<=n;++i){
		if(i==a)continue;
		if(i==b)continue;
		if(i==c)continue;
		rep[curr]=i;
		++curr;
	    }
	    for(int i=0;i<n;++i){
		for(int j=0;j<n;++j){
		    res[i][j]= rep[((n+j-i)%n)];
		}
	    }
	    //swap last two to get above form
	    int[] temp = res[n-1];
	    res[n-1]=res[n-2];
	    res[n-2]=temp;
	}
	else if(n>=4 && (t== n+2 || t == n*n-2)){
	    boolean flip = t==n*n-2;
	    for(int i=0;i<n-3;++i){
		for(int j=0;j<n;++j){
		    res[i][j]= ((n+j-i)%n)+1;
		}
	    }
	    res[n-3][0]=2;
	    res[n-3][n-1]=3;
	    res[n-3][n-2]=n;
	    res[n-3][n-3]=1;
	    for(int i=1;i<n-3;++i){
		res[n-3][i]=i+3;
	    }
	    res[n-2][n-2]=2;
	    res[n-1][n-2]=1;
	    res[n-2][n-1]=1;
	    res[n-1][n-1]=2;
	    boolean[][] cus = new boolean[n-2][n-2];
	    for(int i=0;i<n-2;++i) {
		for(int j=0;j<n-2;++j) {
		    if(res[i][j]>=3)
			cus[j][res[i][j]-3]=true;
		}
	    }
	    //fill in the last two
	    for(int i=n-2;i<n;++i) {
		Dinic d = new Dinic(2*n-4);
		for(int j=0;j<n-2;++j) {
		    d.add(d.s,j,1,0);
		    d.add(j+n-2,d.t,1,0);
		    for(int v=0;v<n-2;++v) {
			if(!cus[j][v]){
			    d.add(j,v+n-2,1,0);
			    //	    System.err.println("added "+j+" " +v);
			}
		    }
		}
		int x = d.flow();
		if(x!=n-2)
		    System.err.println("whoop"+x);
		//Integer.parseInt("-agsg");//throw an exception
		for(int j=0;j<n-2;++j) {
		    for(Edge e: d.adj[j]) {
			if(e.flow==1) {//part of the matching
			    res[i][j]=e.v2-n+5;
			    cus[j][e.v2-n+2]=true;
			}
		    }
		}
	    }
	    if(flip){
		//flip everything in the array
		for(int i=0;i<n;++i){
		    for(int j=0;j<n;++j){
			res[i][j]= n+1-res[i][j];
		    }
		} 
	    }
	}
	else return "IMPOSSIBLE\n";
	if(!works(n,t,res))System.err.println("WHEE");
	StringBuilder sb=new StringBuilder("POSSIBLE\n");
	for(int i=0;i<n;++i){
	    for(int j=0;j<n;++j){

		sb.append((res[i][j])+(j==n-1?"\n":" "));
	    }
	}
	return sb.toString();
    }
    private static boolean  works(int n,int t, int[][] count){
	int tot=0;
	boolean[][] colseen=new boolean[n][n];
	boolean[][] rowseen=new boolean[n][n];
	boolean[] r = new boolean[n];
	boolean[] c = new boolean[n];
	int rdu = 0;
	int cdu = 0;
	for(int i=0;i<n;++i) {
	    for(int j=0;j<n;++j){

		//System.err.printf("%d%s",count[i][j],j==n-1?"\n":" ");
		if(colseen[i][count[i][j]-1]){
		    c[i]=true;
		}
		if(rowseen[j][count[i][j]-1]){
		    r[j]=true;
		}
		colseen[i][count[i][j]-1]=rowseen[j][count[i][j]-1]=true;
		if(i==j)tot+=count[i][j];
	    }
	    
	}
	for(int i=0;i<n;++i){
	    if(r[i])++rdu;
	    if(c[i])++cdu;
	}
	return cdu==0&&rdu==0&&tot==t;
    }
    public static void main(String[] args) throws Exception{
	br = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int cases=Integer.parseInt(br.readLine());
	for(int cn=1;cn<=cases;cn++){
	    bw.write(String.format("Case #%d: %s",cn,one()));
	    //if(cn!=cases)rl();
	}
	/*
	for(int i=2;i<51;++i){
	    for(int j=i;j<=i*i;++j){
		System.err.println(i+" "+j);
		if(i==4&&j==10)continue;
		one(i,j);
	    }			 
	}		*/	     
	bw.flush();
    }
    static class Edge {
	int v1, v2, cap, flow;
	Edge rev;
	int id;
	
	Edge(int V1, int V2, int Cap, int Flow) {
	    v1 = V1;
	    v2 = V2;
	    cap = Cap;
	    flow = Flow;
	}
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
		    if (e.rev.cap > e.
			rev.flow && dist[e.v2] == -1) {
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
}
