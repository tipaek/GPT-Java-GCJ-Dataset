import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Solution
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
    public static void sw(int i,int []ar,int []br)
    {
       int temp = ar[i];
        ar[i] = ar[i+1];
        ar[i+1] = temp ;
        
        temp = br[i];
        br[i] = br[i+1];
        br[i+1] = temp ;
    }
    
    public static void main(String []args)
    {
       FastReader sc = new FastReader();
       StringBuilder ans = new StringBuilder("");
     int t = sc.nextInt();
     for(int i=1;i<=t;i++)
     {
       int n = sc.nextInt();
       int []ar = new int[n];
       int []br = new int[n];
       
       for(int j=0;j<n;j++){
       ar[j]=sc.nextInt();
       br[j]=sc.nextInt();
       }
       
       
       for(int k=0;k<n;k++)
       {
           for(int j=0;j<n-1;j++)
           {
              if(ar[j]>ar[j+1])
              sw(j,ar,br);
           }
       }
       StringBuilder se = new StringBuilder("");
       int cd = br[0];
       int jd = -1;
        se.append("C");
       for(int j=1;j<n;j++)
       {
          if(ar[j]>=cd)
          {
              cd = br[j];
              se.append("C");
          }
          else if(ar[j]>=jd)
          {
           jd = br[j];
           se.append("J");
          }
          else
          {
              se = new StringBuilder("IMPOSSIBLE");
              break ;
          }
       }
       
 ans.append("Case #"+(i+1)+": "+se+"\n");
       
       
     }
     System.out.print(ans);
        
    }
}