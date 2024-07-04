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
        int ans;
        List<int[]> moves;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int R = in.nextInt();
            int S = in.nextInt();
            int[] A = new int[R * S];
            for (int j = 0; j < S; j++) {
                for (int i = 0; i < R; i++) {
                    A[j * R + i] = i + 1;
                }
            }
            ans = 10;
            moves = new LinkedList<>();
            generate(0, A, new LinkedList<>(), A.length - 1);

            out.println("Case #" + testNumber + ": " + moves.size());
            for (int[] m : moves) {
                out.println(m[0] + " " + m[1]);
            }
        }

        private void generate(int cur, int[] A, LinkedList<int[]> curMoves, int endIdx) {
            if (cur >= ans) {
                return;
            }

            if (sorted(A)) {
                moves = copy(curMoves);
                ans = moves.size();
            } else {

                while (endIdx > 0 && A[endIdx - 1] == A[endIdx]) endIdx--;

                List<Integer> maxes = new LinkedList<>();
                for (int i = 0; i < endIdx; i++) {
                    if (A[i] == A[endIdx]) {
                        maxes.add(i);
                    }
                }


                for (int p : maxes) {
                    int a = p;
                    int b = endIdx - 1;
                    int[] B = regroup(A, a, b);
                    curMoves.addLast(new int[]{a + 1, b - a});
                    int newEnd = endIdx - 1;
                    if (maxes.size() == 1) {
                        newEnd = endIdx - 2;
                    }
                    generate(cur + 1, B, curMoves, newEnd);
                    curMoves.removeLast();
                }
            }
        }

        private LinkedList<int[]> copy(LinkedList<int[]> curMoves) {
            LinkedList<int[]> ans = new LinkedList<>();
            for (int[] p : curMoves) {
                ans.add(new int[]{p[0], p[1]});
            }
            return ans;
        }

        private boolean sorted(int[] A) {
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] > A[i]) return false;
            }
            return true;
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

