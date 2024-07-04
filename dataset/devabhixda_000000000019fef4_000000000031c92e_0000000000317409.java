import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      int x = n;
      int y = m;
      String str = in.next();
      int len = str.length();
      int[][] arr = new int[len][2];
      int a = 0;
      for (char ch : str.toCharArray()) {
        switch (ch) {
          case 'N':
            arr[a][0] = n;
            arr[a][1] = ++m;
            break;
          case 'S':
            arr[a][0] = n;
            arr[a][1] = --m;
            break;
          case 'E':
            arr[a][0] = ++n;
            arr[a][1] = m;
            break;
          case 'W':
            arr[a][0] = --n;
            arr[a][1] = m;
            break;
        }
        a++;
      }
      int time = 1;
      boolean pos = false;
      for (int temp[] : arr) {
        if (Math.abs(temp[0]) + Math.abs(temp[1]) <= time) {
          pos = true;
          break;
        }
        time++;
      }
      if (pos)
        System.out.println("Case #" + i + ": " + time);
      else
        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
    }
  }
}