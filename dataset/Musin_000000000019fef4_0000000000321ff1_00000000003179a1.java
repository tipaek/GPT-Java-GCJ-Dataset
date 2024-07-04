import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
    Overrandomized solver = new Overrandomized();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class Overrandomized {
    Query[] queries;
    char[] intToChar;
    int[] charToInt;
    boolean[] usedInt;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int U = in.readInt();
      int n = (int) 1e4;
      queries = new Query[n];
      for (int i = 0; i < n; i++) {
        String number = in.next();
        String answer = in.next();
        queries[i] = new Query(number, answer);
      }
      Arrays.sort(queries, Comparator.comparingLong(q -> q.queryNumber));
      intToChar = new char[10];
      charToInt = new int[1 << 8];
      usedInt = new boolean[10];
      Arrays.fill(charToInt, -1);
      boolean ok = dfs1(0);
      out.printFormat("Case #%d: ", testNumber);
      out.printLine(intToChar);
    }

    boolean dfs1(int qAt) {
      if (qAt == queries.length) return true;
      if (!allKnown(qAt)) return dfs2(qAt, 0);
      return checkQuery(qAt) && dfs1(qAt + 1);
    }

    boolean allKnown(int qAt) {
      for (char c : queries[qAt].queryAnswerArr) if (charToInt[c] == -1) return false;
      return true;
    }

    boolean checkQuery(int qAt) {
      Query q = queries[qAt];
      long x = q.parseAnswer();
      return 1 <= x && x <= q.queryNumber;
    }

    boolean dfs2(int qAt, int at) {
      Query q = queries[qAt];
      char[] queryAnswer = q.queryAnswerArr;
      while (at < queryAnswer.length && charToInt[queryAnswer[at]] != -1) at++;
      if (at == queryAnswer.length) return checkQuery(qAt) && dfs1(qAt + 1);
      char c = queryAnswer[at];
      for (int d = 0; d < 10; d++) {
        if (usedInt[d]) continue;
        usedInt[d] = true;
        charToInt[c] = d;
        intToChar[d] = c;
        if (dfs2(qAt, at + 1)) return true;
        usedInt[d] = false;
        charToInt[c] = -1;
      }
      return false;
    }

    class Query {
      String queryNumberStr;
      long queryNumber;
      String queryAnswer;
      char[] queryAnswerArr;

      public Query(String queryNumberStr, String queryAnswer) {
        this.queryNumberStr = queryNumberStr;
        this.queryAnswer = queryAnswer;
        queryNumber = Long.parseLong(queryNumberStr);
        queryAnswerArr = queryAnswer.toCharArray();
      }

      long parseAnswer() {
        if (charToInt[queryAnswerArr[0]] == 0) return -1;
        long x = 0;
        for (char c : queryAnswerArr) {
          x = x * 10 + charToInt[c];
        }
        return x;
      }

      public String toString() {
        return "Query{" +
            "queryNumberStr='" + queryNumberStr + '\'' +
            ", queryNumber=" + queryNumber +
            ", queryAnswer='" + queryAnswer + '\'' +
            '}';
      }

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

    public void printLine(char[] array) {
      writer.println(array);
    }

    public void printFormat(String format, Object... objects) {
      writer.printf(format, objects);
    }

    public void close() {
      writer.close();
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
}

