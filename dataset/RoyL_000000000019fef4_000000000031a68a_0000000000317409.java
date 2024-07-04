import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int n = in.nextInt();
      for (int x = 1; x <= n; x++) {
         int length = path(in);
         System.out.println("Case #" + x + ": ");
         if (length == -1) {
            System.out.println("IMPOSSIBLE");
         } else {
            System.out.println(length);
         }
      }
   }
   
   public static int path(Scanner in) {
      int xpos = in.nextInt();
      int ypos = in.nextInt();
      String path = in.next();
      for (int i = 0; i < path.length(); i++) {
         if (Math.abs(xpos) + Math.abs(ypos) <= i) {
            return i;
         }
         char dir = path.charAt(i);
         if (dir == 'S') {
            ypos--;
         } else if (dir == 'N') {
            ypos++;
         } else if (dir == 'E') {
            xpos--;
         } else if (dir == 'W') {
            xpos++;
         }
      }
      if (Math.abs(xpos) + Math.abs(ypos) <= path.length()) {
         return path.length();
      } else {
         return -1;
      }
   }
   
   
}