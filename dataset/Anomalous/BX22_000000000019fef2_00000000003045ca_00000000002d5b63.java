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
        int row = findLeftRow(-1, 1000000001);
        if (row == 1000000001) return true;
        if (row == -1000000001) return false;

        int col = findBottomCol(-1, 1000000001);
        if (col == 1000000001) return true;
        if (col == -1000000001) return false;

        out.println(row + " " + col);
        out.flush();
        System.out.println("DONE");
        String verdict = scanner.next();
        if (verdict.equals("WRONG")) return false;
        return true;
    }

    public static int findBottomCol(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int col = 0;
            boolean hit = false;
            for (int i = 0; i < 5; i++) {
                col = 1000000000 - 1000000000 / 2 * i;
                out.println(col + " " + mid);
                out.flush();
                String verdict = scanner.next();
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
                right = mid;
            }
        }
        return left;
    }

    public static int findLeftRow(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int col = 0;
            boolean hit = false;
            for (int i = 0; i < 5; i++) {
                col = 1000000000 - 1000000000 / 2 * i;
                out.println(mid + " " + col);
                out.flush();
                String verdict = scanner.next();
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