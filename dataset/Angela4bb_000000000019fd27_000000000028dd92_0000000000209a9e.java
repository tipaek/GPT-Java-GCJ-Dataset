import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ESAb solver = new ESAb();

        OutputStream outputStream = System.out;
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        int B = in.nextInt();
        // t is number of testcases
        for(int i = 1; i <= t; i++) {
            solver.solve(B, in, out);
        }
        out.close();
    }

    static  class ESAb {
        public void solve(int B, Scanner in, PrintWriter out) {
            char[] arr = new char[B];
            Arrays.fill(arr, '*');
            int mid1 = -1, mid2 = -1, left = -1, right = -1;
            int mid1_idx = -1, mid2_idx = -1, left_idx = -1, right_idx = -1;

            if (B % 2 == 0) {
                mid1_idx = B/2 - 1;
                mid2_idx = B/2;
            } else {
                mid1_idx = mid2_idx = B/2;
            }

            int l = mid1_idx - 1, r = mid2_idx + 1;
            boolean isMiddleChanged = false, isLeftRightChanged = false, sameMid = false;

            for(int i = 0; i < 150; i += 2) {
                if (i % 10 == 0) {
                    int n1 = read(mid1_idx, in, out), n2 = read(mid2_idx, in, out);
                    if (i == 0) {
                        arr[mid1_idx] = n1 == 0 ? '0' : '1';
                        arr[mid2_idx] = n2 == 0 ? '0' : '1';
                        if (n1 == n2) sameMid = true;
                    } else {
                        isMiddleChanged = (n1 != mid1 && n2 != mid2);
                    }
                    mid1 = n1;
                    mid2 = n2;
                } else if (i % 10 == 3 && left_idx != -1 && right_idx != -1) {
                    int l1 = read(left_idx, in, out), r1 = read(right_idx, in, out);
                    isLeftRightChanged = l1 != left || r1 != right;
                    left = l1;
                    right = r1;
                    fix(arr, isMiddleChanged, isLeftRightChanged, sameMid);
                } else {
                    int l1 = read(l, in, out), r1 = read(r, in, out);

                    if (left_idx == -1 && right_idx == -1) {
                        if (isValidLR(l, r, sameMid)) {
                            left_idx = l;
                            right_idx = r;
                            left = l1;
                            right = r1;
                        }
                    }

                    arr[l--] = l1 == 0 ? '0' : '1';
                    arr[r++] = r1 == 0 ? '0' : '1';
                }

                if (l == -1 && r == B) {
                    boolean found = printResult(arr, in, out);
                    if (found) return;
                    else {
                        left = right = -1;
                        left_idx = right_idx = -1;
                        l = mid1_idx - 1;
                        r = mid2_idx + 1;
                    }
                }
            }
        }

        boolean printResult(char[] arr, Scanner in, PrintWriter out) {
            out.println(String.valueOf(arr));
            out.flush();
            String res = in.next();
            return res.equals("Y");
        }

        boolean isValidLR(int l, int r, boolean sameMid) {
            if (sameMid) return l != r;
            else return l == r;
        }

        void fix(char[] arr, boolean isMiddleChanged, boolean isLeftRightChanged, boolean sameMid) {
            if (sameMid) {
                if (isMiddleChanged) {
                    compliment(arr);
                    if (!isLeftRightChanged) reverse(arr);
                } else {
                    if (isLeftRightChanged) reverse(arr);
                }
            } else {
                if (isMiddleChanged) {
                    if (isLeftRightChanged) compliment(arr);
                    else reverse(arr);
                } else {
                    if (isLeftRightChanged) {
                        reverse(arr);
                        compliment(arr);
                    }
                }
            }
        }


        int read(int pos, Scanner in, PrintWriter out) {
            pos++;
            out.println("" + pos);
            out.flush();
            return in.nextInt();
        }

        void reverse(char[] arr) {
            int l = 0, r = arr.length - 1;
            while(l <= r) {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }
        }

        void compliment(char[] arr) {
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] == '0') arr[i] = '1';
                else if (arr[i] == '1') arr[i] = '0';
            }
        }
    }
}
