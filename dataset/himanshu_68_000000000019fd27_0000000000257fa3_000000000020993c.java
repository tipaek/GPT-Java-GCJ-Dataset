
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
	public static void solve() {
		int t = s.nextInt();
		int count=1;
		while (t-- > 0) {
			int n=s.nextInt();
			HashSet<Integer> set1=new HashSet<>();
			HashSet<Integer> set2=new HashSet<>();
			int k=0, r=0, c=0;
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++) {
				set1.clear();
				set2.clear();
				for(int j=0;j<n;j++) {
					
					arr[i][j]=s.nextInt();
					if(i==j) {
						k+=arr[i][j];
					}
				}
			}
			for(int i=0;i<n;i++) {
				set1.clear();
				set2.clear();
				for(int j=0;j<n;j++) {
					if(set1.contains(arr[i][j])) {
						r++;
						break;
					}else {
						set1.add(arr[i][j]);
					}
					
				}
			}
			for(int i=0;i<n;i++) {
				set1.clear();
				set2.clear();
				for(int j=0;j<n;j++) {
					
					if(set2.contains(arr[j][i])) {
						c++;
						break;
					}else {
						set2.add(arr[j][i]);
					}
					
				}
			}
			System.out.println("Case #"+count+": "+k+" "+r+" "+c);
			count++;
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		solve();
		out.close();
	}

	public static FastReader s;
	public static PrintWriter out;

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
