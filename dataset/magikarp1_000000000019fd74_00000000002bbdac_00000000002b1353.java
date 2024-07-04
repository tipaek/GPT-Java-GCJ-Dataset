import java.util.*;
import java.io.*;
public class Solution{
   static boolean reverse = false;
   static ArrayList<Integer> path = new ArrayList<Integer>();
   public static void main(String[] main) throws Exception{
      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
      //StringTokenizer st = new StringTokenizer(b.readLine());
      int t = Integer.parseInt(b.readLine());
      for(int trial = 1; trial <= t; trial++){
         path = new ArrayList<Integer>();
         int N = Integer.parseInt(b.readLine());
         //ArrayList<Integer> path = new ArrayList<Integer>();
         if(N > 30 && N %2 == 1){
            int leftover = 30 - solve(N-30);
            int biggest = path.get(path.size()-1)/90;
            for(int i = 1; i < leftover+1; i++)
               if(!reverse)
                  path.add(90*(biggest + i) + 1);
               else
                  path.add(91*(biggest + i));
         }
         else if(N > 30){
            int leftover = 31 - solve(N-31);
            int biggest = path.get(path.size()-1)/90;
            for(int i = 1; i < leftover+1; i++)
               if(!reverse)
                  path.add(90*(biggest + i) + 1);
               else
                  path.add(91*(biggest + i));
         }
         else
            for(int i = 1; i <= N; i++)
               path.add(90*i + 1);
         System.out.println("Case #" + trial + ":");
         for(int i = 0; i < path.size(); i++)
            System.out.println(path.get(i) / 90 + " " + (path.get(i) % 90));
      }
   }
   public static int solve(int k){
      String binary = Integer.toBinaryString(k);
      //System.out.println(binary);
      int zero = 0;
      for(int i = binary.length()-1; i >= 0; i--)
         if(binary.charAt(i) == '1'){
            if(!reverse){
               for(int j = 1; j <= binary.length() - i; j++)
                  path.add(90*(binary.length()-i) + j);
            }
            else{
               for(int j = binary.length()-i; j >0; j--)
                  path.add(90*(binary.length()-i) + j);
            }
            reverse = !reverse;
         }
         else{
            zero++;
            if(!reverse)
               path.add(90*(binary.length()-i) + 1);
            else
               path.add(91*(binary.length()-i));
         }
      return zero;
   }
}