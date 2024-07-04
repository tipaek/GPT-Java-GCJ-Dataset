import java.util.*;
import java.io.*;

public class Solution {
    static int A;
    static int B;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            A = in.nextInt();
            B = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                if (!executeQuery()) break;
            }
        }
    }

    public static boolean executeQuery() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            int row = binarySearchLeftRow(-1_000_000_000, 0);
            if (row == 1_000_000_001) return true;
            if (row == -1_000_000_001) return false;

            int col = binarySearchBottomCol(-1_000_000_000, 0);
            if (col == 1_000_000_001) return true;
            if (col == -1_000_000_001) return false;

            out.println(row + " " + col);
            out.flush();
            String verdict = in.next();
            return !verdict.equals("WRONG");
        }
    }

    public static int binarySearchBottomCol(int left, int right) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            while (left < right) {
                int mid = (left + right) / 2;
                boolean hit = false;
                for (int i = 0; i < 5; i++) {
                    int col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                    out.println(col + " " + mid);
                    out.flush();
                    String verdict = in.next();
                    if (verdict.equals("CENTER")) return 1_000_000_001;
                    if (verdict.equals("HIT")) {
                        hit = true;
                        break;
                    }
                    if (verdict.equals("WRONG")) return -1_000_000_001;
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

    public static int binarySearchLeftRow(int left, int right) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            while (left < right) {
                int mid = (left + right) / 2;
                boolean hit = false;
                for (int i = 0; i < 5; i++) {
                    int col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                    out.println(mid + " " + col);
                    out.flush();
                    String verdict = in.next();
                    if (verdict.equals("CENTER")) return 1_000_000_001;
                    if (verdict.equals("HIT")) {
                        hit = true;
                        break;
                    }
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
}