
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Locale;

public class Solution {

  // Join The Ranks
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      int R = in.readInt();
      int S = in.readInt();

      // calc sol
      int[] arr = new int[R * S];
      for (int r = 0, i = 0; r < R; r++) {
        for (int s = 0; s < S; s++, i++) {
          arr[i] = s;
        }
      }
      HashSet<Att> done = new HashSet<>();
      LinkedList<Att> todo = new LinkedList<>();
      todo.add(new Att(0, 0, arr, null));
      Att sol = null;
      while (true) {
        sol = todo.pollFirst();
        if (sol.isSorted()) {
          break;
        }
        for (int i = 1; i + 1 < R * S; i++) {
          for (int j = 1; i + j < R * S; j++) {
            todo.addLast(new Att(i, j, sol.arr, sol));
          }
        }
      }

      // print
      out.printLine(nthcase(t));
      print(out, sol);
    }
    out.close();
  }

  static void print(OutputWriter out, Att sol) {
    if (sol == null || sol.a == 0 || sol.b == 0) {
      return;
    }
    print(out, sol.prev);
    out.printLine(sol.a + " " + sol.b);
  }

  static class Att {
    final int a;
    final int b;
    final int[] arr;
    final Att prev;

    public Att(int a, int b, int[] orig, Att prev) {
      this.prev = prev;
      this.a = a;
      this.b = b;
      this.arr = new int[orig.length];
      for (int i = 0; i < b; i++) {
        this.arr[i] = orig[a + i];
      }
      for (int i = 0; i < a; i++) {
        this.arr[b + i] = orig[i];
      }
      for (int i = a + b; i < orig.length; i++) {
        this.arr[i] = orig[i];
      }
    }

    boolean isSorted() {
      for (int i = 1; i < this.arr.length; i++) {
        if (this.arr[i - 1] > this.arr[i]) {
          return false;
        }
      }
      return true;
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(this.arr);
    }

    @Override
    public boolean equals(Object obj) {
      return Arrays.equals(this.arr, ((Att) obj).arr);
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
