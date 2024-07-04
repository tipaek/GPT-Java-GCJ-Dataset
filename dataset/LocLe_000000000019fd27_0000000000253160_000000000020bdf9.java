import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= numTests; i++) {
        int nTasks = in.nextInt();
        boolean impossible = false;
        List<List<Integer>> C = new ArrayList<>();
        List<List<Integer>> J = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        char[] ret = new char[nTasks];
        for (int j = 0; j < nTasks; j++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int index = j;
            all.add(new ArrayList() {
                {
                    add(start);
                    add(end);
                    add(index);
                }
            });
        }
        Collections.sort(all, Comparator.comparing(task -> task.get(0)));
        for (int j =0 ; j < all.size(); j++) {
            if (check(all.get(j).get(0), all.get(j).get(1), C)) {
                C.add(all.get(j));
                ret[all.get(j).get(2)] = 'C';
            } else if (check(all.get(j).get(0), all.get(j).get(1), J)) {
                J.add(all.get(j));
                ret[all.get(j).get(2)] = 'J';
            } else {
                impossible = true;
                break;
            }
        }
        if (impossible) {
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        } else {
            System.out.println("Case #" + i + ": " + String.valueOf(ret));
        }
    }
  }
  
  private static boolean check(int start, int end, List<List<Integer>> lst) {
      for (List<Integer> pair: lst) {
          if (!(start >= pair.get(1) || end <= pair.get(0))) {
              return false;
          }
      }
      return true;
  }
}