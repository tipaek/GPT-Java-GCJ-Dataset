// package CodeJamQualifier;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		
		int tc = scn.nextInt();
		for(int t = 1;t<=tc;t++) {
			int n =scn.nextInt();
			HashMap<Integer, Activity> graph = new HashMap<>();
			for(int i=1;i<=n;i++) {
				int ts = scn.nextInt();
				int te = scn.nextInt();
				Activity ta = new Activity(i, ts, te);
				
				graph.put(i, ta);
			}
			
			for(int i=1;i<=n;i++) {
				for(int j = i+1;j<=n;j++) {
					if(i!=j) {
						Activity a = graph.get(i);
						Activity b = graph.get(j);
						
						if((a.e>b.s&&a.s<=b.s)||(b.e>a.s&&b.s<=a.s)) {
							a.ngbrs.add(b);
							b.ngbrs.add(a);
						}
					}
				}
			}
			if(bipartite(graph, n)) {
				System.out.print("Case #"+t+": ");
				for(int i =1;i<=n;i++) {
					Activity ta = graph.get(i);
					System.out.print(ta.partner);
				}
				System.out.println();
			}else {
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}
	}
	private static class Activity{
		int idx;
		int s;
		int e;
		ArrayList<Activity> ngbrs;
		Character partner;
		
		public Activity(int idx, int s, int e) {
			this.idx = idx;
			this.s = s;
			this.e = e;
			this.ngbrs = new ArrayList<>();
		}
	}
	private static class bp{
		Activity act;
		Character partner;
	}
	public static boolean bipartite(HashMap<Integer, Activity> graph, int n) {
		LinkedList<bp> queue = new LinkedList<>();
		HashMap<Integer, Character> processed = new HashMap<>();
		
		for(int i =1;i<=n;i++) {
			if(processed.containsKey(i)) {
				continue;
			}
			
			bp np = new bp();
			np.act = graph.get(i);
			np.partner = 'J';
			queue.addLast(np);
			
			while(!queue.isEmpty()) {
				bp rp = queue.removeFirst();
				if(!processed.containsKey(rp.act.idx)) {
					processed.put(rp.act.idx, rp.partner);
					
					for(Activity ngbr :rp.act.ngbrs) {
						if(!processed.containsKey(ngbr.idx)) {
							bp nnp = new bp();
							nnp.act = ngbr;
							nnp.partner = rp.partner=='J'?'C':'J';
							queue.addLast(nnp);
						}
					}
				}else {
					Character oc = processed.get(rp.act.idx);
					Character nc = rp.partner;
					if(oc!=nc) {
						return false;
					}
				}
			}
		}
		for(int i =1;i<=n;i++) {
			Activity ta = graph.get(i);
			ta.partner = processed.get(i);
		}
		return true;
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }


}
