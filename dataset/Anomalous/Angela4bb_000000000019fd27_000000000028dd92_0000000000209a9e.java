import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        int B = in.nextInt();

        for (int i = 1; i <= t; i++) {
            new ESAb().solve(B, in, out);
        }
        out.close();
    }

    static class ESAb {
        public void solve(int B, Scanner in, PrintWriter out) {
            char[] arr = new char[B];
            Arrays.fill(arr, '*');

            int mid1_idx = B / 2 - 1;
            int mid2_idx = B % 2 == 0 ? B / 2 : mid1_idx;
            int l = mid1_idx - 1, r = mid2_idx + 1;
            int mid1 = -1, mid2 = -1, left = -1, right = -1;
            int left_idx = -1, right_idx = -1;
            boolean isMiddleChanged = false, isLeftRightChanged = false, sameMid = false;

            for (int i = 0; i < 150; i += 2) {
                if (i % 10 == 0) {
                    int n1 = read(mid1_idx, in, out);
                    int n2 = read(mid2_idx, in, out);
                    if (i == 0) {
                        arr[mid1_idx] = charFromInt(n1);
                        arr[mid2_idx] = charFromInt(n2);
                        sameMid = (n1 == n2);
                    } else {
                        isMiddleChanged = (n1 != mid1 && n2 != mid2);
                    }
                    mid1 = n1;
                    mid2 = n2;
                } else if (i % 10 == 3 && left_idx != -1 && right_idx != -1) {
                    int l1 = read(left_idx, in, out);
                    int r1 = read(right_idx, in, out);
                    isLeftRightChanged = (l1 != left || r1 != right);
                    left = l1;
                    right = r1;
                    fix(arr, isMiddleChanged, isLeftRightChanged, sameMid);
                } else {
                    int l1 = read(l, in, out);
                    int r1 = read(r, in, out);
                    if (left_idx == -1 && right_idx == -1 && isValidLR(l, r, sameMid)) {
                        left_idx = l;
                        right_idx = r;
                        left = l1;
                        right = r1;
                    }
                    arr[l--] = charFromInt(l1);
                    arr[r++] = charFromInt(r1);
                }
                if (l == -1 && r == B && printResult(arr, in, out)) {
                    return;
                }
            }
        }

        boolean printResult(char[] arr, Scanner in, PrintWriter out) {
            out.println(arr);
            out.flush();
            return "Y".equals(in.next());
        }

        boolean isValidLR(int l, int r, boolean sameMid) {
            return sameMid ? l != r : l == r;
        }

        void fix(char[] arr, boolean isMiddleChanged, boolean isLeftRightChanged, boolean sameMid) {
            if (sameMid) {
                if (isMiddleChanged) {
                    complement(arr);
                    if (!isLeftRightChanged) reverse(arr);
                } else if (isLeftRightChanged) {
                    reverse(arr);
                }
            } else {
                if (isMiddleChanged) {
                    if (isLeftRightChanged) {
                        complement(arr);
                    } else {
                        reverse(arr);
                    }
                } else if (isLeftRightChanged) {
                    reverse(arr);
                    complement(arr);
                }
            }
        }

        int read(int pos, Scanner in, PrintWriter out) {
            out.println(pos + 1);
            out.flush();
            return in.nextInt();
        }

        void reverse(char[] arr) {
            for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        void complement(char[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }

        char charFromInt(int n) {
            return n == 0 ? '0' : '1';
        }
    }
}