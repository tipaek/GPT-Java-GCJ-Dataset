
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	public static void solve() {
		int t = s.nextInt();
		int count=1;
		while (t-- > 0) {
			int n=s.nextInt();
			int arr[][]=new int[n][2];
			for(int i=0;i<n;i++) {
				arr[i][0]=s.nextInt();
				arr[i][1]=s.nextInt();
			}

			int arr1[][]=new int[n][2];
			arr1[0][0]=0;
			arr1[0][1]=0;
			
			int arr2[][]=new int[n][2];
			arr2[0][0]=0;
			arr2[0][1]=0;
	
			int j=0,k=0;
			StringBuilder str= new StringBuilder();
			str.append('C');
			arr1[0][0]=arr[0][0];
			arr1[0][1]=arr[0][1];
			for(int i=1;i<n;i++) {
				
				
				if(arr1[k][1]<=arr[i][0]||(arr1[k][1]>arr[i][0]&&arr1[k][0]>=arr[i][1])) {
					k++;
					arr1[k][0]=arr[i][0];
					arr1[k][1]=arr[i][1];
					str.append('C');	
					Arrays.sort(arr1,0,k, (a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
				}
				else if(arr2[j][1]<=arr[i][0]||(arr2[j][1]>arr[i][0]&&arr2[j][0]>=arr[i][1])) {
					j++;
					arr2[j][0]=arr[i][0];
					arr2[j][1]=arr[i][1];
					str.append('J');
					Arrays.sort(arr2,0,j, (a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
				}else {
					str.replace(0, str.length(), "IMPOSSIBLE");
					break;
				}
				
				
//				if(arr1[k][1]>arr[i][0]&&arr1[k][0]<arr[i][1]) {
//					if(arr2[j][1]<=arr[i][0]||(arr2[j][1]>arr[i][0]&&arr2[j][0]>=arr[i][1])) {
//						j++;
//						arr2[j][0]=arr[i][0];
//						arr2[j][1]=arr[i][1];
//						str.append('J');
//					}else {
//						str.replace(0, str.length(), "IMPOSSIBLE");
//						break;
//					}
//				}else {
//					if(arr1[k][1]<=arr[i][0]||(arr1[k][1]>arr[i][0]&&arr[k][0]>arr[i][1])) {
//						k++;
//						arr1[k][0]=arr[i][0];
//						arr1[k][1]=arr[i][1];
//						str.append('C');	
//					}else {
//						str.replace(0, str.length(), "IMPOSSIBLE");
//						break;
//					}
//				}
			}
			System.out.println("Case #"+count+": "+str);
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
