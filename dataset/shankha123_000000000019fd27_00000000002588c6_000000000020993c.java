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
	public static void main(String[] args) throws IOException 
	{
		Reader sc=new Reader();//Main G=new Main();
		PrintWriter o = new PrintWriter(System.out);
		int t=sc.nextInt();int s=1;
		int n,a[][];
		int s1,s2,s3;
		HashSet<Integer> ob=new HashSet<>();
		while (t-->0)
		{
		    n=sc.nextInt();a=new int[n][n];s1=0;s2=0;s3=0;
		    for (int i=0;i<n;i++)for (int j=0;j<n;j++)
		    a[i][j]=sc.nextInt();
		    
		    for (int i=0;i<n;i++)s1+=a[i][i];
		    
		    for (int i=0;i<n;i++)
		    {
		        
		        for (int j=0;j<n;j++)
		        {
		            ob.add(a[i][j]);
		        }
		        if (ob.size()!=n)s2++;
		        ob.clear();
		    }
		    
		    
		    for (int i=0;i<n;i++)
		    {
		        for (int j=0;j<n;j++)
		        {
		            ob.add(a[j][i]);
		        }
		        if (ob.size()!=n)s3++;
		        ob.clear();
		    }
		    
		    
		    o.println("Case #"+(s++)+": "+s1+" "+s2+" "+s3);
		}
        o.flush();
        o.close();
	}
} 