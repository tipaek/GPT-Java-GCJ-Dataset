import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    List<List<Integer>> C = new ArrayList<>();
    List<List<Integer>> J = new ArrayList<>();
    for (int i = 1; i <= numTests; ++i) {
        int nTasks = in.nextInt();
        boolean impossible = false;
        String ret = "";
        for (int j = 0; j < nTasks; j++) {
            int start = in.nextInt();
            int end = in.nextInt();
            List<Integer> newTask = new ArrayList<>();
            newTask.add(start);
            newTask.add(end);
            if (check(start, end, C)) {
                C.add(newTask);
                ret += "C";
            } else if (check(start, end, J)) {
                J.add(newTask);
                ret += "J";
            } else {
                impossible = true;
                break;
            }
        }
        C.clear();
        J.clear();
        if (impossible) {
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        } else {
            System.out.println("Case #" + i + ": " + ret);
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