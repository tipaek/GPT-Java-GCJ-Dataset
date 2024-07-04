import java.util.*;
import java.io.*;
  public class Solution {
      public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          int x = in.nextInt();
          String s = "", snew = "";
          in.nextLine();
          for (int i = 1; i <= x; ++i) {
              s = in.nextLine();
              snew = makeItDeep(s);
              System.out.println("Case #" + i + ": " + snew);
          }
          in.close();
      }

      private static String makeItDeep(String s) {
          int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
          String newS = "", addS = "";
          int d = 0;
          for (int i = 0; i < arr.length; i++) {
              // System.out.println(arr[i] + " >?< " + d);
              if (arr[i] > d) {
                  addS = addParentheString(arr[i] + "", true, arr[i] - d - 1);
                  d = arr[i];
              } else if (d > arr[i]) {
                  addS = addParentheString(arr[i] + "", false, d - arr[i] - 1);
                  d = arr[i];
              } else {
                  addS = arr[i] + "";
              }
              newS += addS;
          }
          if (d != 0) {
              newS += addParentheString("", false, d);
          }

          return newS;
      }

      private static String addParentheString(String s, boolean begining, int amount) {
          String newS = s;
          for (int i = 0; i <= amount; i++) {
            if (begining) {
                newS = "(" + newS;
            } else {
                newS = ")" + newS;
            }
          }
        return newS;
      }
  }