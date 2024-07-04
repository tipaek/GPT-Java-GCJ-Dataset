import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		test:for(int t=1; t<=cas; t++) {
			int u = sc.nextInt();
			TreeMap<Character, Integer> mp = new TreeMap<>();
			int idx = 0;
			String ans = "";
			long occ[] = new long[10];
			long firstocc[] = new long[10];
			char lett[] = new char[10];
			for(int i = 0; i<10000; i ++) {
				int q = sc.nextInt();
				String str = sc.nextToken();
				int n = str.length();
				if(!mp.containsKey(str.charAt(0))) {
					mp.put(str.charAt(0), idx);
					lett[idx] = str.charAt(0);
					idx++;
				}
				firstocc[mp.get(str.charAt(0))]++;
				for(int j=1; j<n; j++) {
					if(!mp.containsKey(str.charAt(j))) {
						mp.put(str.charAt(j), idx);
						lett[idx] = str.charAt(j);
						idx++;
					}
					occ[mp.get(str.charAt(j))]++;
				}
			}
			boolean used[] = new boolean[10];
			for(int i=0; i<10; i++) {
				if(firstocc[i]==0) {
					ans = ans + lett[i];
					used[i] = true;
				}
			}
			first:for(int i=0; i<10; i++) {
				if(used[i]) {
					//System.out.println(lett[i] + " used");
					continue;
				}
				//System.out.println((occ[i]+firstocc[i]) + " " + lett[i]);
				//System.out.println(i);
				//System.out.println(occ[1] + firstocc[1]);
				for(int j=0; j<10; j++) {
					if(j==i) continue;
					if(used[j]) continue;
					//System.out.println(i + " " + (occ[j]+firstocc[j]));
					if(occ[j]+firstocc[j]>occ[i]+firstocc[i]) {
						continue first;
					}
				}
				ans = ans + Character.toString(lett[i]);
				used[i] = true;
				if(ans.length()<10) {
					i =-1;
					//System.out.println("HI " + i);
				}
				//occ[i] = 0;
				//firstocc[i] = 0;
			}
			System.out.println("Case #" + t + ": " + ans);
			
		}
		
		out.close();
  	}
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
          return st.nextToken();
		}

		String nextLine() {
			st = null;
			try {
				return br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}
}