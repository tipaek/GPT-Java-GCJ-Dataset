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
  
    
    public static void main(String [] args)
{
        FastReader sc = new FastReader();
        StringBuilder ans = new StringBuilder("");
        int t = sc.nextInt();
for(int i =0;i<t;i++)
{
     String s = sc.next();
     StringBuilder as = new StringBuilder("");
        char a = s.charAt(0);
        int cl = a - 48 ;
        
        for(int j=0;j<cl;j++)
        as.append("(");
        
        as.append(a+"");
        
 for(int k=1;k<s.length();k++)
 {
           char b = s.charAt(k);
           int bc = b - 48;
   if(b==a)  
   as.append(b+"");
    else if(bc==0)
   {
        for(int j=0;j<cl;j++)
        as.append(")");  
        
        as.append("0");
        cl=0;
   }
    else if(cl==0)
   {
        cl = bc;
        for(int j=0;j<cl;j++)
        as.append("(");
        
        as.append(b+"");
   }
    else if(cl<bc)
   {
    for(int j=0;j<(bc-cl);j++)
    as.append("(");
    
    as.append(b+"");
    cl = bc ;
   }
   else if(cl>bc)
   {
      for(int j=0;j<(cl-bc);j++)
    as.append(")");
    
    as.append(b+"");
    cl = bc ;  
   }
   a = b ;
           
           
}
for(int j=0;j<cl;j++)
as.append(")");

  ans.append("case #"+(i+1)+": "+as+"\n");          
            
  }
  System.out.print(ans);
        
}

}
        
        
        
        
        
        
        
        
        