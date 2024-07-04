import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TemplateInteractive {
    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            A = scanner.nextInt();
            B = scanner.nextInt();
            processQuery();
        }
        scanner.close();
    }

    public static void processQuery() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(System.out);
        int row = binarySearchLeftRow(-1_000_000_000, 0);
        if (row == 1_000_000_001) return;

        int col = binarySearchBottomCol(-1_000_000_000, 0);
        if (col == 1_000_000_001) return;

        writer.println(row + " " + col);
        writer.flush();
        String verdict = scanner.next();
        writer.close();
    }

    public static int binarySearchBottomCol(int left, int right) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int col = 0;
            boolean hit = false;
            for (int i = 0; i < 5; i++) {
                col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                writer.println(col + " " + mid);
                writer.flush();
                String verdict = scanner.next();
                if (verdict.equals("CENTER")) {
                    return 1_000_000_001;
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
        PrintWriter writer = new PrintWriter(System.out);
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            int col = 0;
            boolean hit = false;
            for (int i = 0; i < 5; i++) {
                col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                writer.println(mid + " " + col);
                writer.flush();
                String verdict = scanner.next();
                if (verdict.equals("CENTER")) {
                    return 1_000_000_001;
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