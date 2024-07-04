import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            final String IMPOSSIBLE = "IMPOSSIBLE";
            final String POSSIBLE = "POSSIBLE";

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                String result = IMPOSSIBLE;
                int d = 0;

                if (n != 0) {
                    int remainder = k % n;
                    if (remainder == 0 && n <= k && n * n >= k) {
                        result = POSSIBLE;
                        d = k / n;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + result);
                if (POSSIBLE.equals(result)) {
                    printMatrix(n, d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMatrix(int n, int d) {
        for (int row = 0; row < n; row++) {
            d--;
            for (int col = 0; col < n; col++) {
                if (d == -1) {
                    d = n - 1;
                }
                System.out.print(++d + " ");
                if (d == n) {
                    d = 0;
                }
            }
            System.out.println();
        }
    }
}