import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ESAb solver = new ESAb();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ESAb {
        static final int REVERSE = 0, COMPLEMENT = 1, REVERSE_COMPLEMENT = 2, NOTHING = 3;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int B = in.nextInt();
            int[] arr = new int[B];
            Arrays.fill(arr, -1);

            int mid1 = -1, mid2 = -1, left = -1, right = -1;
            int mid1_idx = B / 2 - 1, mid2_idx = (B % 2 == 0) ? B / 2 : B / 2;
            int l = mid1_idx - 1, r = mid2_idx + 1;

            boolean isMiddleChanged = false;
            for (int i = 1; i <= 75; i++) {
                if (r == B) break;

                if (i % 5 == 1) {
                    int i1 = read(mid1_idx, in, out), i2 = read(mid2_idx, in, out);
                    if (mid1 != -1 && mid2 != -1) {
                        isMiddleChanged = (B % 2 == 0) ? mid1 != i2 && mid2 != i1 : mid1 != i1;
                    } else {
                        arr[mid1_idx] = i1;
                        arr[mid2_idx] = i2;
                    }

                    if (left == -1 && right == -1 && isMiddleChanged) {
                        complement(arr, l, r);
                    }

                    mid1 = i1;
                    mid2 = i2;

                } else if (i % 5 == 2 && left != -1 && right != -1) {
                    int i1 = read(left, in, out), i2 = read(right, in, out);
                    if (mid1 == mid2) {
                        if (isMiddleChanged) {
                            if (i1 != left && i2 != right) {
                                complement(arr, l, r);
                            } else {
                                reverse(arr, l, r);
                                complement(arr, l, r);
                            }
                        } else {
                            if (i1 != left && i2 != right) {
                                reverse(arr, l, r);
                            }
                        }
                    } else {
                        if (isMiddleChanged) {
                            if (i1 != left && i2 != right) {
                                complement(arr, l, r);
                            } else {
                                reverse(arr, l, r);
                            }
                        } else {
                            if (i1 != left && i2 != right) {
                                reverse(arr, l, r);
                                complement(arr, l, r);
                            }
                        }
                    }
                } else {
                    int i1 = read(l, in, out), i2 = read(r, in, out);
                    if (left == -1 && right == -1) {
                        if (mid1 == mid2) {
                            if (i1 != i2) {
                                left = l;
                                right = r;
                            }
                        } else {
                            if (i1 == i2) {
                                left = l;
                                right = r;
                            }
                        }
                    }

                    arr[l--] = i1;
                    arr[r++] = i2;
                }
            }

            print(arr, out);
            boolean isSuccess = readResult(in);
        }

        boolean readResult(InputReader in) {
            String res = in.next();
            return res.equals("Y");
        }

        void print(int[] arr, PrintWriter out) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i);
            }
            out.println(sb.toString());
            out.flush();
        }

        int read(int pos, InputReader in, PrintWriter out) {
            out.println(pos);
            out.flush();
            return in.nextInt();
        }

        void reverse(int[] arr, int l, int r) {
            while (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        void complement(int[] arr, int l, int r) {
            while (l <= r) {
                arr[l] = 1 - arr[l];
                l++;
            }
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