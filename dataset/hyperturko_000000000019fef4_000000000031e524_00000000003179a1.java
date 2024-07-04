import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

  public static void main(String[] args) {
    final IO io = new IO();
    for (int x = 1; x <= io.T; x++) {
      final String y = solve(io.next());
      io.write(x, y);
    }
  }

  private static String solve(final Iterable<Input> input) {
    final Map<Integer, Map<Character, Integer>> freq = new HashMap<>();
    final char[] res = new char[10];
    final Set<Character> all = new HashSet<>();
    final Set<Character> found = new HashSet<>();

    for (final Input i : input) {
      freq.putIfAbsent(i.q, new HashMap<>());
      for (final char c : i.r.toCharArray()) {
        freq.get(i.q).merge(c, 1, Integer::sum);
        all.add(c);
      }
    }

    for (int i = 1; i < 10; i++) {
      for (int j = i; j < 100; j *= 10) {
        if (freq.containsKey(j)) {
          final char c = getMax(freq.get(j), found);
          if (c != 0) {
            res[i] = c;
            found.add(c);
            break;
          }
        }
      }
    }

    all.removeAll(found);
    res[0] = all.iterator().next();

    return new String(res);
  }

  private static char getMax(final Map<Character, Integer> map, final Set<Character> found) {
    char c = 0;
    int m = 0;
    for (final Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() > m && !found.contains(e.getKey())) {
        m = e.getValue();
        c = e.getKey();
      }
    }
    return c;
  }

  private static class IO {
    private final Scanner in;
    public final int T;
    public int U;

    public IO() {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      T = in.nextInt();
    }

    private void write(final int x, final String y) {
      System.out.printf("%d %s\n", x , y);
      System.out.flush();
    }

    private Iterable<Input> next() {
      U = (int) Math.pow(10, in.nextInt());

      return () -> new Iterator<Input>() {
        int count = 0;
        @Override
        public boolean hasNext() {
          return count < 10000;
        }

        @Override
        public Input next() {
          count++;
          return new Input(in.nextInt(), in.next());
        }
      };
    }
  }

  private static class Input {
    final int q;
    final String r;

    public Input(int q, String r) {
      this.q = q;
      this.r = r;
    }
  }
}
