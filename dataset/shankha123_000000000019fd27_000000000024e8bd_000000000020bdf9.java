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
		int aa[];int n,x,a,b;boolean bb;int s1[],s2[];int e1[],e2[];
		char c[]; boolean c1,c2;int k1,k2;
		while (t-->0)
		{
		    aa=new int[1445];n=sc.nextInt();bb=true;
		    c=new char[n];x=0;k1=-1;k2=-1;c1=false;c2=false;
		    s1=new int[1445];s2=new int[1445];
		    e1=new int[1445];e2=new int[1445];
		    for (int i=0;i<1445;s1[i]=-1,s2[i]=-1,i++);
		    for (int i=0;i<n;i++)
		    {
		        a=sc.nextInt()+1;b=sc.nextInt()+1;
		        aa[a]++;aa[b]--;
		        if (s1[a]==-1) {s1[a]=i;e1[a]=b;}
		        else if (s2[a]==-1) {s2[a]=i;e2[a]=b;}
		        else bb=false;
		    }
		    for (int i=1;i<aa.length-1;i++)
		    {
		        x+=aa[i];
		        if (i==k1){c1=false;k1=-1;}
		        if (i==k2){c2=false;k2=-1;}
		        if (x>2)bb=false;
		        else if (s1[i]!=-1)
		        {
    		        //o.println(c1+" "+c2);
    		        if (!c1){c[s1[i]]='C';c1=true;k1=e1[i];}
    		        else if (!c2){c[s1[i]]='J';c2=true;k2=e1[i];}
    		        else bb=false;
    		        if (s2[i]!=-1)
    		        {
        		        if (!c1){c[s2[i]]='C';c1=true;k1=e2[i];}
        		        else if (!c2){c[s2[i]]='J';c2=true;k2=e2[i];}
        		        else bb=false;
    		        }
    		        
    		        //o.println(Arrays.toString(c)+" "+x);
    		    }
    		        //o.println(k1+" "+k2);
    		        
		    }
		    
		    String sss=new String(c);
		    if (!bb)
		    o.println("Case #"+(s++)+": IMPOSSIBLE");
		    else o.println("Case #"+(s++)+": "+sss);
		}
        o.flush();
        o.close();
	}
} 