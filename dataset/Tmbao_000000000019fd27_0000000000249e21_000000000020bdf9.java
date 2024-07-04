import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;

/** Built using CHelper plug-in Actual solution is at the top */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    ParentingPartneringReturns solver = new ParentingPartneringReturns();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static final class ParentingPartneringReturns {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int N = in.nextInt();
      List<KidActivity> kidActivities = new ArrayList<>();
      for (int i = 0; i < N; ++i) {
        kidActivities.add(new KidActivity(in.nextInt(), in.nextInt()));
      }

      boolean possible = true;
      List<Integer> indices = new ArrayList<>();
      for (int i = 0; i < N; ++i) {
        indices.add(i);
      }
      indices.sort(Comparator.comparingInt(index -> kidActivities.get(index).start));

      StringBuilder schedule = new StringBuilder();
      schedule.setLength(N);
      for (int i = 0, cameron = 0, jamie = 0; i < N; ++i) {
        int index = indices.get(i);
        if (cameron <= kidActivities.get(index).start) {
          cameron = kidActivities.get(index).end;
          schedule.setCharAt(index, 'C');
        } else if (jamie <= kidActivities.get(index).start) {
          jamie = kidActivities.get(index).end;
          schedule.setCharAt(index, 'J');
        } else {
          possible = false;
          break;
        }
      }

      if (possible) {
        out.println(String.format("Case #%s: %s", testNumber, schedule.toString()));
      } else {
        out.println(String.format("Case #%s: IMPOSSIBLE", testNumber));
      }
    }

    private final class KidActivity {
      private final int start;
      private final int end;

      private KidActivity(int start, int end) {
        this.start = start;
        this.end = end;
      }
    }
  }
}
