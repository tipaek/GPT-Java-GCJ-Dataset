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

    List<Move> getMoves(int active, int value) {
      if (active == 1) {
        if (value == 0) return Collections.singletonList(new Move(0, 1));
        else return Collections.singletonList(new Move(1, 0));
      } else {
        if (value == 0) return Arrays.asList(new Move(0, 0));
        return Arrays.asList(new Move(0, 1), new Move(1, -1));
      }
    }

    String restore(int i, int active1, int active2, char[] dirX, char[] dirY, long x, long y) {
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
        if (put1 != 0) x1 += (put1 == 1 ? 1 : -1) * (1L << i);
        if (put2 != 0) y1 += (put2 == 1 ? 1 : -1) * (1L << i);
        active1 = prevActive1;
        active2 = prevActive2;
        i--;
      }
      if (x1 != x || y1 != y) return null;
      return new StringBuilder(result).reverse().toString();
    }

    String solve(int x, int y) {
      char[] dirX = (x > 0 ? "WE" : "EW").toCharArray();
      char[] dirY = (y > 0 ? "SN" : "NS").toCharArray();
      if (x < 0) x = -x;
      if (y < 0) y = -y;
      dp = new boolean[40][2][2];
      parent = new int[40][2][2][4];

      for (int i = -1; i < 35; i++) {
        if (i != -1) {
          if (dp[i][0][0]) {
            String cur = restore(i, 0, 0, dirX, dirY, x, y);
            if (cur != null) return cur;
          }
        }
        for (int curActive1 = 0; curActive1 <= 1; curActive1++) {
          List<Move> moves1 = getMoves(curActive1, (x >> (i + 1)) & 1);
          for (int curActive2 = 0; curActive2 <= 1; curActive2++) {
            List<Move> moves2 = getMoves(curActive2, (y >> (i + 1)) & 1);
            for (Move m1 : moves1) {
              for (Move m2 : moves2) {
                update(i + 1, m1.active, m2.active, curActive1, curActive2, m1.put, m2.put);
              }
            }
          }
        }
      }
      return impossible;
    }

    class Move {
      int active;
      int put;

      public Move(int active, int put) {
        this.active = active;
        this.put = put;
      }

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

