import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rustam Musin (t.me/musin_acm)
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    Expogo solver = new Expogo();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class Expogo {
    boolean[][][] dp;
    int[][][][] parent;
    String impossible = "IMPOSSIBLE";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int x = in.readInt();
      int y = in.readInt();
      String answer = solve(x, y);
      out.printFormat("Case #%d: %s\n", testNumber, answer);
    }

    int getMul(char c) {
      if (c == 'N' || c == 'E') return 1;
      return -1;
    }

    boolean update(int i, int active1, int active2, int prevActive1, int prevActive2, int put1, int put2) {
      if (i == 0) {
        if (prevActive1 != 0 || prevActive2 != 0) return false;
      } else {
        if (!dp[i - 1][prevActive1][prevActive2]) return false;
      }
      if (put1 == 0 && put2 == 0) return false;
      if (put1 != 0 && put2 != 0) return false;
      if (dp[i][active1][active2]) return false;
      dp[i][active1][active2] = true;
      parent[i][active1][active2][0] = prevActive1;
      parent[i][active1][active2][1] = prevActive2;
      parent[i][active1][active2][2] = put1;
      parent[i][active1][active2][3] = put2;
      return true;
    }

    List<IntIntPair> getMoves(int active, int value) {
      if (active == 1) {
        if (value == 0) return Collections.singletonList(IntIntPair.makePair(0, 1));
        else return Collections.singletonList(IntIntPair.makePair(1, 0));
      } else {
        if (value == 0) return Collections.singletonList(IntIntPair.makePair(0, 0));
        return Arrays.asList(IntIntPair.makePair(0, 1), IntIntPair.makePair(1, -1));
      }
    }

    String restore(int i, int active1, int active2, char[] dirX, char[] dirY, long x, long y, int mulX, int mulY) {
      String result = "";
      long x1 = 0;
      long y1 = 0;
      while (i >= 0) {
        int prevActive1 = parent[i][active1][active2][0];
        int prevActive2 = parent[i][active1][active2][1];
        int put1 = parent[i][active1][active2][2];
        int put2 = parent[i][active1][active2][3];
        if (put1 != 0) result += dirX[put1 == 1 ? 1 : 0];
        if (put2 != 0) result += dirY[put2 == 1 ? 1 : 0];
        if (put1 != 0) x1 += getMul(dirX[put1 == 1 ? 1 : 0]) * (1L << i);
        if (put2 != 0) y1 += getMul(dirY[put2 == 1 ? 1 : 0]) * (1L << i);
        active1 = prevActive1;
        active2 = prevActive2;
        i--;
      }
      x1 *= mulX;
      y1 *= mulY;
      if (x1 != x || y1 != y) return null;
      return new StringBuilder(result).reverse().toString();
    }

    String solve(int x, int y) {
      if (x == 0 && y == 0) return "";
      char[] dirX = (x > 0 ? "WE" : "EW").toCharArray();
      char[] dirY = (y > 0 ? "SN" : "NS").toCharArray();
      int mulX = 1, mulY = 1;
      if (x < 0) {
        x = -x;
        mulX = -1;
      }
      if (y < 0) {
        y = -y;
        mulY = -1;
      }
      dp = new boolean[40][2][2];
      parent = new int[40][2][2][4];

      for (int i = -1; i < 40; i++) {
        if (i != -1) {
          for (int active1 = 0; active1 <= 0; active1++) {
            for (int active2 = 0; active2 <= 0; active2++) {
              if (dp[i][active1][active2]) {
                String cur = restore(i, active1, active2, dirX, dirY, x, y, mulX, mulY);
                if (cur != null) {
                  return cur;
                }
              }
            }
          }
        }
        for (int curActive1 = 0; curActive1 <= 1; curActive1++) {
          List<IntIntPair> moves1 = getMoves(curActive1, (x >> (i + 1)) & 1);
          for (int curActive2 = 0; curActive2 <= 1; curActive2++) {
            List<IntIntPair> moves2 = getMoves(curActive2, (y >> (i + 1)) & 1);
            for (IntIntPair m1 : moves1) {
              for (IntIntPair m2 : moves2) {
                update(i + 1, m1.first, m2.first, curActive1, curActive2, m1.second, m2.second);
              }
            }
          }
        }
      }
      return impossible;
    }

  }

  static class IntIntPair implements Comparable<IntIntPair> {
    public final int first;
    public final int second;

    public static IntIntPair makePair(int first, int second) {
      return new IntIntPair(first, second);
    }

    public IntIntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      IntIntPair pair = (IntIntPair) o;

      return first == pair.first && second == pair.second;
    }

    public int hashCode() {
      int result = first;
      result = 31 * result + second;
      return result;
    }

    public String toString() {
      return "(" + first + "," + second + ")";
    }

    public int compareTo(IntIntPair o) {
      int value = Integer.compare(first, o.first);
      if (value != 0) {
        return value;
      }
      return Integer.compare(second, o.second);
    }

  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      StringBuilder res = new StringBuilder();
      do {
        if (Character.isValidCodePoint(c)) {
          res.appendCodePoint(c);
        }
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public boolean isSpaceChar(int c) {
      if (filter != null) {
        return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
      return readString();
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);

    }

  }

  static class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void printFormat(String format, Object... objects) {
      writer.printf(format, objects);
    }

    public void close() {
      writer.close();
    }

  }
}

