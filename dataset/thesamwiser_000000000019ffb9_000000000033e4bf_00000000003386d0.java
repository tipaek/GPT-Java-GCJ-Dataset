
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Solution {

  // golf
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      int N = in.readInt();
      int[] xs = new int[N];
      int[] ys = new int[N];
      for (int i = 0; i < N; i++) {
        xs[i] = in.readInt();
        ys[i] = in.readInt();
      }

      // calc sol
      HashMap<Fraction, HashSet<Integer>> map = new HashMap<>();
      int res = 0;
      for (int a = 0; a < N; a++) {
        for (int b = a + 1; b < N; b++) {
          Fraction rico = new Fraction(ys[a] - ys[b], xs[a] - xs[b]);
          HashSet<Integer> set = map.get(rico);
          if (set == null) {
            set = new HashSet<>();
            map.put(rico, set);
          }
          set.add(a);
          set.add(b);
          res = Math.max(res, set.size());
        }
      }
      if (res + 1 < N) {
        HashMap<Fraction, Integer> counts = new HashMap<>();
        for (Map.Entry<Fraction, HashSet<Integer>> e : map.entrySet()) {
          Fraction f = e.getKey();
          HashSet<Integer> set = e.getValue();
          if (set.size() < res) {
            continue;
          }
          for (int p : set) {
            // y = ax + b
            // b = y - ax
            Fraction f2 = new Fraction(f.b * ys[p] - f.a * xs[p], f.b);
            int cur = counts.getOrDefault(f2, 0) + 1;
            counts.put(f2, cur);
          }
          int sign = 0;
          for (int v : counts.values()) {
            sign ^= (v & 1);
          }
          if (sign == 0) {
            res++;
            break;
          }
        }
        res++;
      } else {
        res = Math.min(N, res + 1);
      }
      // print
      out.printLine(nthcase(t) + " " + res);
    }
    out.close();
  }


  static long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static class Fraction implements Comparable<Fraction> {
    final long a, b;

    public Fraction(long a, long b) {
      if (b == 0) {
        this.a = 1;
        this.b = 0;
        return;
      }
      if (a == 0) {
        this.a = 0;
        this.b = 1;
        return;
      }
      long gcd = gcd(a, b);
      this.a = a / gcd;
      this.b = b / gcd;
    }

    @Override
    public boolean equals(Object obj) {
      return this.compareTo((Fraction) obj) == 0;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.a, this.b);
    }

    @Override
    public int compareTo(Fraction o) {
      if (this.a == o.a && this.b == o.b) {
        return 0;
      }
      return (this.a * o.b) < (this.b * o.a) ? -1 : 1;
    }

    @Override
    public String toString() {
      return a + " / " + b;
    }
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
