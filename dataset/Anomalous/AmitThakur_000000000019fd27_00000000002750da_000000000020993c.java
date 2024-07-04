import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                matrix[row] = Arrays.stream(reader.readLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            }
            
            processCase(caseNumber, matrix);
        }
    }

    private static void processCase(int caseNumber, int[][] matrix) {
        int size = matrix.length;
        int trace = calculateTrace(matrix, size);
        int repeatedRows = countRepeatedRows(matrix, size);
        int repeatedColumns = countRepeatedColumns(matrix, size);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedColumns);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < size) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
}