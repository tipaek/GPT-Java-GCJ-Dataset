import java.util.*;
import java.io.*;

public class Solution {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            if (!executeQuery()) break;
        }
        scanner.close();
    }

    public static boolean executeQuery() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int row = binarySearchRow(-1_000_000_000, 0);

        if (row == 1_000_000_001) return true;
        if (row == -1_000_000_001) return false;

        int col = binarySearchColumn(-1_000_000_000, 0);

        if (col == 1_000_000_001) return true;
        if (col == -1_000_000_001) return false;

        out.println(row + " " + col);
        out.flush();

        String verdict = scanner.next();
        return !verdict.equals("WRONG");
    }

    public static int binarySearchColumn(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 3; i++) {
                int col = 1_000_000_000 - (1_000_000_000 / 2) * i;
                out.println(col + " " + mid);
                out.flush();

                String verdict = scanner.next();
                if (verdict.equals("CENTER")) {
                    return 1_000_000_001;
                } else if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                } else if (verdict.equals("WRONG")) {
                    return -1_000_000_001;
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

    public static int binarySearchRow(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 3; i++) {
                int col = 1_000_000_000 - (1_000_000_000 / 2) * i;
                out.println(mid + " " + col);
                out.flush();

                String verdict = scanner.next();
                if (verdict.equals("CENTER")) {
                    return 1_000_000_001;
                } else if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                } else if (verdict.equals("WRONG")) {
                    return -1_000_000_001;
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