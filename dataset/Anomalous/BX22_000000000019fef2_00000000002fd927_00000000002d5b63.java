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
        int row = binarySearch(-1000000000, 0, true);
        if (row == 1000000001 || row == -1000000001) return row == 1000000001;

        int col = binarySearch(-1000000000, 0, false);
        if (col == 1000000001 || col == -1000000001) return col == 1000000001;

        out.println(col + " " + row);
        out.flush();
        String verdict = in.next();
        return !verdict.equals("WRONG");
    }

    public static int binarySearch(int left, int right, boolean isRowSearch) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 3; i++) {
                int coord = 1000000000 - 1000000000 / 2 * i;
                if (isRowSearch) {
                    out.println(mid + " " + coord);
                } else {
                    out.println(coord + " " + mid);
                }
                out.flush();
                String verdict = in.next();
                if (verdict.equals("CENTER")) return 1000000001;
                if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                }
                if (verdict.equals("WRONG")) return -1000000001;
            }
            if (hit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}