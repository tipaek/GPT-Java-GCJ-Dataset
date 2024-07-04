import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int T = in.nextInt();
        int B = in.nextInt();
        for (int i = 0; i < T; i++) {
            solver.solve(in, out, B);
        }
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out, int B) {
            int left = B / 2 - 1;
            int right = B / 2;
            int ld = -1, rd = -1, ls = -1, rs = -1;
            boolean isSameMid = false;
            int[] res = new int[B];
            Arrays.fill(res, -1);

            for (int i = 0; i < 150; i += 2) {
                int f = query(in, out, left);
                int s = query(in, out, right);

                if (i == 0) {
                    isSameMid = f == s;
                } else {
                    if (f == s && ls == -1) {
                        ls = left;
                        rs = right;
                    } else if (f != s && ld == -1) {
                        ld = left;
                        rd = right;
                    }
                }

                if (i % 10 == 0 && i != 0) {
                    handleTransformations(in, out, res, B, ld, ls, isSameMid);
                    i += 2;
                }

                res[left] = f;
                res[right] = s;
                left--;
                right++;
                if (left < 0 || right >= B) {
                    outputResult(in, out, res);
                    return;
                }
            }
        }

        private void handleTransformations(InputReader in, PrintWriter out, int[] res, int B, int ld, int ls, boolean isSameMid) {
            int midValue = query(in, out, B / 2 - 1);
            if (isSameMid) {
                if (midValue != res[B / 2 - 1]) {
                    if (ld == -1) {
                        query(in, out, B / 2 - 1);
                        complement(res, 0, B);
                    } else {
                        int ldValue = query(in, out, ld);
                        if (ldValue == res[ld]) {
                            complement(res, 0, B);
                            reverse(res, 0, B);
                        } else {
                            complement(res, 0, B);
                        }
                    }
                } else {
                    if (ld != -1) {
                        int ldValue = query(in, out, ld);
                        if (ldValue != res[ld]) {
                            reverse(res, 0, B);
                        }
                    } else {
                        query(in, out, B / 2 - 1);
                    }
                }
            } else {
                if (midValue != res[B / 2 - 1]) {
                    if (ls == -1) {
                        query(in, out, B / 2 - 1);
                        complement(res, 0, B);
                    } else {
                        int lsValue = query(in, out, ls);
                        if (lsValue == res[ls]) {
                            reverse(res, 0, B);
                        } else {
                            complement(res, 0, B);
                        }
                    }
                } else {
                    if (ls != -1) {
                        int lsValue = query(in, out, ls);
                        if (lsValue != res[ls]) {
                            complement(res, 0, B);
                            reverse(res, 0, B);
                        }
                    } else {
                        query(in, out, B / 2 - 1);
                    }
                }
            }
        }

        private void complement(int[] arr, int start, int end) {
            for (int i = start; i < end; i++) {
                arr[i] = 1 - arr[i];
            }
        }

        private void reverse(int[] arr, int start, int end) {
            for (int i = start, j = end - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        private int query(InputReader in, PrintWriter out, int position) {
            out.println(position + 1);
            out.flush();
            return in.nextInt();
        }

        private void outputResult(InputReader in, PrintWriter out, int[] res) {
            StringBuilder sb = new StringBuilder();
            for (int value : res) {
                sb.append(value);
            }
            out.println(sb.toString());
            out.flush();
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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