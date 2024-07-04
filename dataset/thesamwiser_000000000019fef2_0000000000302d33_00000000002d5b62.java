
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


  static boolean[] sign = new boolean[50];
  static boolean[] dim = new boolean[50];

  // prob 1
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      long X = in.readInt();
      long Y = in.readInt();
      boolean xrev = false;
      boolean yrev = false;
      if (X < 0) {
        X = -X;
        xrev = true;
      }
      if (Y < 0) {
        Y = -Y;
        yrev = true;
      }
      long total = X + Y;
      int bits = msb(total);
      for (int b = bits - 1; b >= 0; b--) {
        if (total > 0) {
          total -= 1L << b;
          sign[b] = true;
        } else {
          total += 1L << b;
          sign[b] = false;
        }
      }
      // print
      out.print(nthcase(t) + " ");
      if (total != 0 || !assign(X, Y, bits - 1)) {
        out.printLine("IMPOSSIBLE");
        continue;
      }
      for (int b = 0; b < bits; b++) {
        if (dim[b]) {
          if (sign[b] == yrev) {
            out.print('S');
          } else {
            out.print('N');
          }
        } else {
          if (sign[b] == xrev) {
            out.print('W');
          } else {
            out.print('E');
          }
        }
      }
      out.printLine();
    }
    out.close();
  }

  static boolean assign(long X, long Y, int bit) {
    if (bit < 0) {
      return X == 0 && Y == 0;
    }
    long num = (sign[bit] ? 1 : -1) * (1L << bit);
    if ((X > Y) == num > 0) {
      if (assign(X - num, Y, bit - 1)) {
        dim[bit] = false;
        return true;
      }
      if (assign(X, Y - num, bit - 1)) {
        dim[bit] = true;
        return true;
      }
    } else {
      if (assign(X, Y - num, bit - 1)) {
        dim[bit] = true;
        return true;
      }
      if (assign(X - num, Y, bit - 1)) {
        dim[bit] = false;
        return true;
      }
    }
    return false;
  }

  static int msb(long x) {
    int res = 0;
    while (x > 0) {
      res++;
      x >>= 1;
    }
    return res;
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