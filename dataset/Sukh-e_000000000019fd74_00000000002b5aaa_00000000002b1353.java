import java.io.*;
import java.util.*;
import java.math.*;

 
public class Solution
{
    public static void main(String[] args)
    {
        FastReader s=new FastReader();
		 int t=s.nextInt();
	   for(int f=0;f<t;f++)
        {
            int n=s.nextInt();
            String a=Integer. toBinaryString(n);
            StringBuilder sbr=new StringBuilder("");
            int c=1;
            //System.out.println(a);
            for(int i=a.length()-1;i>=0;i--){
                if(a.charAt(i)=='1'){
                    for(int j=1;j<=c;j++){
                        sbr.append((c)+" "+(j)+"\n");
                    }
                }
                c++;
            }
            System.out.println("Case #"+(f+1)+":");
            System.out.print(sbr);
        }
		
		
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
 
   
}
        