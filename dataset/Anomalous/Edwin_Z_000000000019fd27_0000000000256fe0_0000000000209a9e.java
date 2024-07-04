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
            int[] res = new int[B];
            int m1 = B / 2 - 1;
            int m2 = B / 2;
            int left = m1 - 1;
            int right = m2 + 1;

            res[m1] = read(in, out, m1);
            res[m2] = read(in, out, m2);
            boolean sameInBetween = res[m1] == res[m2];

            int[] originalMidValue = { res[m1], res[m2] };
            int[] leftRightCheckPosition = new int[2];
            int[] leftRightCheckValue = new int[2];
            int count = 2;

            while (left >= 0 && right < B && count <= 150) {
                res[left] = read(in, out, left);
                res[right] = read(in, out, right);
                if (sameInBetween ? res[left] == res[right] : res[left] != res[right]) {
                    left--;
                    right++;
                } else {
                    leftRightCheckPosition[0] = left;
                    leftRightCheckPosition[1] = right;
                    leftRightCheckValue[0] = res[left];
                    leftRightCheckValue[1] = res[right];
                    break;
                }
                count += 2;
            }

            while (left >= 0 && right < B && count <= 150) {
                if (count % 10 != 0) {
                    res[left] = read(in, out, left);
                    res[right] = read(in, out, right);
                    left--;
                    right++;
                    count += 2;
                } else {
                    int tm1 = read(in, out, m1);
                    int tm2 = read(in, out, m2);
                    int tl = read(in, out, leftRightCheckPosition[0]);
                    int tr = read(in, out, leftRightCheckPosition[1]);
                    count += 4;

                    boolean midValuesUnchanged = tm1 == originalMidValue[0] && tm2 == originalMidValue[1];
                    boolean leftRightValuesChanged = leftRightCheckValue[0] != tl && leftRightCheckValue[1] != tr;

                    if (midValuesUnchanged) {
                        if (leftRightValuesChanged) {
                            reverse(res, left, right);
                        }
                    } else {
                        if (leftRightValuesChanged) {
                            complement(res, left, right);
                        } else {
                            complement(res, left, right);
                            reverse(res, left, right);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i : res) {
                sb.append(i);
            }
            readString(in, out, sb.toString());
        }

        private void complement(int[] arr, int left, int right) {
            for (int i = left; i <= right; i++) {
                arr[i] = 1 - arr[i];
            }
        }

        private void reverse(int[] arr, int left, int right) {
            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }

        private int read(InputReader in, PrintWriter out, int p) {
            out.println(p + 1);
            out.flush();
            return in.nextInt();
        }

        private void readString(InputReader in, PrintWriter out, String p) {
            out.println(p);
            out.flush();
            in.next();
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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