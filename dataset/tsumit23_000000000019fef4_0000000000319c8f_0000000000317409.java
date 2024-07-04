import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
            OverexcitedFan solver = new OverexcitedFan();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                  solver.solve(i, in, out);
            out.close();
      }

      static class OverexcitedFan {
            public void solve(int testNumber, InputReader in, OutputWriter out) {
                  int x = in.nextInt();
                  int y = in.nextInt();
                  int xx = -y;
                  int yy = x;
                  String str = in.next();
                  int dist = Math.abs(xx) + Math.abs(yy);
                  int time = 0;

                  if (dist > time)
                        for (int i = 0; i < str.length(); i++) {
                              if (str.charAt(i) == 'N') {
                                    xx--;
                              } else if (str.charAt(i) == 'W') {
                                    yy--;
                              } else if (str.charAt(i) == 'E') {
                                    yy++;
                              } else {
                                    xx++;
                              }

                              time++;
                              dist = Math.abs(xx) + Math.abs(yy);
                              if (dist <= time) {
                                    break;
                              }

                        }

                  if (dist <= time)
                        out.printLine("Case #" + testNumber + ": " + time);
                  else
                        out.printLine("Case #" + testNumber + ": IMPOSSIBLE");

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

            public void printLine(Object... objects) {
                  print(objects);
                  writer.println();
            }

            public void close() {
                  writer.close();
            }

      }
}

