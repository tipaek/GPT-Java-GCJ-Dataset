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
                if (!processQuery()) break;
            }
        }
    }

    public static boolean processQuery() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            int row = binarySearchLeftRow(-1, 1000000001);
            if (row == 1000000001) return true;
            else if (row == -1000000001) return false;
            else {
                int col = binarySearchBottomCol(-1, 1000000001);
                if (col == 1000000001) return true;
                else if (col == -1000000001) return false;
                else {
                    out.println(row + " " + col);
                    out.flush();
                    System.out.println("DONE");
                    String verdict = in.next();
                    return !verdict.equals("WRONG");
                }
            }
        }
    }

    public static int binarySearchBottomCol(int left, int right) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            int attempts = 0;
            while (left < right) {
                if (attempts > 150) return -1000000001;
                attempts++;
                int mid = (left + right) / 2 + 1;
                int col = 0;
                boolean hit = false;
                for (int i = 0; i < 5; i++) {
                    col = 1000000000 - 1000000000 / 2 * i;
                    out.println(col + " " + mid);
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
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    public static int binarySearchLeftRow(int left, int right) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            while (left < right) {
                int mid = (left + right) / 2 + 1;
                int col = 0;
                boolean hit = false;
                for (int i = 0; i < 5; i++) {
                    col = 1000000000 - 1000000000 / 2 * i;
                    out.println(mid + " " + col);
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
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}