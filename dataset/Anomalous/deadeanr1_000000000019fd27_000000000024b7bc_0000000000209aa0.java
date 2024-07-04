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
                int[] sequence = new int[n];
                for (int j = 0; j < n; j++) {
                    sequence[j] = j + 1;
                }

                if (k % n == 0) {
                    int d = k / n - 1;
                    printPossibleCase(caseNumber, sequence, n, d);
                } else if (n > 2 && k == (n * (n + 1) / 2)) {
                    int d = 0;
                    printPossibleCase(caseNumber, sequence, n, d);
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void printPossibleCase(int caseNumber, int[] sequence, int n, int d) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int x = 0; x < n; x++) {
            int temp = d + x;
            for (int j = 0; j < n; j++) {
                System.out.print(sequence[(temp + j) % n]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}