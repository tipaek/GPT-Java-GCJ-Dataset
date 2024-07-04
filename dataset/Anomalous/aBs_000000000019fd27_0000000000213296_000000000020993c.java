import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();

            for (int caseNum = 1; caseNum <= T; caseNum++) {
                int N = scanner.nextInt();
                int[][] matrix = new int[N][N];

                int trace = 0;
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        matrix[row][col] = scanner.nextInt();
                        if (row == col) {
                            trace += matrix[row][col];
                        }
                    }
                }

                int duplicateRows = 0;
                for (int row = 0; row < N; row++) {
                    BitSet seen = new BitSet(N + 1);
                    boolean hasDuplicates = false;
                    for (int col = 0; col < N; col++) {
                        if (seen.get(matrix[row][col])) {
                            hasDuplicates = true;
                        }
                        seen.set(matrix[row][col]);
                    }
                    if (hasDuplicates) {
                        duplicateRows++;
                    }
                }

                int duplicateCols = 0;
                for (int col = 0; col < N; col++) {
                    BitSet seen = new BitSet(N + 1);
                    boolean hasDuplicates = false;
                    for (int row = 0; row < N; row++) {
                        if (seen.get(matrix[row][col])) {
                            hasDuplicates = true;
                        }
                        seen.set(matrix[row][col]);
                    }
                    if (hasDuplicates) {
                        duplicateCols++;
                    }
                }

                System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, duplicateRows, duplicateCols);
            }
        }
    }
}