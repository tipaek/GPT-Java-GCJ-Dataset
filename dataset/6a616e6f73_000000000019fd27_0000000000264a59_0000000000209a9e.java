
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public static void main(String[] args) {
    Proxy proxy = new DummyProxy();
//    proxy = new InMemoryProxy(1000, 100);
    proxy = new InteractiveProxy();
    int T = proxy.nextInt();
    int B = proxy.nextInt();
    for (int t = 0; t < T; t++) {
      proxy.reset();
      solve(proxy, B);
    }
  }

  private interface Proxy {
    boolean get(int index);

    void sendAnswer(String answer);

    int nextInt();

    void reset();
  }

  private abstract static class BaseProxy implements Proxy {
    @Override
    public boolean get(int index) {
      return expect(Integer.toString(index + 1), "^[01]$").equals("1");
    }

    @Override
    public void sendAnswer(String answer) {
      expect(answer, "^Y$");
    }

    private String expect(String message, String responsePattern) {
      sendText(message);
      String response = readResponse();
      if (!response.matches(responsePattern)) {
        System.err.println(String.format("Expected response to match pattern %s; got %s", responsePattern, response));
        System.exit(1);
      }
      return response;
    }

    abstract String readResponse();

    abstract void sendText(String text);
  }

  private static class InMemoryProxy extends BaseProxy {
    private final int B;
    private final Scanner scanner;
    private final BitSet bits;

    private static final Random RANDOM = new Random();
    private int seed;
    private Random random;

    private String query;
    private int count = 0;

    InMemoryProxy(int t, int B) {
      this.B = B;
      this.scanner = new Scanner(String.format("%s %s", t, B));
      this.bits = new BitSet(B);
      reset();
    }

    @Override
    public int nextInt() {
      return scanner.nextInt();
    }

    @Override
    public void reset() {
      count = 0;
      seed = RANDOM.nextInt();
      seed = -565794904;
      random = new Random(seed);
      System.out.println("Using random seed: " + seed);
      IntStream.range(0, B).forEach(i -> bits.set(i, random.nextBoolean()));
    }

    @Override
    String readResponse() {
      if (query.length() == B) {
        System.out.println(String.format("%s | %s", bitstring(bits, B), count));
        System.out.println(query);
        for (int i = 0; i < B; i++) {
          boolean bit = query.charAt(i) == '1';
          if (bit == bits.get(i)) {
            System.out.print(' ');
          } else {
            System.out.print('^');
          }
        }
        System.out.println();
        for (int i = 0; i < B; i++) {
          boolean bit = query.charAt(i) == '1';
          System.out.print(' ');
          if (bit != bits.get(i)) {
            System.out.print(i + 1);
          }
        }
        System.out.println();
        return bitstring(bits, B).equals(query) ? "Y" : "N";
      }
      count++;
      if (count % 10 == 1) {
        if (random.nextBoolean()) {
          bits.flip(0, B);
        }
        if (random.nextBoolean()) {
          for (int i = 0; i < B / 2; i++) {
            boolean other = bits.get(B - i - 1);
            bits.set(B - i - 1, bits.get(i));
            bits.set(i, other);
          }
        }
      }
      String response = bits.get(Integer.parseInt(query) - 1) ? "1" : "0";
      System.out.println(String.format("%s | %s: %s -> %s", bitstring(bits, B), count, query, response));
      return response;
    }

    @Override
    void sendText(String text) {
      this.query = text;
    }
  }

  private static class InteractiveProxy extends BaseProxy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int nextInt() {
      return scanner.nextInt();
    }

    @Override
    public void reset() {
      // nothing to do
    }

    @Override
    String readResponse() {
      return scanner.next();
    }

    @Override
    void sendText(String text) {
      System.out.println(text);
    }
  }

  private static class DummyProxy extends BaseProxy {
    private final Scanner scanner = new Scanner("1 10\n0 1 0 1 1 0 1 1 1 0\nY");

    @Override
    public int nextInt() {
      return scanner.nextInt();
    }

    @Override
    public void reset() {
      // nothing to do
    }

    @Override
    String readResponse() {
      return scanner.next();
    }

    @Override
    void sendText(String text) {
      System.out.println(text);
    }
  }

  private static void solve(Proxy proxy, int B) {
    BitSet bits = new BitSet(B);

    Integer complementBit = null;
    Integer reverseBit = null;
    Set<Integer> unknown = IntStream.range(0, B).boxed().collect(Collectors.toSet());
    int next = 0;

    for (int count = 0; count < 150; count++) {
      if ((count + 1) % 10 == 0) {
        // do a dummy get, to keep counts even
        proxy.get(0);
        continue;
      }

      if (count % 10 == 0) {
        if (complementBit != null) {
          count++;
          if (proxy.get(complementBit) != bits.get(complementBit)) {
            bits.flip(0, B);
          }
        }
        if (reverseBit != null) {
          count++;
          if (proxy.get(reverseBit) != bits.get(reverseBit)) {
            if (complementBit == null) {
              bits.flip(0, B);
            } else {
              for (int i = 0; i < B / 2; i++) {
                boolean other = bits.get(B - i - 1);
                bits.set(B - i - 1, bits.get(i));
                bits.set(i, other);
              }
              unknown = unknown.stream().mapToInt(i -> B - i - 1).boxed().collect(Collectors.toSet());
            }
          }
        }
      }

      boolean bit = proxy.get(next);
      unknown.remove(next);
      bits.set(next, bit);

      if (complementBit == null || reverseBit == null) {
        int inverse = B - 1 - next;
        boolean bit2 = proxy.get(inverse);
        unknown.remove(inverse);
        bits.set(inverse, bit2);
        count++;

        if (bit == bit2) {
          if (complementBit == null) complementBit = next;
        } else {
          if (reverseBit == null) reverseBit = next;
        }
      }

      if (unknown.isEmpty()) break;
      next = unknown.iterator().next();
    }

    proxy.sendAnswer(bitstring(bits, B));
  }

  private static String bitstring(BitSet bits, int B) {
    return IntStream.range(0, B).mapToObj(i -> bits.get(i) ? "1" : "0").collect(Collectors.joining());
  }
}
