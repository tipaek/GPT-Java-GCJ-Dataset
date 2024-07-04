import java.util.*;
import java.io.*;

public class TemplateInteractive {
    private static int A;
    private static int B;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                A = scanner.nextInt();
                B = scanner.nextInt();
                System.out.println("Case #" + i + ": ");
            }
        }
    }

    public static void query() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {

            int row = binarySearchLeftRow(-1_000_000_000, 0);
            if (row == 1_000_000_001) return;

            int col = binarySearchBottomCol(-1_000_000_000, 0);
            if (col == 1_000_000_001) return;

            out.println(row + " " + col);
            out.flush();
            String verdict = scanner.next();
        }
    }

    private static int binarySearchBottomCol(int left, int right) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {

            while (left < right) {
                int mid = (left + right) / 2 + 1;
                boolean hit = false;

                for (int i = 0; i < 5; i++) {
                    int col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                    out.println(col + " " + mid);
                    out.flush();
                    String verdict = scanner.next();

                    if ("CENTER".equals(verdict)) {
                        return 1_000_000_001;
                    } else if ("HIT".equals(verdict)) {
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

    private static int binarySearchLeftRow(int left, int right) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {

            while (left < right) {
                int mid = (left + right) / 2 + 1;
                boolean hit = false;

                for (int i = 0; i < 5; i++) {
                    int col = 1_000_000_000 - 1_000_000_000 / 2 * i;
                    out.println(mid + " " + col);
                    out.flush();
                    String verdict = scanner.next();

                    if ("CENTER".equals(verdict)) {
                        return 1_000_000_001;
                    } else if ("HIT".equals(verdict)) {
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