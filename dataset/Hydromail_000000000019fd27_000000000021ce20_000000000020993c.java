import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      int k = 0;
      int r = 0;
      int c = 0;
      Map<Integer, Set<Integer>> columns = new HashMap<Integer, Set<Integer>>();
      for (int x = 0; x < n; x++) {
        Set<Integer> currentRow = new HashSet<Integer>();
        for (int y = 0; y < n; y++) {
            int m = in.nextInt();
            if (x == y) {
                k += m;
            }
            if (columns.get(y) == null) {
                columns.put(y, new HashSet<Integer>());
            }
            if (!columns.get(y).add(m) && columns.get(y).size() == x) {
                c += 1;
            } 
            if (!currentRow.add(m) && currentRow.size() == y) {
                r += 1;
            }
          }
      }
      System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }
}