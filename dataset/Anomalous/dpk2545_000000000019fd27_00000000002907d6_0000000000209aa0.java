import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                printLatinSquare(n, k, caseNumber);
                if (caseNumber < testCases) {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printLatinSquare(int n, int k, int caseNumber) {
        if (n * n < k) {
            System.out.printf("Case #%d: IMPOSSIBLE", caseNumber);
            return;
        }

        boolean possible = false;
        int x = -1;
        for (int i = 1; i <= n; i++) {
            if (n * i == k) {
                possible = true;
                x = i;
                break;
            }
        }

        if (!possible) {
            System.out.printf("Case #%d: IMPOSSIBLE", caseNumber);
            return;
        }

        System.out.printf("Case #%d: POSSIBLE", caseNumber);
        int y = x;
        for (int i = 0; i < n; i++) {
            System.out.println();
            y = y == 0 ? n : y;
            x = y;
            for (int j = 0; j < n; j++) {
                System.out.print((x > n ? (x++) % n : x++) + " ");
            }
            y--;
        }
    }
}