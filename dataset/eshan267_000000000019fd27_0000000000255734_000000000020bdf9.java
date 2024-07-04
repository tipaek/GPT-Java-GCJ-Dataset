
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
       
 HashMap<Integer,Stack<Integer>> hm = new HashMap<>();
 
 
       for(int j=0;j<n;j++)
       {
       ar[j]=sc.nextInt();
       br[j]=sc.nextInt() ;
       }
       for(int j=0;j<n;j++)
    	hm.put(ar[j],new Stack<Integer>());
       
       for(int j=0;j<n;j++)
       hm.get(ar[j]).push(j);
       
       for(int j=0;j<n;j++)
       {
           for(int l=0;l<n-1;l++)
           {
              if(ar[l]>ar[l+1])
              sw(l,ar,br);
           }
       }
       
    
  StringBuilder se = new StringBuilder("");
    String []ae = new String[n];
      int cd =0,jd = 0;
      cd = br[0];
      
      ae[hm.get(ar[0]).pop()] = "C";
    int fg = 1; 
      for(int j=1;j<n;j++)
       {
           if(cd<=ar[j])
           {
            int nu = hm.get(ar[j]).pop();
            ae[nu]="C";
            cd = br[j]; 
           }
           else if(jd<=ar[j])
           {
        	   int nu = hm.get(ar[j]).pop();
               ae[nu]="J";
               jd = br[j];  
           }
           else
           {
        	   fg=0;
        	   break ;
           }
          
       }
        if(fg==0)
        	se = new StringBuilder("IMPOSSIBLE");
        else
        	for(int k=0;k<n;k++)
        	se.append(ae[k]);
        
          ans.append("case #"+(i)+": "+se+"\n");
     
       }
       

     System.out.print(ans);
        
    }
}
