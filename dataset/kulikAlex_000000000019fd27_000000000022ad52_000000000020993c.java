import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = in.nextInt();
                }
            }
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < N; i++) {
                k += M[i][i];
                TreeSet<Integer> nums = new TreeSet<>();
                for (int j = 0; j < N; j++) {
                    if (nums.contains(M[i][j])) {
                        r++;
                        break;
                    }
                    nums.add(M[i][j]);
                }
                nums.clear();
                for (int j = 0; j < N; j++) {
                    if (nums.contains(M[j][i])) {
                        c++;
                        break;
                    }
                    nums.add(M[j][i]);
                }
            }
            out.println("Case #" + testNumber + ": " + k + " " + r + " " + c);
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() {

            try {

                return reader.readLine();

            } catch (IOException e) {

                return null;

            }

        }

        public String next() {

            while (stt == null || !stt.hasMoreTokens()) {

                stt = new StringTokenizer(nextLine());

            }

            return stt.nextToken();

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

    }
}

