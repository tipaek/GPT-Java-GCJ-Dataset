
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vestigium {
	public static class MyScanner {
		BufferedReader bf;
		StringTokenizer st;

		MyScanner() {
			bf = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		
		int T= sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			
			int N= sc.nextInt();
			
			int trace =0;
			int rowcnt =0;
			int colcnt =0;
			int arr[][]= new int[N][N];
			for(int i =0 ;i <N;i++) {
				for(int j=0 ;j<N;j++) {
					arr[i][j] = sc.nextInt();
					if(i==j) trace +=arr[i][j];
				}
			}
			
			// row check
			for(int i =0 ;i<N;i++) {
				boolean v[] = new boolean[N+1];
				for(int j= 0 ;j <N;j++) {
					if(v[arr[i][j]]) {
						rowcnt++;
						break;
					}
					else v[arr[i][j]] = true;
				}
			}
			
			//col check
			
			for(int i =0 ;i<N;i++) {
				boolean v[] = new boolean[N+1];
				for(int j= 0 ;j <N;j++) {
					if(v[arr[j][i]]) {
						colcnt++;
						break;
					}
					else v[arr[j][i]] = true;
				}
			}
			
			System.out.printf("Case #%d: %d %d %d\n",tc,trace,rowcnt,colcnt);
			
		}
	}

}
