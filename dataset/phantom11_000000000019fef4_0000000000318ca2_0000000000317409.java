import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int X = in.nextInt(), Y = in.nextInt();
            String s = in.next();
            int M = s.length();
            int posX[] = new int[M + 1], posY[] = new int[M + 1];
            int ans = -1;
            posX[0] = X;
            posY[0] = Y;
            for (int i = 0; i <= M; i++) {
                if (Math.abs(posX[i]) + Math.abs(posY[i]) <= i) {
                    ans = i;
                    break;
                }
                if (i < M) {
                    if (s.charAt(i) == 'E') {
                        posX[i + 1] = posX[i] + 1;
                        posY[i + 1] = posY[i];
                    } else if (s.charAt(i) == 'W') {
                        posX[i + 1] = posX[i] - 1;
                        posY[i + 1] = posY[i];
                    } else if (s.charAt(i) == 'N') {
                        posY[i + 1] = posY[i] + 1;
                        posX[i + 1] = posX[i];
                    } else {
                        posY[i + 1] = posY[i] - 1;
                        posX[i + 1] = posX[i];
                    }
                }
            }
            out.print("Case #" + testNumber + ": ");
            if (ans == -1) {
                out.printLine("IMPOSSIBLE");
            } else {
                out.printLine(ans);
            }
        }

    }

    static class OutputWriter {
        PrintWriter writer;

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

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

