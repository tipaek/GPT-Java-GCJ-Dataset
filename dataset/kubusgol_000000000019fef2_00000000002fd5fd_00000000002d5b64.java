import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.LinkedList;
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
        Set<String> used;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int R = in.nextInt();
            int S = in.nextInt();
            int[] A = new int[R * S];
            for (int j = 0; j < S; j++) {
                for (int i = 0; i < R; i++) {
                    A[j * R + i] = i + 1;
                }
            }
            ans = 15;
            moves = new LinkedList<>();
            used = new HashSet<>();

            generate(0, A, new LinkedList<>());

            out.println("Case #" + testNumber + ": " + moves.size());
            for (int[] m : moves) {
                out.println(m[0] + " " + m[1]);
            }
        }

        private void generate(int cur, int[] A, LinkedList<int[]> curMoves) {
            if (cur >= ans) {
                return;
            }
            if (sorted(A)) {
                ans = cur;
                moves = copy(curMoves);
            } else {
                int end = A.length - 1;
                while (end > 0 && A[end - 1] == A[end]) end--;

                for (int a = 0; a < end; a++) {
                    for (int b = a + 1; b < end; b++) {
                        int[] B = regroup(A, a, b);
//                    String key = key(B);
//                    if (used.contains(key)) continue;
//                    used.add(key);
                        curMoves.addLast(new int[]{a + 1, b - a});
                        generate(cur + 1, B, curMoves);
                        curMoves.removeLast();
//                    used.remove(key);
                    }
                }
            }
        }

        private List<int[]> copy(LinkedList<int[]> curMoves) {
            List<int[]> ans = new LinkedList<>();
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

