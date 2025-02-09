import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author kangtaku
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Vestigium solver = new Vestigium();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class Vestigium {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int trace = 0;
      int r = 0, c = 0, i, j;
      int N = in.readInt();
      int[][] matrix = new int[N][N];
      HashMap<Integer, Integer>[] rSet = new HashMap[N];
      HashMap<Integer, Integer>[] cSet = new HashMap[N];
      for (i = 0; i < N; ++i) {
        rSet[i] = new HashMap<>();
        cSet[i] = new HashMap<>();
      }
      for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) {
          matrix[i][j] = in.readInt();
          int t = rSet[i].getOrDefault(matrix[i][j], 0);
          rSet[i].put(matrix[i][j], t + 1);

          t = cSet[j].getOrDefault(matrix[i][j], 0);
          cSet[j].put(matrix[i][j], t + 1);

          if (i == j) trace += matrix[i][j];
        }
      }
      for (i = 0; i < N; ++i) {
        for (HashMap.Entry<Integer, Integer> entry : rSet[i].entrySet()) {
          if (entry.getValue() > 1) {
            ++r;
            break;
          }
        }
        for (HashMap.Entry<Integer, Integer> entry : cSet[i].entrySet()) {
          if (entry.getValue() > 1) {
            ++c;
            break;
          }
        }
      }
      out.println("Case #" + testNumber + ": " + trace + " " + r + " " + c);
    }

  }

  static class InputReader {
    private InputStream stream;
    private BufferedReader br = null;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
      this.br = new BufferedReader(new InputStreamReader(stream));
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

    public String next() {
      return readToken();
    }

    public String readToken() {
      int c;
      while (isSpaceChar(c = read())) ;
      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);
      while (!isSpaceChar(c = read()))
        result.appendCodePoint(c);
      return result.toString();
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

  }
}

