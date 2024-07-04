
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    for (int k = 1; k <= t; ++k) {
      int n = scanner.nextInt();
      List<int[]> pairs = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        int[] st = new int[3];
        st[0] = scanner.nextInt();
        st[1] = scanner.nextInt();
        st[2] = i;
        pairs.add(st);
      }
      out.println("Case #" + k + ": " + new Q3(pairs).solve());
    }
  }

  private static final Comparator<int[]> cmp =
      Comparator.comparing((int[] t) -> t[0]).thenComparing((int[] t) -> t[1]);

  public static class Q3 {
    private final List<int[]> tasks;

    public Q3(List<int[]> tasks) {
      this.tasks = tasks;
      Collections.sort(tasks, cmp);
    }

    public String solve() {
      final Map<String, Integer> endTimes = new HashMap<>();
      final List<String> seq = new ArrayList<>();
      for (int[] t : tasks) {
        int s = t[0];
        int e = t[1];

        // update timer
        if (!endTimes.isEmpty()) {
          for (String w : Arrays.asList("C", "J")) {
            Integer endTime = endTimes.get(w);
            if (endTime != null && endTime <= s) {
              endTimes.remove(w);
            }
          }
        }

        Integer c = endTimes.get("C");
        Integer j = endTimes.get("J");
        if (c == null) {
          endTimes.put("C", e);
          seq.add("C");
        } else if (j == null) {
          endTimes.put("J", e);
          seq.add("J");
        } else {
          return "IMPOSSIBLE";
        }
      }

      char[] ch = new char[tasks.size()];
      for (int i = 0; i < tasks.size(); i++) {
        ch[tasks.get(i)[2]] = "C".equals(seq.get(i)) ? 'C' : 'J';
      }
      return new String(ch);
    }
  }
}
