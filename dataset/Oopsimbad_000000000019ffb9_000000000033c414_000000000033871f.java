import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d:", asdf);
			int n = f.nextInt(), m = f.nextInt();
			ArrayList<Pair> neg = new ArrayList<>(), pos = new ArrayList<>();
			LinkedList<Pair>[] adj = new LinkedList[n];
			LinkedList<Pair>[] tree = new LinkedList[n];
			int[] order = new int[n];
			int[] dist = new int[n];
			int[] C = new int[n];
			adj[0] = new LinkedList<>();
			tree[0] = new LinkedList<>();
			for(int i = 1; i < n; i++) {
				int a = f.nextInt();
				C[i] = a;
				adj[i] = new LinkedList<>();
				tree[i] = new LinkedList<>();
				if(a > 0) pos.add(new Pair(a,i));
				else neg.add(new Pair(a,i));
			}
			
			
			Collections.sort(neg);
			Collections.sort(pos);
			{
				int j = 0, k = 0;
				for(int i = 1; i < n; i++) {
					if(j == neg.size()) order[i] = pos.get(k++).b;
					else if(k == pos.size()) order[i] = neg.get(j++).b;
					else if(-neg.get(j).a <= i) order[i] = neg.get(j++).b;
					else order[i] = pos.get(k++).b;
				}
			}
			for(int i = 1; i < n; i++) {
				if(C[order[i]] == C[order[i-1]]) dist[order[i]] = dist[order[i-1]];
				else if(C[order[i]] > 0) dist[order[i]] = C[order[i]];
				else dist[order[i]] = dist[order[i-1]]+1;
			}
			int[] ans = new int[m];
			Arrays.fill(ans,1000000);
			for(int i = 0; i < m; i++) {
				int a = f.nextInt()-1, b = f.nextInt()-1;
				adj[a].add(new Pair(b, i));
				adj[b].add(new Pair(a, i));
			}
			boolean[] vis = new boolean[n];
			vis[0] = true;
			for(int i = 1; i < n; i++) {
				for(Pair p : adj[order[i]]) {
					if(vis[p.a] && dist[order[i]] != dist[p.a]) {
						ans[p.b] = dist[order[i]]-dist[p.a];
						break;
					}
				}
				vis[order[i]] = true;
			}
			for(int i : ans) out.print(" "+i);
			out.println();
		}
///
		out.flush(); 
	}
	class Pair implements Comparable<Pair> {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair p) {
			if(a < 0) return -Integer.compare(a,p.a);
			return Integer.compare(a,p.a);
		}
	}
///
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
