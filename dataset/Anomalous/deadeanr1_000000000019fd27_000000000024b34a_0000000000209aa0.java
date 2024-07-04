import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] sequence = new int[n];
            for (int j = 0; j < n; j++) {
                sequence[j] = j + 1;
            }

            if (k % n == 0) {
                int d = k / n - 1;
                printPossibleCase(caseNum, n, sequence, d);
            } else if (n > 2 && k == (n * (n + 1) / 2)) {
                int d = 0;
                printPossibleCase(caseNum, n, sequence, d);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static void printPossibleCase(int caseNum, int n, int[] sequence, int d) {
        System.out.println("Case #" + caseNum + ": POSSIBLE");
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