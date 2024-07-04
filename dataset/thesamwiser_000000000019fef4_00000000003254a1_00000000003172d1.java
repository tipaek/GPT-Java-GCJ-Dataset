
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Solution {

  // pancakes
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      int N = in.readInt();
      int D = in.readInt();

      long[] ns = new long[N];
      long sum = 0;
      for (int i = 0; i < N; i++) {
        ns[i] = in.readLong();
        sum += ns[i];
      }
      // calc sol
      HashMap<Fraction, List<Integer>> cand = new HashMap<Fraction, List<Integer>>();
      for (int d = 1; d <= D; d++) {
        for (int i = 0; i < ns.length; i++) {
          if (1L * ns[i] * D > sum * d || !isPossibru(d, D, i, ns)) {
            continue; // impossibru
          }
          Fraction fr = new Fraction(ns[i], d);
          List<Integer> arr = cand.get(fr);
          if (arr == null) {
            arr = new LinkedList<Integer>();
            cand.put(fr, arr);
          }
          arr.add(d);
        }
      }

      // find best
      int best = D - 1;
      int[] opt = new int[D + 1];
      for (List<Integer> pos : cand.values()) {
        if (best == 0) {
          break;
        }
        Arrays.fill(opt, D + 1);
        opt[0] = 0;
        // for (int i = 0; i < opt.length; i++) {
        // opt[i] = i;
        // }
        int max = 0;
        for (int x : pos) {
          for (int ix = D; ix >= x; ix--) {
            opt[ix] = Math.min(opt[ix], opt[ix - x] + x - 1); // assuming there are infinite others
            if (opt[ix] < D) {
              max = Math.max(max, ix);
            }
          }
        }
        best = Math.min(best, opt[max] + D - max);
      }

      // print
      out.printLine(nthcase(t) + " " + best);
    }
    out.close();
  }

  static String nthcase(int t) {
    return "Case #" + t + ":";
  }


  static boolean isPossibru(int div, int diners, int ix, long[] slices) {
    for (int i = 0; i < slices.length; i++) {
      diners -= (slices[i] * div) / slices[ix];
      if (diners <= 0) {
        return true;
      }
    }
    return false;
  }

  static long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static class Fraction implements Comparable<Fraction> {
    final long a, b;

    public Fraction(long a, long b) {
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
