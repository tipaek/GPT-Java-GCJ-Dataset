import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = createScanner();

        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int nonUniqueRows = countNonUniqueRows(matrix, size);
            int nonUniqueColumns = countNonUniqueColumns(matrix, size);

            System.out.printf("Case #%d: %d %d %d%s", caseNumber, trace, nonUniqueRows, nonUniqueColumns, caseNumber != testCases ? "\n" : "");
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countNonUniqueRows(int[][] matrix, int size) {
        int nonUniqueRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != size) {
                nonUniqueRows++;
            }
        }
        return nonUniqueRows;
    }

    private static int countNonUniqueColumns(int[][] matrix, int size) {
        int nonUniqueColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != size) {
                nonUniqueColumns++;
            }
        }
        return nonUniqueColumns;
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
            File outputFile = new File(outputFileName);
            System.setOut(new PrintStream(outputFile));

            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}