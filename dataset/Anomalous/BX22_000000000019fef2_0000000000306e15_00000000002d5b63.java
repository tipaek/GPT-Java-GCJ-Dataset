import java.util.*;
import java.io.*;

public class Solution {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            if (!query()) break;
        }
        in.close();
    }

    public static boolean query() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int a = binSearch(0, 1000000000, true, true);
        int b = binSearch(-1000000000, 0, true, false);
        if (a == 1000000001 || b == 1000000001) return true;

        int c = binSearch(0, 1000000000, false, true);
        int d = binSearch(-1000000000, 0, false, false);
        if (c == 1000000001 || d == 1000000001) return true;

        out.println((a + b) / 2 + " " + (c + d) / 2);
        out.flush();
        System.out.println("DONE");
        String verdict = in.next();
        if (verdict.equals("WRONG")) return false;
        return true;
    }

    public static int binSearch(int left, int right, boolean isHorizontal, boolean isPositive) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int col = 0;
            boolean hit = false;
            int iterations = isPositive ? 3 : 2;

            for (int i = 0; i < iterations; i++) {
                col = isPositive ? (1000000000 - 1000000000 / 2 * i) : (0 - 1000000000 / 2 * i);
                if (isHorizontal) {
                    out.println(mid + " " + col);
                } else {
                    out.println(col + " " + mid);
                }
                out.flush();
                String verdict = in.next();
                if (verdict.equals("CENTER")) {
                    return 1000000001;
                } else if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                }
            }

            if (hit) {
                if (isPositive) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (isPositive) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return left;
    }
}