import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            results[i] = String.format("Case #%d: %s", i + 1, processMatrix(scanner, matrixSize));
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static String processMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int trace = calculateTrace(matrix, size);
        int rowRepeats = countRowRepeats(matrix, size);
        int colRepeats = countColumnRepeats(matrix, size);

        return String.format("%d %d %d", trace, rowRepeats, colRepeats);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int repeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    repeats++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return repeats;
    }

    private static int countColumnRepeats(int[][] matrix, int size) {
        int repeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[j][i]]) {
                    repeats++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }

        return repeats;
    }
}