import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt(), B = in.nextInt();
            int[] arr = new int[B + 1];
            for (int i = 1; i <= B / 2; i++) {
                out.println(i);
                out.flush();
                arr[i] = in.nextInt();
                out.println(B - i + 1);
                out.flush();
                arr[B - i + 1] = in.nextInt();
            }
            if (B == 10) {
                for (int i = 1; i <= B; i++) {
                    out.print(arr[i]);
                }
                out.println();
                out.flush();
            } else if (B == 20) {
                int[][] arrMod = new int[16][];
                for (int i = 0; i < 16; i++) {
                    arrMod[i] = arr;
                    if ((i & (1 << 0)) > 0) {
                        arrMod[i] = complementation(arrMod[i], 1, 5, 16, 20);
                    }
                    if ((i & (1 << 1)) > 0) {
                        arrMod[i] = complementation(arrMod[i], 6, 10, 11, 15);
                    }
                    if ((i & (1 << 2)) > 0) {
                        arrMod[i] = reversal(arrMod[i], 1, 5, 16, 20);
                    }
                    if ((i & (1 << 3)) > 0) {
                        arrMod[i] = reversal(arrMod[i], 6, 10, 11, 15);
                    }
                }
                boolean[] wrong = new boolean[16];
                for (int i = 1; i <= B; i++) {
                    int[] cnt = new int[2];
                    for (int j = 0; j < 16; j++) {
                        if (!wrong[j]) {
                            cnt[arrMod[j][i]]++;
                        }
                    }
                    if (cnt[0] == 0 || cnt[1] == 0) {
                        continue;
                    }
                    out.println(i);
                    out.flush();
                    int val = in.nextInt();
                    for (int j = 0; j < 16; j++) {
                        if (arrMod[j][i] != val) {
                            wrong[j] = true;
                        }
                    }
                }
                for (int j = 0; j < 16; j++) {
                    if (!wrong[j]) {
                        for (int i = 1; i <= B; i++) {
                            out.print(arrMod[0][i]);
                        }
                        break;
                    }
                }
                out.println();
                out.flush();
            } else if (B == 100) {
                for (int i = 1; i <= B; i++) {
                    out.print(arr[i]);
                }
                out.println();
                out.flush();
            }
        }

        int[] complementation(int[] arr, int first1, int last1, int first2, int last2) {
            int[] res = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = arr[i];
            }
            for (int i = first1; i <= last1; i++) {
                res[i] = 1 - arr[i];
            }
            for (int i = first2; i <= last2; i++) {
                res[i] = 1 - arr[i];
            }
            return res;
        }

        int[] reversal(int[] arr, int first1, int last1, int first2, int last2) {
            int[] res = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = arr[i];
            }
            for (int i = first1, j = 0; i <= last1; i++, j++) {
                res[i] = arr[last2 - j];
            }
            for (int i = first2, j = 0; i <= last2; i++, j++) {
                res[i] = arr[last1 - j];
            }
            return res;
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

