/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{ 
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
        int T = sc.nextInt();
        int j=0;
        while(j++<T)
        {
            int n= sc.nextInt();
            int flag=0;
            Pair p[]= new Pair[n];
            for(int i=0;i<n;i++)
            {
                p[i]=new Pair(sc.nextInt(), sc.nextInt(),i);
            }
            Arrays.sort(p, new Comparator<Pair>(){
                
                public int compare(Pair e1, Pair e2)
                {
                    if(e1.x>e2.x)
                    return 1;
                    else
                    return -1;
                }
            });
            int a=p[0].y,b=0;
            char s[]= new char[n];
            s[p[0].z]='C';
            for(int i=1;i<n;i++)
            {
                if(p[i].x < a)
                {
                    if(p[i].x>=b)
                    {
                    s[p[i].z]= 'J' ;
                    b= p[i].y;
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }
                else
                {
                    s[p[i].z]= 'C';
                    a= p[i].y;
                }
            }
            String ans="";
            for(int i=0;i<n;i++)
            ans+= s[i];
            if(flag==0)
            System.out.println("Case #"+j+":"+" "+ans);
            else
            System.out.println("Case #"+j+": IMPOSSIBLE");
        }
	}
	static class Pair{
	    int x;
	    int y;
	    int z;
	    public Pair(int a, int b, int c)
	    {
	        x=a;
	        y=b;
	        z=c;
	    }
	}
}
