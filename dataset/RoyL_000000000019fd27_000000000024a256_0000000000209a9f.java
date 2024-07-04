import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int n = in.nextInt();
      for (int x = 1; x <= n; x++) {
         nestString(in.nextLine(), x);
      }
   }
   
   public static void nestString(String s, int x) {
      String out = "";
      int open = 0;
      // for each number
      for (int i = 0; i < s.length(); i++) {
         int n = Character.getNumericValue(s.charAt(i));
         while (n < open) {
            out += ")";
            open--;
         }
         while (n > open) {
            out += "(";
            open++;
         }
         out += n;
      }
      while (open > 0) {
         out += ")";
         open--;
      }
      System.out.println("Case #" + x + ": " + out);
   }
}