import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      sc.nextLine();
      for(int i = 1; i <= t; i++) {
         String seq = sc.nextLine();
         seq += "0";
         int startpar = seq.charAt(0) - '0';
         StringBuilder ans = new StringBuilder();
         for(int j = 0; j < startpar; j++) {
            ans.append("(");
         }
         for(int j = 0; j < seq.length() - 1; j++) {
            ans.append(seq.charAt(j) + "");
         
            int diff = seq.charAt(j + 1) - seq.charAt(j);
            if(diff > 0) {
               for(int k = 0; k < diff; k++) {
                  ans.append("(");
               }
            }
            if(diff < 0) {
               for(int k = 0; k < -diff; k++) {
                  ans.append(")");
               }
            }
         }
         System.out.println("Case #" + i + ": " + ans.toString());
      }
   }
}