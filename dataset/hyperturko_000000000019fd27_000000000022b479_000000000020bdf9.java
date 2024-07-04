import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

  public static void main(final String[] args) {
    final Reader in = new Reader();

    for (int x = 1; in.hasNext(); x++) {
      final List<List<Integer>> t = in.next();
      
      final String y = beParent(t);

      System.out.println("Case #" + x + ": " + y);
    }
  }

  private static String beParent(final List<List<Integer>> times) {
    times.sort(Comparator.comparingInt(o -> o.get(1)));
    final char[] responsible = new char[times.size()];

    int lastFinished = 0;
    for (final List<Integer> time : times) {
      final int idx = time.get(0);
      final int start = time.get(1);
      final int end = time.get(2);

      if (start >= lastFinished) {
        responsible[idx] = 'J';
        lastFinished = end;
      }
    }

    lastFinished = 0;
    for (final List<Integer> time : times) {
      final int idx = time.get(0);
      final int start = time.get(1);
      final int end = time.get(2);

      if (responsible[idx] != 'J') {
        if (start >= lastFinished) {
          responsible[idx] = 'C';
          lastFinished = end;
        } else {
          return "IMPOSSIBLE";
        }
      }
    }

    return new String(responsible);
  }

  private static class Reader implements Iterator<List<List<Integer>>> {
    private final Scanner in;
    private final int T;

    public Reader() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
    }

    @Override
    public boolean hasNext() {
      return in.hasNext();
    }

    @Override
    public List<List<Integer>> next() {
      final int n = in.nextInt();

      return IntStream
          .range(0, n)
          .mapToObj(i -> Arrays.asList(i, in.nextInt(), in.nextInt()))
          .collect(Collectors.toList());
    }
  }

}