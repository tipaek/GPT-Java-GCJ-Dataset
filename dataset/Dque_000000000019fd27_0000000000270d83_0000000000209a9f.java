//make sure to make new file!
import java.io.*;
import java.util.*;
//Nesting Depth
public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
         
         String s = f.readLine();
         int n = s.length();
         int[] array = new int[n];
         for(int k = 0; k < n; k++){
            array[k] = Character.getNumericValue(s.charAt(k));
         }
         
         int[] open = new int[n+1];
         int[] closed = new int[n+1];
         
         open[0] = array[0];
         int i = array[0];
         
         for(int k = 1; k < n; k++){
            if(array[k] == i) continue;
            if(array[k] > i){
               open[k] = array[k]-i;
               i = array[k];
            } else {
               closed[k] = i-array[k];
               i=array[k];
            }
         }
         
         closed[n] = i;
         
         StringJoiner sj = new StringJoiner("");
         sj.add("Case #" + q + ": ");
         for(int k = 0; k < n; k++){
            for(int j = 0; j < open[k]; j++){
               sj.add("(");
            }
            for(int j = 0; j < closed[k]; j++){
               sj.add(")");
            }
            sj.add("" + array[k]);
         }
         
         for(int k = 0; k < closed[n]; k++){
            sj.add(")");
         }
         
         out.println(sj.toString());
         

      }
      
      
      
      
      out.close();
   }
   
      
}