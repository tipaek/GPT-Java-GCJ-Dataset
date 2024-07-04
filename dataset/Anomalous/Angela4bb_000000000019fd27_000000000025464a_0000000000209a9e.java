import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ESAb solver = new ESAb();

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

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
            int mid1Idx = B / 2 - 1, mid2Idx = B / 2;
            if (B % 2 != 0) mid1Idx = mid2Idx;

            int l = mid1Idx, r = mid2Idx;
            boolean isMiddleChanged = false;

            for (int i = 1; i < 150; i += 2) {
                if (r == B) break;

                if (i % 10 == 1) {
                    int i1 = read(mid1Idx, in, out), i2 = read(mid2Idx, in, out);
                    if (mid1 != -1 && mid2 != -1) {
                        isMiddleChanged = mid1 != i1 && mid2 != i2;
                    } else {
                        arr[mid1Idx] = i1;
                        arr[mid2Idx] = i2;
                    }

                    if (left == -1 && right == -1) {
                        if (isMiddleChanged) {
                            complement(arr, l, r);
                        } else {
                            arr[mid1Idx] = i1;
                            arr[mid2Idx] = i2;
                        }
                    }

                    mid1 = i1;
                    mid2 = i2;

                } else if (i % 10 == 3 && left != -1 && right != -1) {
                    int i1 = read(left, in, out), i2 = read(right, in, out);
                    if (mid1 == mid2) {
                        handleMiddleChanged(arr, l, r, isMiddleChanged, i1, i2, left, right);
                    } else {
                        handleMiddleUnchanged(arr, l, r, isMiddleChanged, i1, i2, left, right);
                    }
                } else {
                    int i1 = read(l, in, out), i2 = read(r, in, out);
                    arr[l--] = i1;
                    arr[r++] = i2;

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
            }

            print(arr, out);
            readResult(in);
        }

        private void handleMiddleChanged(int[] arr, int l, int r, boolean isMiddleChanged, int i1, int i2, int left, int right) {
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
        }

        private void handleMiddleUnchanged(int[] arr, int l, int r, boolean isMiddleChanged, int i1, int i2, int left, int right) {
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

        private boolean readResult(Scanner in) {
            return "Y".equals(in.next());
        }

        private void print(int[] arr, PrintWriter out) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i);
            }
            out.println(sb.toString());
            out.flush();
        }

        private int read(int pos, Scanner in, PrintWriter out) {
            out.println(pos + 1);
            out.flush();
            return in.nextInt();
        }

        private void reverse(int[] arr, int l, int r) {
            while (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        private void complement(int[] arr, int l, int r) {
            while (l <= r) {
                arr[l] = 1 - arr[l];
                l++;
            }
        }
    }
}