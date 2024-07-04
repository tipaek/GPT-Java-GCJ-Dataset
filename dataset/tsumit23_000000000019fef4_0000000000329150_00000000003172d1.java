import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
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
            OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                  solver.solve(i, in, out);
            out.close();
      }

      static class OversizedPancakeChoppers {
            public void solve(int testNumber, InputReader in, OutputWriter out) {
                  int n = in.nextInt();
                  int d = in.nextInt();
                  long[] arr = in.nextLongArray(n);
                  TreeMap<Long, Integer> map = new TreeMap();
                  int max = 0;
                  long num = 0;
                  for (int i = 0; i < n; i++) {
                        map.putIfAbsent(arr[i], 0);
                        map.put(arr[i], map.get(arr[i]) + 1);
                        if (max < map.get(arr[i])) {
                              max = map.get(arr[i]);
                              num = arr[i];
                        } else if (max == map.get(arr[i])) {
                              num = Math.min(num, arr[i]);
                        }
                  }
                  int cuts = 0;
                  if (max < d) {
                        if (map.containsKey(2 * num)) {
                              int req = d - max;
                              int br = req / 2;
                              if (req % 2 == 1) {
                                    br++;
                              }
                              int count = map.get((long) 2 * num);
                              cuts = Math.min(br, count);
                              max = max + cuts * 2;
                        }
                  }

//        out.printLine("max "+d+" "+max);
                  while (2 * max <= d) {
                        cuts = cuts + max;
                        max = 2 * max;

                  }
//        out.printLine(" sfsdf "+d+" "+max);
                  if (d > max)
                        cuts = cuts + (d - max);

                  out.printLine("Case #" + testNumber + ": " + cuts);


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

            public long nextLong() {
                  int c = read();

                  while (isSpaceChar(c))
                        c = read();

                  int sign = 1;

                  if (c == '-') {
                        sign = -1;

                        c = read();
                  }

                  long result = 0;

                  do {
                        if (c < '0' || c > '9')
                              throw new InputMismatchException();

                        result *= 10;
                        result += c & 15;

                        c = read();
                  } while (!isSpaceChar(c));

                  return result * sign;
            }

            public long[] nextLongArray(int arraySize) {
                  long array[] = new long[arraySize];

                  for (int i = 0; i < arraySize; i++)
                        array[i] = nextLong();

                  return array;
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

