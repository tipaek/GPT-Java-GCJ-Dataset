import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                
                String result = isPossible(n, k) ? "POSSIBLE" : "IMPOSSIBLE";
                System.out.println("Case #" + caseNumber + ": " + result);
                
                if ("POSSIBLE".equals(result)) {
                    printMatrix(n, k);
                }
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        return (k % n == 0) && ((k / n) <= n);
    }

    private static void printMatrix(int n, int k) {
        int value = k / n;
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (value > n) {
                    value = 1;
                }
                row.append(value);
                if (j < n - 1) {
                    row.append(" ");
                }
                value++;
            }
            System.out.println(row);
            value--;
        }
    }
}