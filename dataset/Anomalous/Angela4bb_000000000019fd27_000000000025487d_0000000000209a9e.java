import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ESAb solver = new ESAb();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        int B = in.nextInt();

        for (int i = 1; i <= t; i++) {
            solver.solve(i, B, in, out);
        }
        out.close();
    }

    static class ESAb {
        public void solve(int testNumber, int B, Scanner in, PrintWriter out) {
            int[] arr = new int[B];
            Arrays.fill(arr, -1);

            int mid1 = -1, mid2 = -1, left = -1, right = -1;
            int mid1_idx = B / 2 - 1, mid2_idx = B / 2;
            if (B % 2 != 0) {
                mid1_idx = mid2_idx = B / 2;
            }

            int l = mid1_idx, r = mid2_idx;
            boolean isMiddleChanged = false;
            int i = 1;

            while (i < 150) {
                if (r == B) break;

                if (i % 10 == 1) {
                    int i1 = read(mid1_idx, in, out), i2 = read(mid2_idx, in, out);
                    if (mid1 != -1 && mid2 != -1) {
                        isMiddleChanged = mid1 != i1 && mid2 != i2;
                    } else {
                        arr[mid1_idx] = i1;
                        arr[mid2_idx] = i2;
                    }

                    if (left == -1 && right == -1) {
                        if (isMiddleChanged) {
                            complement(arr, l, r);
                        } else {
                            arr[mid1_idx] = i1;
                            arr[mid2_idx] = i2;
                        }
                    }

                    mid1 = i1;
                    mid2 = i2;

                } else if (i % 10 == 3 && left != -1 && right != -1) {
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
                    int i1 = read(--l, in, out), i2 = read(++r, in, out);

                    arr[l] = i1;
                    arr[r] = i2;
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
                }

                i += 2;
            }

            print(arr, out);
            boolean isSuccess = readResult(in);
        }

        boolean readResult(Scanner in) {
            return in.next().equals("Y");
        }

        void print(int[] arr, PrintWriter out) {
            for (int i : arr) {
                out.print(i);
            }
            out.println();
            out.flush();
        }

        int read(int pos, Scanner in, PrintWriter out) {
            out.println(pos + 1);
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
                arr[l] = arr[l] == 0 ? 1 : 0;
                l++;
            }
        }
    }
}