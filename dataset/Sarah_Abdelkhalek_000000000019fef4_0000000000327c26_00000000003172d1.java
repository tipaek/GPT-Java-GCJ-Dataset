import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		System.out.printf("Case #%d: %d\n",caseNum++,t1);
		int caseNum = 1;
		int t = sc.nextInt();
		out: while (t-- > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			Double arr[] = new Double[n];
			
			TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextDouble();
				int count = map.getOrDefault(arr[i], 0) + 1;
				map.put(arr[i], count);
			
				
			}
//			System.out.println(Arrays.toString(arr));
			if(d==2) {
				for(int i=0;i<n;i++) {
					if(map.get(arr[i])>=2) {
						System.out.printf("Case #%d: %d\n",caseNum++,0);
						continue out;
					}
				}
				System.out.printf("Case #%d: %d\n",caseNum++,1);

				
			}else {
				for(int i=0;i<n;i++) {
					if(map.get(arr[i])>=3) {
						System.out.printf("Case #%d: %d\n",caseNum++,0);
						continue out;
					}
				}
				for(int i=0;i<n;i++) {
					if(map.get(arr[i])>=2 && map.ceilingKey(arr[i]+0.1)!=null){
						
						System.out.printf("Case #%d: %d\n",caseNum++,1);
						continue out;
					}
				}
				for(int i=0;i<n;i++) {
					if(map.containsKey((arr[i])*2)) {
						System.out.printf("Case #%d: %d\n",caseNum++,1);
						continue out;
					}
				}
				System.out.printf("Case #%d: %d\n",caseNum++,2);
			}
		}
			
	}

}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}
