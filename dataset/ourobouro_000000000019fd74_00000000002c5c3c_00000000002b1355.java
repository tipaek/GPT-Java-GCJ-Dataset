
import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
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
    
   public class Location{
        int value;
        int neighbourCount;
       
       Location(int val, int nc){
           this.value = val;
           this.neighbourCount = nc;
       }
   }

  public static void main(String[] args) {
   
    FastReader fastRead = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int t = fastRead.nextInt();
    int caseNum = 0;
      
    while (t-- > 0) {
        
        int r = fastRead.nextInt();
        int c = fastRead.nextInt();
        
        int [][] nums = new int [r+1][c+1];
        
        for(int i=1;i<=r;i++){
            
            for(int j=1;j<=c;j++){
                int val = fastRead.nextInt();
               
                nums[i][j] = val;
            }
        }
        
        int countRemoved = 1;
        long answer = 0;
        
        while(countRemoved > 0){
            
            countRemoved = 0;
            
            int [][] numsCopy  = new int[r+1][c+1];
            
            long  sum = 0;
            
            for(int i=1;i<=r;i++){
                
                for(int j=1;j<c;j++){
                    
                    numsCopy[i][j] = nums[i][j];
                    
                    if(nums[i][j] > 0){
                        
                        sum += nums[i][j];
                        
                        long  sumAdj = 0;
                        int adjCount = 0;
                        
                        if(i-1 >= 1 && nums[i-1][j] > 0){
                            sumAdj += nums[i-1][j];
                            adjCount++;
                        }
                        
                        if(i+1 <= r && nums[i+1][j] > 0){
                            sumAdj += nums[i+1][j];
                            adjCount++;
                        }
                        
                        if(j-1 >=1 && nums[i][j-1] > 0){
                            sumAdj += nums[i][j-1];
                            adjCount++;
                        }
                        
                        if(j+1 <= c && nums[i][j+1] > 0){
                            sumAdj += nums[i][j+1];
                            adjCount++;
                        }
                        
                        if(adjCount > 0){
                            long avg = sumAdj/adjCount;
                            
                            if(nums[i][j] < avg){
                                nums[i][j] = -1;
                                
                                numsCopy[i][j] = -1;
                                countRemoved++;
                            }
                        }
                    }
                }
            }
            
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    nums[i][j] = numsCopy[i][j];
                }
            }
            
            answer+= sum;
        }
        
        caseNum++;
        out.println("Case #"+caseNum+": "+answer);
    }
    
      out.close();
  }
}
