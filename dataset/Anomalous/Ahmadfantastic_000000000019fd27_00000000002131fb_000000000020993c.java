import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine();

            int trace = 0;
            int[] rowSum = new int[N];
            int[] colSum = new int[N];
            int[] rowProduct = new int[N];
            int[] colProduct = new int[N];

            Arrays.fill(rowProduct, 1);
            Arrays.fill(colProduct, 1);

            int expectedSum = N * (N + 1) / 2;
            int expectedProduct = factorial(N);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    rowSum[i] += value;
                    colSum[j] += value;
                    rowProduct[i] *= value;
                    colProduct[j] *= value;
                    if (i == j) {
                        trace += value;
                    }
                }
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            int rowIssues = 0, colIssues = 0;
            for (int i = 0; i < N; i++) {
                if (rowSum[i] != expectedSum || rowProduct[i] != expectedProduct) {
                    rowIssues++;
                }
                if (colSum[i] != expectedSum || colProduct[i] != expectedProduct) {
                    colIssues++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowIssues, colIssues);
        }
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}