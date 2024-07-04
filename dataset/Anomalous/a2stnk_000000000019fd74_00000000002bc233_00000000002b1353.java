import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
            int testCases = sc.nextInt();
            for (int i = 0; i < testCases; i++) {
                pw.printf("Case #%d: ", i + 1);
                solve(sc, pw);
            }
        }
    }

    private static void solve(Scanner sc, PrintWriter pw) {
        int N = sc.nextInt();
        pw.println();

        if (N <= 500) {
            for (int i = 0; i < N; i++) {
                pw.println((i + 1) + " 1");
            }
        } else if (N <= 1000) {
            int row = 1, col = 1, sum = 1;
            pw.println("1 1");

            while (sum + row <= N) {
                pw.println((row + 1) + " " + (col + 1));
                sum += row;
                row++;
            }

            row--;
            col = 0;
            while (sum < N) {
                pw.println((row + 1) + " " + (col + 1));
                sum++;
                row++;
            }
        }

        pw.flush();
    }
}