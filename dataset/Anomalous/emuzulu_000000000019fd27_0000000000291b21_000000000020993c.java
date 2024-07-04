import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("test.txt");
        Scanner scanner = new Scanner(text);
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int rowIndex = 0; rowIndex < size; rowIndex++) {
                for (int colIndex = 0; colIndex < size; colIndex++) {
                    matrix[rowIndex][colIndex] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", testIndex + 1, trace, duplicateRows, duplicateColumns);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}