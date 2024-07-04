
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
      int n = fastRead.nextInt();
       
       int [][] nums = new int[n][n];
       int traceSum = 0;
      
       for(int i=0;i<n;i++){
           
           for(int j=0;j<n;j++){
               
               int num = fastRead.nextInt();
               nums[i][j] = num;
               
               if(i==j){
                   traceSum += num;
               }
           }
       }
       
       int repeatedRows = 0;
       int repeatedCols = 0;
       
       for(int i=0;i<n;i++){
           
           int [] map = new int[n+1];
           
           for(int j=0;j<n;j++){
               
               int num = nums[i][j];
               
               if(map[num] == 1){
                   repeatedRows++;
                   break;
               }
               else{
                   map[num] = 1;
               }
           }
           
       }
       
       for(int j=0;j<n;j++){
           
           int [] map = new int[n+1];
           
           for(int i=0;i<n;i++){
               
               int num = nums[i][j];
               
               if(map[num] == 1){
                   repeatedCols++;
                   break;
               }
               else{
                   map[num] = 1;
               }
           }
       }
       
       caseNum++;
       
       out.println("Case #"+caseNum+": "+traceSum+" "+repeatedRows+" "+repeatedCols);
    }
    
      out.close();
  }
}
