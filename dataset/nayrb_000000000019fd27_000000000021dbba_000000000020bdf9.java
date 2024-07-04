import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		
		for(int kei = 0; kei < keis; kei++){
			int N = Integer.valueOf(br.readLine().trim());
			
			int[] ans = new int[N];
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.valueOf(st.nextToken());
				int end = Integer.valueOf(st.nextToken());
				
				Pair p = new Pair(start, end, i);
				pq.add(p);
			}
			boolean imp = false;
			TreeSet<Pair> ts = new TreeSet<Pair>();
			
			
			while(!pq.isEmpty()){
				Pair p = pq.poll();
				Pair pRev = new Pair(p.val2, p.val, p.id);
				// out.println(p);
				
				// out.println("before --------------"+ts);
				NavigableSet<Pair> ns = ts.tailSet(p, false);
				// out.println("after --------------"+ts);
				// out.println("-->"+ns);
				if(ns.size() > 1){
					imp = true;
					break;
				}
				else if(ns.size() == 1){
					Pair p2 = ns.pollFirst();
					if(ans[p2.id] == 1) ans[p.id] = 2;
					else ans[p.id] = 1;
					ns.add(p2);
				}
				else{
					ans[p.id] = 1;
				}
				ts.add(pRev);
				// out.println("--------------"+ts);
				// out.println(Arrays.toString(ans));
			}
			
			out.print("Case #"+(kei+1)+": ");
			if(imp){
				out.print("IMPOSSIBLE");
			}
			else{
				for(int i = 0; i < N; i++){
					if(ans[i] == 1) out.print("C");
					else out.print("J");
				}
				// out.print(Arrays.toString(ans));
			}
			out.println();
		}
	}
	public static class Pair implements Comparable<Pair>{
		int val, val2, id;
		public Pair(int a, int b, int c){
			val = a;
			val2 = b;
			id = c;
		}
		public int compareTo(Pair p){
			if(val == p.val) {
				if(val2 == p.val2) return id - p.id;
				return val2 - p.val2;
			}
			return val - p.val;
		}
		public String toString(){
			return val+" "+val2+" "+id;
		}
		public int hashCode(){
			return id;
		}
		public boolean equals(Object o){
			Pair p = (Pair)o;
			return id == p.id;
		}
	}
}