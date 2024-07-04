import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int numRowsWithDuplicates = countRowsWithDuplicates(matrix, n);
            int numColsWithDuplicates = countColumnsWithDuplicates(matrix, n);

            System.out.format("Case #%d: %d %d %d\n", t, trace, numRowsWithDuplicates, numColsWithDuplicates);
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

    private static int countRowsWithDuplicates(int[][] matrix, int size) {
        int numRowsWithDuplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowElements.add(matrix[i][j])) {
                    numRowsWithDuplicates++;
                    break;
                }
            }
        }
        return numRowsWithDuplicates;
    }

    private static int countColumnsWithDuplicates(int[][] matrix, int size) {
        int numColsWithDuplicates = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colElements.add(matrix[i][j])) {
                    numColsWithDuplicates++;
                    break;
                }
            }
        }
        return numColsWithDuplicates;
    }
}