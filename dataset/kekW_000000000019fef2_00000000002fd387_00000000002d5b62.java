import java.io.*;
import java.math.BigInteger; 
import java.util.*;
class Solution{
	final public static int MOD = (int)1e9;
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int cas = 1; cas<=t; cas++) {
			int a1 = sc.nextInt();
			int b2 = sc.nextInt();
			int a =Math.abs(a1);
			int b = Math.abs(b2);
			//System.out.println(a + " "  + b);
			boolean good = true;
			int sum = a+b;
			int big = Integer.highestOneBit(sum);
			int d = Integer.numberOfTrailingZeros(big)+1;
			int two[] = new int[d];
			Arrays.fill(two, 1);
			//System.out.println(d);
			big*=2;
			big--;
			String ans = "";
			int c= a;
			int e = b;
			int mis = big^sum;
			for(int i=1; i<d; i++) {
				if(kthbit(mis,i)) {
					//System.out.println("HI");
					two[i-1] = -1;
				}
			}
			
			if(Integer.lowestOneBit(mis)==1) {
				good = false;
				out.println("Case #" + cas + ": IMPOSSIBLE");
				continue;
			}else {
				for(int i=0; i<d; i++) {
					//System.out.println(two[i] + " Eye " + i);
					if(two[i]==-1&&kthbit(a,i)) {
						c+=Math.pow(2, i+1);
					}
					if(two[i]==-1&&kthbit(b,i)) {
						e+=Math.pow(2, i+1);
					}
				}
				//System.out.println(c + " " + e);
				for(int i=0; i<d; i++) {
					if(kthbit(c,i)) {
						if(two[i]==1) {
							if(a1<0) {
								ans = ans + "W";
							}else {
								ans = ans + "E";
							}
						}else {
							if(a1<0) {
								ans = ans + "E";
							}else {
								ans = ans + "W";
							}
						}
					}else if(kthbit(e,i)) {
						if(two[i]==1) {
							if(b2<0) {
								ans = ans + "S";
							}else {
								ans = ans + "N";
							}
						}else {
							if(b2<0) {
								ans = ans + "N";
							}else {
								ans = ans + "S";
							}
						}
					}
				}
				out.println("Case #" + cas + ": " + ans);
			}
			
		}
		out.close();
	}
    public static boolean kthbit(int n,int k) 
    { 	
    	if((n&(1<<(k)))!=0) {
    		return true;
    	}else {
    		return false;
    	}
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