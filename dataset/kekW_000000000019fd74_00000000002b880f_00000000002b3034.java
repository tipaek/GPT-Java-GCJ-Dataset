import java.io.*;
import java.util.*;
public class Solution{
	final public static int MOD = (int)1e9+7;
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
		int t = sc.nextInt();
		int tot = t;
		while(t-->0) {
			boolean pos = true;
			int n = sc.nextInt();
			String all[] = new String[n];
			int idxf = -1;
			int idxe = -1;
			String end = "";
			String start = "";
			ArrayList<String> ends = new ArrayList<>();
			ArrayList<String> starts = new ArrayList<>();
			all:for(int i=0; i<n; i++) {
				String k = sc.nextToken();
				all[i] = k;
				if(k.charAt(k.length()-1)!='*') {
					int j = k.length()-1;
					while(k.charAt(j)!='*') {
						j--;
					}
					if(k.length()-1-j>idxe) {
						idxe = k.length()-1-j;
						end = "";
						while(j<k.length()-1) {
							j++;
							end = end+Character.toString(k.charAt(j));
						}
						ends.add(end);
					}else  {
						String test = "";
						while(j<k.length()-1) {
							j++;
							test = test+Character.toString(k.charAt(j));
						}
						ends.add(test);
					}
				}
				if(k.charAt(0)!='*') {
					int j = 0;
					while(k.charAt(j)!='*') {
						j++;
					}
					if(j>idxf) {
						idxf =j;
						start = "";
						int cnt = 0;
						while(cnt<j) {
							start = start+Character.toString(k.charAt(cnt));
							cnt++;
						}
						starts.add(start);
					}else  {
						int cnt = 0;
						String test = "";
						while(cnt<j) {
							test = test+Character.toString(k.charAt(cnt));
							cnt++;
						}
						starts.add(test);
					}
				}
			}
			for(String k:starts) {
				int idx = 0;
				while(idx<k.length()) {
					if(start.charAt(idx)!=k.charAt(idx))pos=false;
					idx++;
				}
			}
			for(String k: ends) {
				int idx = k.length()-1;
				int ix = end.length()-1;
				while(idx>=0) {
					if(end.charAt(ix)!=k.charAt(idx)) {
						pos = false;
					}
					ix--;
					idx--;
				}
			}
			String sol = start;
			for(int i=0; i<n; i++) {
				int s = 0;
				int e = all[i].length()-1;
				if(all[i].charAt(0)!='*') {
					s = 0;
					while(all[i].charAt(s)!='*') {
						s++;
					}
				}
				if(all[i].charAt(all[i].length()-1)!='*') {
					e = all[i].length()-1;
					while(all[i].charAt(e)!='*') {
						e--;
					}
				}
				for(int j=s; j<=e; j++) {
					if(all[i].charAt(j)=='*') continue;
					sol = sol + Character.toString(all[i].charAt(j));
				}
			}
			sol = sol + end;
			if(!pos) {
				System.out.println("Case #"+(tot-t)+": " + "*");
			}else {
				System.out.println("Case #"+(tot-t)+": " + sol);
			}
		}
	}
    public static boolean find(String x, String y) {
        int valx = 0;
        int valy = 0;
        for(int i=0; i<x.length(); i++) {
            valx+=(1<<i)*(x.charAt(i)-'A');
            valx%=MOD;
        }
        for(int i=0; i<x.length(); i++) {
            valy+=(1<<i)*(y.charAt(i)-'A');
            valy%=MOD;
        }
        if(valx==valy) {
            return true;
        }
        int index = x.length();
        while(index<y.length()) {
            valy-=y.charAt(index-x.length())-'A';
            valy/=2;
            valy+=((1<<(x.length()-1))*(y.charAt(index)-'A'));
            valy%=MOD;
            if(valx==valy) {
            	return true;
            }
            index++;
        }
        return false;
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