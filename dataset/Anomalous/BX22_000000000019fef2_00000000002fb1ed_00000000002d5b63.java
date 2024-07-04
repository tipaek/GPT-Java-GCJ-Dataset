import java.util.*;
import java.io.*;

public class TemplateInteractive {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            query();
        }
        scanner.close();
    }

    public static void query() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int row = binarySearchLeftRow(-1000000000, 0);
        if (row == 1000000001) return;

        int col = binarySearchBottomCol(-1000000000, 0);
        if (col == 1000000001) return;

        out.println(row + " " + col);
        out.flush();
        String verdict = scanner.next();
        out.close();
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
                if (verdict.equals("CENTER")) {
                    return 1000000001;
                } else if (verdict.equals("HIT")) {
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
                if (verdict.equals("CENTER")) {
                    return 1000000001;
                } else if (verdict.equals("HIT")) {
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