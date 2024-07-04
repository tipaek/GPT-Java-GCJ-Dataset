import java.util.*;
import java.io.*;

public class TemplateInteractive {
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

        int row = binSearchLeftRow(0, 1000000000);
        if (row == 1000000001) return true;
        else if (row == -1000000001) return false;

        int col = binSearchBottomCol(0, 1000000000);
        if (col == 1000000001) return true;
        else if (col == -1000000001) return false;

        out.println(row + " " + col);
        out.flush();
        System.out.println("DONE");

        String verdict = in.next();
        if (verdict.equals("WRONG")) return false;
        return true;
    }

    public static int binSearchBottomCol(int left, int right) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2;
            boolean hit = false;

            for (int i = 0; i < 5; i++) {
                int col = 1000000000 - 1000000000 / 2 * i;
                out.println(col + " " + mid);
                out.flush();

                String verdict = in.next();
                if (verdict.equals("CENTER")) return 1000000001;
                if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                }
            }

            if (hit) left = mid;
            else right = mid - 1;
        }

        return left;
    }

    public static int binSearchLeftRow(int left, int right) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        while (left < right) {
            int mid = (left + right) / 2 + 1;
            boolean hit = false;

            for (int i = 0; i < 5; i++) {
                int col = 1000000000 - 1000000000 / 2 * i;
                out.println(mid + " " + col);
                out.flush();

                String verdict = in.next();
                if (verdict.equals("CENTER")) return 1000000001;
                if (verdict.equals("HIT")) {
                    hit = true;
                    break;
                }
            }

            if (hit) left = mid;
            else right = mid - 1;
        }

        return left;
    }
}