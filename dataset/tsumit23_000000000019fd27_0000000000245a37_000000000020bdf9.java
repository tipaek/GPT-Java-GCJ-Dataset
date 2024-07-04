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
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sumit
 */
public class Solution {
      public static void main(String[] args) {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            OutputWriter out = new OutputWriter(outputStream);
            CodeJamQL3 solver = new CodeJamQL3();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                  solver.solve(i, in, out);
            out.close();
      }

      static class CodeJamQL3 {
            public void solve(int testNumber, InputReader in, OutputWriter out) {
                  int n = in.nextInt();
                  Pair[] arr = new Pair[n];
                  for (int i = 0; i < n; i++) {
                        arr[i] = new Pair(in.nextInt(), in.nextInt(), i);
                  }
                  Arrays.sort(arr);

                  int jj = 0;
                  int cc = 1;
                  char[] ans = new char[n];
                  ans[arr[jj].index] = 'J';
                  ans[arr[cc].index] = 'C';
                  for (int i = 2; i < n; i++) {
                        int Jend = arr[jj].end;
                        int Cend = arr[cc].end;

                        if (arr[i].start >= Jend) {
                              jj = i;
                              ans[arr[jj].index] = 'J';
                        } else if (arr[i].start >= Cend) {
                              cc = i;
                              ans[arr[cc].index] = 'C';
                        } else {
                              out.printLine("Case #" + testNumber + ": IMPOSSIBLE");
                              return;
                        }
                  }

                  out.print("Case #" + testNumber + ": ");
                  for (int i = 0; i < n; i++) {
                        out.print(ans[i]);
                  }
                  out.printLine();


            }

            class Pair implements Comparable<Pair> {
                  int start;
                  int end;
                  int index;

                  Pair(int start, int end, int index) {
                        this.start = start;
                        this.end = end;
                        this.index = index;
                  }

                  public int compareTo(Pair p) {
                        if (p.start == this.start) {
                              return Integer.compare(this.end, p.end);
                        }
                        return Integer.compare(this.start, p.start);
                  }

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

            public int nextInt() {
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
                        res += c & 15;

                        c = read();
                  } while (!isSpaceChar(c));

                  return res * sgn;
            }

            public String next() {
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

            public boolean isSpaceChar(int c) {
                  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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
                        if (i != 0) {
                              writer.print(' ');
                        }
                        writer.print(objects[i]);
                  }
            }

            public void printLine() {
                  writer.println();
            }

            public void printLine(Object... objects) {
                  print(objects);
                  writer.println();
            }

            public void print(char i) {
                  writer.print(i);
            }

            public void close() {
                  writer.close();
            }

      }
}

