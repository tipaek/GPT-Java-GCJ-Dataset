import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStreamReader;
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
        PrintWriter out = new PrintWriter(outputStream);
        JoinTheRanks solver = new JoinTheRanks();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class JoinTheRanks {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int R = in.nextInt();
            int S = in.nextInt();
            int[] A = new int[R * S];
            for (int j = 0; j < S; j++) {
                for (int i = 0; i < R; i++) {
                    A[j * R + i] = i + 1;
                }
            }

//        for (int i = 0; i < A.length; i++) System.out.println(A[i]);
            List<int[]> moves = new LinkedList<>();
            int END = A.length - 1;
            while (true) {
                int max = 0, last = -1;
                for (int i = 1; i <= END; i++) {
                    if (A[max] <= A[i] && i < END) {
                        max = i;
                    }
                    if (A[i] < A[max]) {
                        last = i;
                    }
                }
                if (last == -1) break;

                moves.add(new int[]{max + 1, last - max});
                A = regroup(A, max, last);
                END = last - 1;
            }

            out.println("Case #" + testNumber + ": " + moves.size());
            for (int[] m : moves) {
                out.println(m[0] + " " + m[1]);
            }
        }

        private int[] regroup(int[] A, int first, int second) {
            int[] B = new int[A.length];
            int c = 0;
            for (int i = first + 1; i <= second; i++) {
                B[c++] = A[i];
            }
            for (int i = 0; i <= first; i++) {
                B[c++] = A[i];
            }
            for (int i = second + 1; i < A.length; i++) {
                B[c++] = A[i];
            }
            return B;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

