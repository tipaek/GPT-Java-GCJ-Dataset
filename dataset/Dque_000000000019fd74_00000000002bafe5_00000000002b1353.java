//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
         out.println("Case #" + q + ":");
         StringJoiner sj = new StringJoiner("\n");
         int n = Integer.parseInt(f.readLine());
         
         if(n == 1){
            out.println("1 1");
            continue;
         }
         if(n == 2){
            out.println("1 1");
            out.println("2 1");
            continue;
         }
         
         //find biggest number such that x+2^x <= n
         int x = 0;
         int x2 = 1;
         
         while(x+1+x2*2 <= n){
            x++;
            x2*=2;
         }
         
         
         for(int k = 0; k <= x; k++){
            sj.add("" + (k+1) + " 1");
         }
         
         //go across except 1
         for(int k = 2; k <= x; k++){
            sj.add("" + (x+1) + " " + k);
         }
         
         int cur = x+x2-1;
         
         while(cur + x+1 <= n){
            sj.add("" + (x+2) + " " + (x+1));
            cur += x+1;
            x++;
         }
         
         while(cur < n){
            sj.add("" + (x+1) + " " + (x+1));
            cur++;
            x++;
         }
         
         out.println(sj.toString());
            

      }
      
      
      
      
      out.close();
   }
   
      
}