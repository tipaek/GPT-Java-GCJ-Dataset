import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= cases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean possible = false;
            int start = 1;
            int trace = 0;

            for (int j = 1; j <= n; j++) {
                trace += j;
                if (k == j * n) {
                    possible = true;
                    start = j;
                    break;
                }
            }

            if (possible) {
                printPossibleCase(i, n, start, -1);
            } else if (n > 2 && k == trace) {
                printPossibleCase(i, n, start, 1);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            }
        }
    }

    private static void printPossibleCase(int caseNumber, int n, int start, int increment) {
        System.out.printf("Case #%d: POSSIBLE\n", caseNumber);
        for (int j = 1; j <= n; j++) {
            System.out.print(start);
            for (int j2 = start + 1; j2 < n + start; j2++) {
                System.out.print(" " + (j2 - (n * ((j2 - 1) / n))));
            }
            start += increment;
            if (start > n) start = 1;
            if (start == 0) start = n;
            System.out.println();
        }
    }
}