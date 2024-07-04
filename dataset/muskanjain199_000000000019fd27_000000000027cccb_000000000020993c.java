import java.io.*;
import java.util.*;

class mjava{
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
  
  public static void main(String[] args){
      FastReader scan = new FastReader();
      int t= scan.nextInt();
      for(int jj=0;jj<t;jj++){
          int n= scan.nextInt();
          int[][] arr = new int[n][n];
          int trace=0;
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  arr[i][j]=scan.nextInt();
                  if(i==j){
                      trace=trace+arr[i][j];
                  }
              }
          }
          
          
          int count1=0;
          int count2=0;
          for(int i=0;i<n;i++){
              HashSet<Integer> set = new HashSet<Integer>();
              for(int j=0;j<n;j++){
                  set.add(arr[i][j]);
              }
              if(set.size()!=n){
                  count1++;
              }
          }
          for(int i=0;i<n;i++){
              HashSet<Integer> set = new HashSet<Integer>();
              for(int j=0;j<n;j++){
                  set.add(arr[j][i]);
              }
              if(set.size()!=n){
                  count2++;
              }
          }
          StringBuffer sb = new StringBuffer();
          int f= jj+1;
          sb.append(trace+" "+count1+" "+count2);
          System.out.println(sb);
      }
  }
}