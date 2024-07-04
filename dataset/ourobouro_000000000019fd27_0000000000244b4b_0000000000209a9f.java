
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    
    static class FastReader{
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            
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
        
        int nextInt() {
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

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
      
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        String str = fastRead.nextLine();
        
        int length = str.length();
        
        String output = new String();
        
        int left = 0;
        
        for(int i=0;i<length;i++){
            
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            
            if(value > left){
                int newAdd = value - left;
                
                for(int j=1;j<=newAdd;j++){
                   output = output.concat("(");
                }
                
                left += newAdd;
            }
            else if(value < left){
               int newAdd = left - value;
                               
               for(int k=1;k<=newAdd;k++){
                  output = output.concat(")");
               }
                
               left = value;
            }
            
            output = output.concat(String.valueOf(str.charAt(i)));
        }
        
        for(int l=1;l<=left;l++){
            output = output.concat(")");
        }
        
        caseNum++;
        out.println("Case #"+caseNum+": "+output);
   }
      
    out.close();
  }
}
