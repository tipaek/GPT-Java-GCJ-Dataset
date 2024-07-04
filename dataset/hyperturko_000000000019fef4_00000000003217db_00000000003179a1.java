import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

  public static void main(String[] args) {
    final IO io = new IO();
    for (int x = 1; x <= io.T; x++) {
      final String y = solve(io);
      io.write(x, y);
    }
  }

  private static String solve(final IO io) {
    final Iterable<Input> input = io.next();
    final Map<Integer, Map<Character, Integer>> freq = new HashMap<>();
    final char[] res = new char[10];
    final Set<Character> all = new HashSet<>();
    final Set<Character> found = new HashSet<>();

    for (final Input i : input) {
      final int key = i.q.charAt(0) - '0';
      freq.putIfAbsent(key, new HashMap<>());
      for (final char c : i.r.toCharArray()) {
        freq.get(key).merge(c, 1, Integer::sum);
        all.add(c);
      }
    }

    for (int i = 1; i < 10; i++) {
      final char c = getMax(freq.get(i), found);
      if (c != 0) {
        res[i] = c;
        found.add(c);
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
      System.out.printf("Case #%d: %s\n", x , y);
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
          return new Input(in.next(), in.next());
        }
      };
    }
  }

  private static class Input {
    final String q;
    final String r;

    public Input(final String q, final String r) {
      this.q = q;
      this.r = r;
    }
  }
}
