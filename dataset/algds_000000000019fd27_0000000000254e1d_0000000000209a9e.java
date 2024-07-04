    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          boolean result = findBytes(in, b);
          if (!result) {
              System.out.println("Wrong answer!");
              break;
          }
        }
      }
      private static boolean findBytes(Scanner in, int b) {
          int pos = 1;
          int[] bits = new int[b];
          for (int i = 1; pos <= b; i++) {
              System.out.println(pos);
              int temp = in.nextInt();
              if (i % 10 != 1) {
                  bits[pos++ - 1] = temp;
              }
          }
          for (int i = 0; i < b; i++) {
              System.out.print(bits[i]);
          }
          System.out.println();
          String result = in.nextLine();
          if (result.equals("Y")) {
              return true;
          } else {
              return false;
          }
      }
    }
  