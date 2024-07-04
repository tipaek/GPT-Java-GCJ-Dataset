import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static Queue<pair> q ;
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int t=0;
		try {
			t = sc.nextInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.printf("Case #%d: %s\n",1,"iMPOSSIBLE");
		}
		int k = 1;
		while (t-- > 0) {
			int x;
			try {
				x = sc.nextInt();
				int y=sc.nextInt();
				String s =sc.next();
				int i=x;
				int j=0;
				int o=x;
				int timepassed = 0;
				String Solution ="IMPOSSIBLE";
				for(int l=0;l<i;l++) {
					if(s.charAt(l)=='N') {
						y++;
					}
					else if (s.charAt(l)=='S') {
						y--;
					}
					timepassed++;
					
				}
				int a;
				for( a=o;a<s.length();a++) {
					timepassed++;
					if(s.charAt(a)=='N') {
						y++;
					}
					else if (s.charAt(a)=='S') {
						y--;
					}
			
					if (j<y) {
						j++;
					}
					else if (j>y) {
						j--;
					}
					if (y==j) {
						Solution = timepassed+"";
						break;
					}
				}
				if (y==j&&Solution.equals("IMPOSSIBLE")) {
					Solution = timepassed+"";
				}
						System.out.printf("Case #%d: %s\n",k++,Solution);
			} catch (IOException e) {
				// TODO Auto-generated catch block
						System.out.printf("Case #%d: %s\n",k++,"IMPOSSIBLE");			}


		}
		
	}
	static HashMap<String,String> hm = new HashMap<>();
	public static String XofY(String x) {
		if (x.length()==0) return "";
		if (hm.containsKey(x)) return hm.get(x);
		StringBuilder sb = new StringBuilder();

		for (int i=0;i<x.length();i++) {

			if(x.charAt(i)=='N'||x.charAt(i)=='W'||x.charAt(i)=='E'||x.charAt(i)=='S') {
				sb.append(x.charAt(i));
			}else if (x.charAt(i)>='2'&&x.charAt(i)<='9') {
				Integer b =Integer.parseInt(x.charAt(i)+"");
				String g=XofY(x.substring(i+2));
					for(int j=0;j<b;j++) {
						sb.append(g);
					}
					if (!q.isEmpty()) {
					pair p = q.poll();
					i+=p.y-p.x+1;
			}
			}
			else if (x.charAt(i)==')') {
				hm.put(x,sb.toString());
				return sb.toString();
			}
					
		}
		hm.put(x, sb.toString());
		return sb.toString();
	}
	

	public static StringBuilder fillwitho(StringBuilder sb, int c) {
		while (c-- > 0) {
			sb.append('(');
		}
		return sb;
	}

	public static StringBuilder fillwithc(StringBuilder sb, int c) {
		while (c-- > 0) {
			sb.append(')');
		}
		return sb;
	}

	static class person implements Comparable<person> {
		Integer start;
		Integer end;
		String doer;

		public person() {
		}
		public person(int s,int e) {
			start=s;
			end=e;
		}

		public void giveTask(String S) {
			doer=S;
			
		}

		@Override
		public int compareTo(person o) {
			return  this.start!=o.start?this.start-o.start:this.end-o.end;
		}
	}

	static class pair implements Comparable<pair> {
		Integer x, y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return x.compareTo(o.x) ;
		}
		public String toString() {
			return "(" + x+", "+y+")";
		}
	}

	static class Scanner {
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

}
