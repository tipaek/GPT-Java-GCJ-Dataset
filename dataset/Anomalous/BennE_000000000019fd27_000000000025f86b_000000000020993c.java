import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    public static final String SINGLE_RESULT_PATTERN = "{0} {1} {2}";

    private static String getSolution(final Scanner scanner) {
        final int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        int trace = 0;
        boolean[] rowHasDuplicates = new boolean[N];
        boolean[] colHasDuplicates = new boolean[N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                final int value = scanner.nextInt();
                matrix[row][col] = value;

                if (!rowHasDuplicates[row]) {
                    for (int k = 0; k < col; k++) {
                        if (matrix[row][k] == value) {
                            rowHasDuplicates[row] = true;
                            break;
                        }
                    }
                }

                if (!colHasDuplicates[col]) {
                    for (int k = 0; k < row; k++) {
                        if (matrix[k][col] == value) {
                            colHasDuplicates[col] = true;
                            break;
                        }
                    }
                }

                if (row == col) {
                    trace += value;
                }
            }
        }

        return MessageFormat.format(SINGLE_RESULT_PATTERN, trace, countTrues(rowHasDuplicates), countTrues(colHasDuplicates));
    }

    private static int countTrues(final boolean[] array) {
        int count = 0;
        for (boolean value : array) {
            if (value) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
        // final Scanner scanner = new Scanner(new FileInputStream("A.in"));

        final int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}