import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	
	public static boolean findNextDfs(int u){
		if(u < 0) return true;
		if(vis[u]) return false;
		vis[u] = true;
		for(int v : adjList[u]){
			if(findNextDfs(pred[v])){
				pred[v] = u;
				return true;
			}
		}
		return false;
	}
	public static int bm(){
		int ret = 0;
		for(int i = 0; i < 10; i++){
				if(findNextDfs(i)) ret++;
		}
		return ret;
	}
	public static int N;
	public static int[] pred;
	public static LL[] adjList;
	public static boolean[] vis;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int keis = Integer.valueOf(br.readLine().trim());
		int Q = 10000;
		for(int kei = 0; kei < keis; kei++){
			int U = Integer.valueOf(br.readLine().trim());
			
			HashMap<Character, CheckList> hm = new HashMap<Character, CheckList>();
			ArrayList<Character> alist = new ArrayList<Character>();
			
			for(int q =0 ; q < Q ; q++){
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				long M = Long.valueOf(st.nextToken());
				long Mlen = 1;
				
				long tmpM = M;
				while(true){
					tmpM = tmpM/10;
					if(tmpM == 0) break;
					Mlen++;
				}
				
				String str = st.nextToken();
				int len = str.length();
				
				if(len < Mlen){
					for(int i = 0; i < len; i++){
						char ch = str.charAt(i);
						if(!hm.containsKey(ch)){
							hm.put(ch, new CheckList(true));
							alist.add(ch);
						}
						
						CheckList c = hm.get(ch);
						CheckList tmp = new CheckList(true);
						if(i != len - 1){
							tmp.arr[0] = false;
						}
						
						c.combine(tmp);
						hm.put(ch, c);
					}
				}
				else{
					for(int i = 1; i < len; i++){
						char ch = str.charAt(i);
						if(!hm.containsKey(ch)){
							hm.put(ch, new CheckList(true));
							alist.add(ch);
						}
						
						CheckList c = hm.get(ch);
						CheckList tmp = new CheckList(true);
						if(i != len - 1){
							tmp.arr[0] = false;
						}
						
						c.combine(tmp);
						hm.put(ch, c);
					}
					//first char
					long tendiv= 1;
					for(int i = 0; i < Mlen-1; i++){
						tendiv = tendiv*10;
					}
					long k = M/tendiv;
					
					char ch = str.charAt(0);
					if(!hm.containsKey(ch)){
						hm.put(ch, new CheckList(true));
						alist.add(ch);
					}
					if(Mlen == 1){
						CheckList c = hm.get(ch);
						CheckList tmp = new CheckList(false);
						for(int i = 0; i <= k; i++){
							tmp.arr[i] = true;
						}
						c.combine(tmp);
						hm.put(ch, c);
					}
					else{
						CheckList c = hm.get(ch);
						CheckList tmp = new CheckList(false);
						for(int i = 1; i <= k; i++){
							tmp.arr[i] = true;
						}
						c.combine(tmp);
						
						hm.put(ch, c);
					}
				}	
				
			}
			
			// for(int i = 0; i < alist.size(); i++){
				// char ch = alist.get(i);
				// out.println(ch+" "+hm.get(ch));
			// }
			
			//0-9 characters
			//10 - 19 numbers
			
			
			
			N = 20;
			int NN = 22;
			pred = new int[NN];
			vis = new boolean[NN];
			adjList = new LL[NN];
			for(int i =0 ; i < NN; i++){
				adjList[i] = new LL();
				pred[i] = -1;
			}
			int[][] flow = new int[N+2][N+2];
			int[][] cap = new int[N+2][N+2];
			int[] min = new int[N+2];
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			int S = N;
			int T = N + 1;
			
			for(int i = 0; i < 10; i++){
				cap[S][i] = 1;
				cap[10 + i][T] = 1;
				adjList[S].add(i);
				adjList[i].add(S);
				
				adjList[10 + i].add(T);
				adjList[T].add(10 + i);
			}
			
			for(int i = 0; i < 10; i++){
				char ch = alist.get(i);
				CheckList c = hm.get(ch);
				for(int j = 0; j < 10; j++){
					if(c.arr[j]){
						adjList[i].add(10 + j);
						adjList[10 + j].add(i);
						cap[i][10 + j] = 1;
					}
					
				}
			}
			// out.println(bm());
			
			// out.println(Arrays.toString(pred));
			
			int f = 0;
			while(true){
				Arrays.fill(pred, -1);
				Arrays.fill(min, Integer.MAX_VALUE);
				
				list.clear();
				list.add(S);
				pred[S] = S;
				
				while(!list.isEmpty()){
					int u = list.removeFirst();
					for(int v : adjList[u]){
						int res = cap[u][v] - flow[u][v];
						if(res > 0 && pred[v] == -1){
							pred[v] = u;
							min[v] = Math.min(min[u], res);
							if(v == T){
								while(true){
									u = pred[v];
									if(v == S){
										break;
									}
									flow[u][v] += min[T];
									flow[v][u] -= min[T];
									v = u;
								}
								f += min[T];
								break;
							}
							else{
								list.add(v);
							}
						}
					}
					if(pred[T] != -1) break;
				}
				if(pred[T] == -1) break;
			}
			// out.println(f);
			
			int[] ans = new int[10];
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					if(flow[i][10 + j] > 0){
						ans[j] = i;
					}
				}
			}
			out.print("Case #"+(kei+1)+": ");
			for(int i = 0; i < 10; i++){
				out.print(alist.get(ans[i]));
			}
			out.println();
			
		}
	}
	public static class CheckList{
		boolean[] arr;
		int count;
		public CheckList(boolean a){
			arr = new boolean[10];
			count = 10;
			for(int i = 0; i < 10; i++){
				arr[i] = a;
			}
		}
		public void combine(CheckList c){
			for(int i =0 ; i < 10; i++){
				arr[i] = arr[i] & c.arr[i];
			}
			count = 0;
			for(int i = 0; i < 10; i++){
				if(arr[i]) count++;
			}
		}
		public String toString(){
			String str = "";
			for(int i = 0; i < 10; i++){
				if(arr[i]) str += "1 ";
				else str += "0 ";
			}
			return str;
		}
	}
	public static class LL extends LinkedList<Integer>{}
}