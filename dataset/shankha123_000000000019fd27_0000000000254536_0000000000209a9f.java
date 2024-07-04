import java.util.*;
import java.io.*;

public class Solution
{
    static class Reader {
		BufferedReader br;
		StringTokenizer st;
 
		public Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
 
	}
	static void ca(String s ,int k)
	{
	    if (k==10)return ;
	    int a,b;
	    for (int i=0;i<s.length();)
	    {
	        if (s.charAt(i)-'0'!=k)
	        {
	            a=i;
	            while (i<s.length() && s.charAt(i)-'0'!=k)i++;
	            //System.out.print("-"+i+"-");
	            System.out.print("(");ca(s.substring(a,i),k+1);
	            System.out.print(")");
	        }
	        else {System.out.print(k);i++;}
	    }
	}
	public static void main(String[] args) throws IOException 
	{
		Reader sc=new Reader();//Main G=new Main();
		PrintWriter o = new PrintWriter(System.out);
		int t=sc.nextInt();int s=1;
		while (t-->0)
		{
		    System.out.print("Case #"+(s++)+": ");
		    ca(sc.next(),0);
		    System.out.println();
		}
        o.flush();
        o.close();
	}
} 