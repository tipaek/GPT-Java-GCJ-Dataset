import java.io.*;
import java.util.*;
import java.util.function.*;

public class Solution {
  private static final boolean DEBUG = false;
  private static final int MAX_RADIUS = 1_000_000_000;

  private enum Result {
    WRONG, HIT, MISS, CENTER;
  }

  public static void main(String[] args) {
    final Reader in = new Reader();

    for (int x = 1; x <= in.T; x++) {
      if (DEBUG) System.err.printf("x: %d T: %d A: %d B: %d\n", x, in.T, in.A, in.B);
      try {
        searchForCenter(in);
      } catch (final Finished f) {
        if (DEBUG) System.err.printf("Test case %d done!\n", x);
      } catch (final RuntimeException r) {
        if (DEBUG) System.err.printf("Failed case %d due to %s\n", x, r.getMessage());
        break;
      }
    }
  }

  private static void searchForCenter(final Reader in) {
    final int searchRange = (MAX_RADIUS - Math.min(in.A, in.B));
    int x = -MAX_RADIUS;
    int y = 0;
    int highX = -MAX_RADIUS;
    int lowX = -MAX_RADIUS + searchRange*2;

    while(true) {
      x = (highX + lowX) / 2;

      if (DEBUG) System.err.printf("x: %d high: %d low: %d\n", x, highX, lowX);

      final List<Integer> c = searchLeft(in, x, searchRange, Result.HIT);

      if (c.size() == 1) {
        y = c.get(0);

        if (DEBUG) System.err.printf("found y: %d\n", y);

        break;
      }

      if (c.isEmpty()) {
        highX = x+1;

        if (DEBUG) System.err.print("no y found\n");
      } else {
        lowX = x-1;

        if (DEBUG) System.err.printf("multiple found y: %s\n", c);
      }
    }

    x += Math.min(in.A, in.B); //fix

    if (DEBUG) System.err.printf("Found: %d %d\n", x, y);

    in.submit(x, y);
  }

  private static List<Integer> searchLeft(final Reader in, final int x, final int range, final Result search) {
    int qCount = 0;
    final List<Integer> res = new ArrayList<>();

    final Queue<List<Integer>> queue = new LinkedList<>();
    queue.add(Arrays.asList(range, -range));

    while (!queue.isEmpty()) {
      final List<Integer> l = queue.poll();
      final int center = (l.get(0) + l.get(1)) / 2;
      final Result r = in.submit(x, center);
      qCount++;

      if (r == search) {
        res.add(center);
      }

      if (res.size() == 2) {
        break;
      }

      if (!l.get(0).equals(center)) {
        queue.add(Arrays.asList(l.get(0), center + 1));
      }
      if (!l.get(1).equals(center)) {
        queue.add(Arrays.asList(center - 1, l.get(1)));
      }
    }

    if (DEBUG) System.err.printf("qCount: %d\n", qCount);

    return res;
  }

  private static class Reader {
    private final Scanner in;
    public final int T;
    public final int A;
    public final int B;

    public Reader() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
      A = in.nextInt();
      B = in.nextInt();
    }

    public Result submit(final int x, final int y) {
      write(x, y);

      return next(() -> String.format("%d %d", x, y));
    }

    private void write(final int x, final int y) {
      System.out.printf("%d %d\n", x , y);
      System.out.flush();
      /*if (DEBUG) {
        System.err.printf("%d %d\n", x, y);
        System.err.flush();
      }*/
    }

    private Result next(final Supplier<String> msg) {
      final Result res = Result.valueOf(in.next());

      switch (res) {
        case WRONG:
          final String msgStr = DEBUG ? msg.get() : "ops";
          throw new RuntimeException(msgStr);
        case CENTER:
          throw new Finished();
        default:
          break;
      }

      return res;
    }
  }

  private static class Finished extends RuntimeException { }
}
