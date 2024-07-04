import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            final String IMPOSSIBLE = "IMPOSSIBLE";
            final String POSSIBLE = "POSSIBLE";

            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

                System.out.println("Case #" + caseNum + ": " + result);
                if (POSSIBLE.equals(result)) {
                    printMatrix(n, d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMatrix(int n, int d) {
        for (int i = 0; i < n; i++) {
            int value = d - 1;
            for (int j = 0; j < n; j++) {
                value = (value + 1) % n;
                System.out.print(value + 1);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}