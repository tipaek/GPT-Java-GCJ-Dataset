import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";
    private static final String SINGLE_RESULT_PATTERN = "{0} {1} {2}";

    private static String getSolution(Scanner scanner) {
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        int trace = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
            }
        }

        int rowCount = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[i][j]]) {
                    rowCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        int colCount = 0;
        for (int j = 0; j < N; j++) {
            boolean[] seen = new boolean[N + 1];
            for (int i = 0; i < N; i++) {
                if (seen[matrix[i][j]]) {
                    colCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return MessageFormat.format(SINGLE_RESULT_PATTERN, trace, rowCount, colCount);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Scanner scanner = new Scanner(new FileInputStream("A.in"));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}