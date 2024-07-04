//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         StringTokenizer st = new StringTokenizer(f.readLine());
      
         long a = Integer.parseInt(st.nextToken());
         long b = Integer.parseInt(st.nextToken());
      
         
         long l = 0L;
         long r = 1000000000L;
         long ans = 0L;
         long ansa = a;
         long ansb = b;
         
         while(l <= r){
            long mid = l + (r-l)/2;
            
            boolean fail = false;
            long cura = a;
            long curb = b;
            for(long k = 1L; k <= mid; k++){
               if(cura < k && curb < k){
                  fail = true;
                  break;
               }
               if(cura >= curb){
                  cura-=k;
               
               } else {
                  curb-=k;
               }
            }
            
            
            
            if(!fail){
               ans = mid;
               ansa = cura;
               ansb = curb;
               l = mid+1;
            } else {
               r = mid-1;
            }
         }
            
         
         out.println("Case #" + q + ": " + ans + " " + ansa + " " + ansb);
         
         
      }
      
      
      
      
      out.close();
   }
   
   
      
}