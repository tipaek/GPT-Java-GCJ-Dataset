import java.util.*;
import java.io.*;

public class Solution {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            if (!executeQuery()) break;
        }
        scanner.close();
    }

    public static boolean executeQuery() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        int row = binarySearchLeftRow(0, 1000000000);
        if (row == 1000000001) return true;
        if (row == -1000000001) return false;

        int col = binarySearchBottomCol(0, 1000000000);
        if (col == 1000000001) return true;
        if (col == -1000000001) return false;

        out.println(row + " " + col);
        out.flush();
        System.out.println("DONE");

        String verdict = scanner.next();
        return !verdict.equals("WRONG");
    }

    public static int binarySearchBottomCol(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 5; i++) {
                int col = 1000000000 - 1000000000 / 2 * i;
                out.println(col + " " + mid);
                out.flush();

                String verdict = scanner.next();
                if (verdict.equals("CENTER")) return 1000000001;
                if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                }
                if (verdict.equals("WRONG")) return -1000000001;
            }

            if (hit) {
                left = mid;
            } else {
                left = mid - 1;
            }
        }

        return left;
    }

    public static int binarySearchLeftRow(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 5; i++) {
                int col = 1000000000 - 1000000000 / 2 * i;
                out.println(mid + " " + col);
                out.flush();

                String verdict = scanner.next();
                if (verdict.equals("CENTER")) return 1000000001;
                if (verdict.equals("HIT")) {
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