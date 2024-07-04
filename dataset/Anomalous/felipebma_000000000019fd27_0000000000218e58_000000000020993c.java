import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            solve(caseIndex);
            if (caseIndex < numberOfCases) {
                System.out.println();
            }
        }
    }

    private static void solve(int caseNumber) {
        int n = scanner.nextInt();
        int trace = 0;
        int[] rowXor = new int[n];
        int[] colXor = new int[n];
        int cumulativeXor = 0;

        for (int i = 1; i <= n; i++) {
            cumulativeXor ^= i;
        }

        Arrays.fill(rowXor, cumulativeXor);
        Arrays.fill(colXor, cumulativeXor);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int num = scanner.nextInt();
                if (row == col) {
                    trace += num;
                }
                rowXor[row] ^= num;
                colXor[col] ^= num;
            }
        }

        int nonZeroRows = (int) Arrays.stream(rowXor).filter(x -> x != 0).count();
        int nonZeroCols = (int) Arrays.stream(colXor).filter(x -> x != 0).count();

        System.out.printf("Case #%d: %d %d %d", caseNumber, trace, nonZeroRows, nonZeroCols);
    }
}