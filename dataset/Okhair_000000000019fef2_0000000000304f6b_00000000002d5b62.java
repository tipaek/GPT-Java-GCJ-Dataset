import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int tt=sc.nextInt();
		int testnum=1;
		while(tt-->0) {
			int x=sc.nextInt(), y=sc.nextInt();
			if((x&1)+(y&1)!=1) {
				out.printf("Case #%d: IMPOSSIBLE%n", testnum++);
				continue;
			}
			int abse=Math.abs((x&1)==0?x:y);
			int abso=Math.abs((x&1)==1?x:y);
			if(abse==0 && abso==1) {
				
				char c;
				if(x!=0)
					c=x==1?'E':'W';
				else
					c=y==1?'N':'S';
				out.printf("Case #%d: %c%n", testnum++, c);
				continue;
			}
			boolean[] bits= new boolean[35];
			int state=0;
			char[] ans= new char[35];
			if(check1(abse,abso)) {
				ans[0]=(abso==Math.abs(x)?'W':'S');
				int temp=abse>>1, i=1;
				while(temp>0) {
					ans[i++]=(abse==Math.abs(x)?'E':'N');
					temp=temp>>1;
				}
				ans[i]=(abso==Math.abs(x)?'E':'N');
			}
			else if(check2(abse,abso)) {
				for(int i=0;i<ans.length; i++) {
					boolean e=((1l<<i)&abse)>0;
					boolean o=((1l<<i)&abso)>0;
					if(e)
						ans[i]=(abse==Math.abs(x)?'E':'N');
					else if(o)
						ans[i]=(abso==Math.abs(x)?'E':'N');
					else
						break;
				}
				
			}
			else{
				out.printf("Case #%d: IMPOSSIBLE%n", testnum++);
				continue;
			}
//			System.out.println(Arrays.toString(ans));
			boolean revx= (x==(-1*abse) || x==(-1*abso));
			boolean revy= (y==(-1*abse) || y==(-1*abso));
			out.printf("Case #%d: ", testnum++);
			for(char c: ans) {
				if(c!='N' && c!='S' && c!='E' && c!='W') break;
				if(c=='W' || c=='E')
					out.print(revx?(c=='W'?'E':'W'):c);
				else
					out.print(revy?(c=='N'?'S':'N'):c);
			}
			out.println();
		}
		out.close();
	}
	static boolean check1(int a,int b) {
		boolean contig=true;
		for(int i=1;i<35;i++) {
			boolean e=((1l<<i)&a)>0;
			boolean o=((1l<<i)&b)>0;
			if(e ^ o)
				return false;
			if(e && !contig)
				return false;
			if(!e)
				contig=false;
		}
		return true;
	}
	static boolean check2(int a,int b) {
		boolean contig=true;
		for(int i=1;i<35;i++) {
			boolean e=((1l<<i)&a)>0;
			boolean o=((1l<<i)&b)>0;
			if(e && o)	return false;
			if(!e && !o) contig=false;
			if(!contig && e!=o)
				return false;
		}
		return true;
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

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}