import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    NestingDepth solver = new NestingDepth();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class NestingDepth {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      String ans = "";
      String str = in.readToken();
      char[] cs = str.toCharArray();
      int depth = 0;
      for (char c : cs) {
        int num = c - '0';
        if (num > depth) {
          for (int t = depth; t < num; ++t) {
            ans += "(";
          }
        }
        if (num < depth) {
          for (int t = depth; t > num; --t) {
            ans += ")";
          }
        }
        ans += c;
        depth = num;
      }
      if (depth != 0) {
        for (int t = depth; t > 0; --t) {
          ans += ")";
        }
      }
    /*
    312
     */
      out.println(String.format("Case #%d: %s", testNumber, ans));
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

