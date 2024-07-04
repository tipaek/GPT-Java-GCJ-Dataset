import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i + 1;
            }

            if (k % n == 0) {
                int offset = k / n - 1;
                printPossibleSolution(caseNumber, n, array, offset);
            } else if (n > 2 && k == (n * (n + 1)) / 2) {
                printPossibleSolution(caseNumber, n, array, 0);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static void printPossibleSolution(int caseNumber, int n, int[] array, int offset) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int i = 0; i < n; i++) {
            int start = offset + i;
            for (int j = 0; j < n; j++) {
                System.out.print(array[(start + j) % n]);
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}