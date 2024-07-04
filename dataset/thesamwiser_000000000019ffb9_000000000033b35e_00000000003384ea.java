
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Locale;

public class Solution {

  // prob1
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      long L = in.readLong(), R = in.readLong();

      // calc sol
      long x = 0;
      if (R > L) {
        x = findX(R - L);
        R -= sum(x);
        long x2 = findX2(R, L, x);
        long half = x / 2;
        if ((x & 1) == 0) {
          R -= (pow(half + x2) - pow(half));
          L -= (pow1(half + x2) - pow1(half));
        } else {
          R -= pow1(half + x2) - pow1(half);
          L -= pow(half + x2 + 1) - pow(half + 1);
        }
        x += (x2 * 2);
      } else {
        if (L > R) {
          x = findX(L - R);
          L -= sum(x);
        }
        long x2 = findX2(L, R, x);
        long half = x / 2;
        if ((x & 1) == 0) {
          L -= (pow(half + x2) - pow(half));
          R -= (pow1(half + x2) - pow1(half));
        } else {
          L -= pow1(half + x2) - pow1(half);
          R -= pow(half + x2 + 1) - pow(half + 1);
        }
        x += (x2 * 2);
      }

      while (L > x || R > x) {
        x++;
        if (L >= R) {
          L -= x;
        } else {
          R -= x;
        }
      }

      // print
      out.printLine(nthcase(t) + " " + x + " " + L + " " + R);
    }
    out.close();
  }

  static long findX(long diff) {
    long min = 0L, max = 1000000001L;
    long sol = min;
    while (min < max) {
      long mid = (min + max) / 2;
      long res = sum(mid);
      if (res > diff) {
        max = mid - 1;
      } else {
        min = mid + 1;
        sol = mid;
      }
    }
    return sol;
  }


  static long findX2(long large, long small, long curX) {
    long min = 0, max = 1000000001L;
    long half = curX / 2;
    long sol = min;
    while (min < max) {
      long mid = (min + max) / 2;
      if ((curX & 1) == 0) {
        if ((pow(half + mid) - pow(half)) > large || (pow1(half + mid) - pow1(half)) > small) {
          max = mid - 1;
          continue;
        }
      } else {
        if ((pow1(half + mid) - pow1(half)) > large
            || (pow(half + mid + 1) - pow(half + 1)) > small) {
          max = mid - 1;
          continue;
        }
      }
      min = mid + 1;
      sol = mid;
    }
    return sol;
  }

  static long sum(long x) {
    return pow1(x) / 2;
  }

  static long pow1(long x) {
    return x * (x + 1);
  }

  static long pow(long x) {
    return x * x;
  }

  static String nthcase(int t) {
    return "Case #" + t + ":";
  }


  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[curChar++];
    }

    public char readChar() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      return (char) c;
    }

    public String readLine() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public long readLong() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
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

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0)
          writer.print(' ');
        writer.print(objects[i]);
      }
    }

    public void printLine(Object... objects) {
      print(objects);
      writer.println();
    }

    public void flush() {
      writer.flush();
    }

    public void close() {
      writer.close();
    }
  }
}
