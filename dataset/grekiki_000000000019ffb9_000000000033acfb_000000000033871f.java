import java.io.*;
import java.util.*;
class g{
	ArrayList<Integer>[] E;
	ArrayList<edge>[] E2;
	public g(int n){
		E=new ArrayList[n];
		for(int i=0;i<n;i++){
			E[i]=new ArrayList<Integer>();
		}
		E2=new ArrayList[n];
		for(int i=0;i<n;i++){
			E2[i]=new ArrayList<edge>();
		}
	}
}
class edge{
	int s,d;
	int w;
	edge(int a,int b,int c){
		s=a;
		d=b;
		w=c;
	}
}
public class Solution{
    static PrintWriter out = new PrintWriter(System.out);
	static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public static void solve(int tcase) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		g g=new g(V);
		int[] goal=new int[V+1];
		st=new StringTokenizer(in.readLine());
		for(int i=1;i<V;i++){
			goal[i]=Integer.parseInt(st.nextToken());
		}
		edge[] e=new edge[E];
		for(int i=0;i<E;i++){
			st=new StringTokenizer(in.readLine());
			int l=Integer.parseInt(st.nextToken())-1;
			int r=Integer.parseInt(st.nextToken())-1;
			g.E[l].add(r);
			g.E[r].add(l);
			e[i]=new edge(l,r,1000000);
			g.E2[l].add(e[i]);
			g.E2[r].add(e[i]);
		}
		int[] time=new int[V];
		Arrays.fill(time,-1);
		time[0]=0;
		int curr_time=0;
		int done=1;
		while(done<V){
			ArrayList<Integer> fix=new ArrayList<Integer>();
			for(int i=0;i<V;i++){
				if(goal[i]==-done){
					if(time[i]!=-1) {
						System.out.println("Napaka");
					}
					fix.add(i);
				}
			}
			curr_time++;
			for(int i:fix){
				boolean ok=false;
				for(int p=0;p<g.E[i].size();p++){
					int j=g.E[i].get(p);
					if(time[j]!=-1){
						g.E2[i].get(p).w=curr_time-time[j];
						ok=true;
						break;
					}
				}
				if(!ok) {
					System.out.println("Napaka2");
				}
				time[i]=curr_time;
			}
			done+=fix.size();
		}
//		out.println(Arrays.toString(time));
		out.print("Case #"+tcase+": ");
		for(int i=0;i<e.length;i++) {
			out.print(e[i].w+" ");
		}
		out.println();
	}

	public static void main(String[] args) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		int t=Integer.parseInt(st.nextToken());
		for(int tcase=1;tcase<=t;tcase++){
			solve(tcase);
		}
		out.close();
	}

}
