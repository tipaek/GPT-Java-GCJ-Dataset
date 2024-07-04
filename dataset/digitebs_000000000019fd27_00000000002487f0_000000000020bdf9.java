import java.util.*;
import java.io.*;
public class Solution {
      static String schedule(List<int[]> lists) {
    int[] j = null; // empty;
    int[] c = null; // empty
    StringBuilder sb = new StringBuilder();
    for (int[] i : lists) {
      if (j == null || j[1] <= i[0] || i[1] <= j[0]) {
        j = i;
        sb.append("J"); // okay
      }
      else if (c == null || c[1] <= i[0] || i[1] <= c[0]) {
        c = i;
        sb.append("C"); // okay
      }
      else return "IMPOSSIBLE";
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int k = in.nextInt();
      List<int[]> lists = new ArrayList<>();
      while(k-- > 0){
        int[] arr = new int[2];
        arr[0] = in.nextInt();
        arr[1] = in.nextInt();
        lists.add(arr);
      }
      String r = schedule(lists);
      System.out.println("Case #" + i + ": "+ r);
    }
  }
}