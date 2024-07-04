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
            solver.solve(B, in, out);
        }
        out.close();
    }

    static class ESAb {
        public void solve(int B, Scanner in, PrintWriter out) {
            char[] arr = new char[B];
            Arrays.fill(arr, '*');
            int mid1_idx = B / 2 - 1, mid2_idx = B / 2;
            if (B % 2 != 0) {
                mid1_idx = mid2_idx = B / 2;
            }

            int l = mid1_idx - 1, r = mid2_idx + 1;
            boolean isMiddleChanged = false, isLeftRightChanged = false, sameMid = false;
            int left_idx = -1, right_idx = -1;

            for (int i = 0; i < 150; i += 2) {
                if (i % 10 == 0) {
                    char n1 = read(mid1_idx, in, out), n2 = read(mid2_idx, in, out);
                    if (i == 0) {
                        arr[mid1_idx] = n1;
                        arr[mid2_idx] = n2;
                        sameMid = (n1 == n2);
                    } else {
                        isMiddleChanged = (n1 != arr[mid1_idx] || n2 != arr[mid2_idx]);
                        if (left_idx != -1 && right_idx != -1) {
                            char l1 = read(left_idx, in, out), r1 = read(right_idx, in, out);
                            isLeftRightChanged = (l1 != arr[left_idx] || r1 != arr[right_idx]);
                            fix(arr, isMiddleChanged, isLeftRightChanged, sameMid);
                            i += 2;
                        } else {
                            if (isMiddleChanged) {
                                compliment(arr);
                            }
                        }
                    }
                } else {
                    char l1 = read(l, in, out), r1 = read(r, in, out);
                    if (left_idx == -1 && right_idx == -1 && isValidLR(l1, r1, sameMid)) {
                        left_idx = l;
                        right_idx = r;
                    }
                    arr[l--] = l1;
                    arr[r++] = r1;
                }

                if (l == -1 && r == B) {
                    if (printResult(arr, in, out)) return;
                    left_idx = right_idx = -1;
                    l = mid1_idx - 1;
                    r = mid2_idx + 1;
                }
            }
        }

        boolean printResult(char[] arr, Scanner in, PrintWriter out) {
            out.println(String.valueOf(arr));
            out.flush();
            return in.next().equals("Y");
        }

        boolean isValidLR(char l, char r, boolean sameMid) {
            return sameMid ? l != r : l == r;
        }

        void fix(char[] arr, boolean isMiddleChanged, boolean isLeftRightChanged, boolean sameMid) {
            if (sameMid) {
                if (isMiddleChanged) {
                    compliment(arr);
                    if (!isLeftRightChanged) reverse(arr);
                } else if (isLeftRightChanged) {
                    reverse(arr);
                }
            } else {
                if (isMiddleChanged) {
                    if (isLeftRightChanged) {
                        compliment(arr);
                    } else {
                        reverse(arr);
                    }
                } else if (isLeftRightChanged) {
                    reverse(arr);
                    compliment(arr);
                }
            }
        }

        char read(int pos, Scanner in, PrintWriter out) {
            out.println(pos + 1);
            out.flush();
            return in.next().charAt(0);
        }

        void reverse(char[] arr) {
            for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        void compliment(char[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }
}