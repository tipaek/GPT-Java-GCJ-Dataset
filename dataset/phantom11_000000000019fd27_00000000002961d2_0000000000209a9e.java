import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int B = in.nextInt();
            int original[] = new int[B];
            int sameIndex = -1, differentIndex = -1;
            int currentSame = -1, currentDifferent = -1;
            int left = 0, right = B - 1;
            int queryNumber = 0;
            while (left < right) {
                if (queryNumber % 10 == 0) {
                    if (sameIndex != -1) {
                        currentSame = query(in, sameIndex);
                        queryNumber++;
                    }
                    if (differentIndex != -1) {
                        currentDifferent = query(in, differentIndex);
                        queryNumber++;
                    }
                }
                if (queryNumber % 10 == 9) {
                    // waste a query
                    query(in, 1);
                    queryNumber++;
                    continue;
                }
                int currentLeft = query(in, left);
                int currentRight = query(in, right);
                if (currentLeft == currentRight) {
                    if (sameIndex != -1) {
                        if (currentSame == original[sameIndex]) {
                            original[left] = original[right] = currentLeft;
                        } else {
                            original[left] = original[right] = 1 - currentLeft;
                        }
                    } else {
                        sameIndex = left;
                        original[left] = original[right] = currentLeft;
                        currentSame = currentLeft;
                    }
                } else {
                    if (differentIndex != -1) {
                        if (currentDifferent == original[differentIndex]) {
                            original[left] = currentLeft;
                            original[right] = currentRight;
                        } else {
                            original[left] = 1 - currentLeft;
                            original[right] = 1 - currentRight;
                        }
                    } else {
                        differentIndex = left;
                        original[left] = currentLeft;
                        original[right] = currentRight;
                        currentDifferent = currentLeft;
                    }
                }
                left++;
                right--;
                queryNumber += 2;
            }
            while (queryNumber % 10 > 0) {
                query(in, 1);
                queryNumber++;
            }
            if (sameIndex != -1 && differentIndex != -1) {
                currentSame = query(in, sameIndex);
                currentDifferent = query(in, differentIndex);
                if (currentSame == original[sameIndex]) {
                    if (currentDifferent == original[differentIndex]) {
                        // no change
                    } else {
                        // reverse
                        reverseArray(original);
                    }
                } else {
                    if (currentDifferent == original[differentIndex]) {
                        // both
                        reverseArray(original);
                        flipArray(original);
                    } else {
                        // flip
                        flipArray(original);
                    }
                }
            } else if (sameIndex != -1) {
                currentSame = query(in, sameIndex);
                if (currentSame != original[sameIndex]) {
                    flipArray(original);
                }
            } else {
                currentDifferent = query(in, differentIndex);
                if (currentDifferent != original[differentIndex]) {
                    flipArray(original);
                }
            }
            printArray(original);
            String verdict = in.nextLine();
            if (verdict.equals("N")) {
                System.exit(0);
            }
        }

        public int query(InputReader in, int position) {
            System.out.println(position + 1);
            String s = in.nextLine();
            if (s.equals("N")) {
                System.exit(0);
            }
            return s.charAt(0) - '0';
        }

        public void printArray(int a[]) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        }

        public void reverseArray(int a[]) {
            int left = 0, right = a.length - 1;
            while (left < right) {
                if (a[left] != a[right]) {
                    a[left] = 1 - a[left];
                    a[right] = 1 - a[right];
                }
                left++;
                right--;
            }
        }

        public void flipArray(int a[]) {
            for (int i = 0; i < a.length; i++) {
                a[i] = 1 - a[i];
            }
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

        public String nextLine() {
            try {
                return in.readLine();
            } catch (IOException e) {
                return null;
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

        public void close() {
            writer.close();
        }

    }
}

