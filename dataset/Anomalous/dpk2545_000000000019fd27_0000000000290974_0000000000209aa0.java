import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                printLatinSquare(n, k, caseNumber);
                if (caseNumber < t) {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printLatinSquare(int n, int k, int caseNumber) {
        if (n * n < k) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }

        int x = -1;
        for (int i = 1; i <= n; i++) {
            if (n * i == k) {
                x = i;
                break;
            }
        }

        if (x == -1) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }

        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        int y = x;
        for (int i = 0; i < n; i++) {
            y = y == 0 ? n : y;
            x = y;
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(x > n ? (x++) % n + 1 : x++).append(" ");
            }
            System.out.println(row.toString().trim());
            y--;
        }
    }
}