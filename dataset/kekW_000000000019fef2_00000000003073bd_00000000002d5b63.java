import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int cas = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int t=1; t<=cas; t++) {
			if(a==(int)1e9-5) {
				int x = -5;
				int y = -5;
				while(a==(int)1e9-5) {
					System.out.println(x + " " + y);
					String k = sc.nextToken();
					if(k.equals("CENETER")) break;
					else {
						if(x<5) x++;
						else {
							y++; x= -5;
						}
					}
				}
			}else if(a==(int)1e9-50) {
				int x = -(int)1e9;
				int y = 0;
				boolean find = false;
				while(!find) {
					System.out.println(x + " " + y);
					String k = sc.nextToken();
					if(k.equals("MISS")) x++;
					else find = true;
				}
				boolean solve = false;
				System.out.println(x + " " + 1);
				String k = sc.nextToken();
				if(k.equals("MISS")) {
					while(!solve) {
						y--;
						System.out.println(x + " " + y);
						String str = sc.nextToken();
						if(str.equals("MISS")) {
							y++;
							solve = true;
						}
						boolean back = true;
						while(back) {
							x--;
							System.out.println(x + " " + y);
							String str1 = sc.nextToken();
							if(str1.equals("MISS"))back = false;
						}
						x++;
					}
				}else {
					while(!solve) {
						y++;
						System.out.println(x + " " + y);
						String str = sc.nextToken();
						if(str.equals("MISS")) {
							y--;
							solve = true;
						}
						boolean back = true;
						while(back) {
							x--;
							System.out.println(x + " " + y);
							String str1 = sc.nextToken();
							if(str1.equals("MISS"))back = false;
						}
						x++;
					}
				}
				System.out.println((x+((int)1e9-50)) + " " + y);
			}
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