import java.util.BitSet;
import java.util.Scanner;

class MatrixAnalysis {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                
                // Read the matrix
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                
                // Calculate the trace
                int trace = 0;
                for (int i = 0; i < size; i++) {
                    trace += matrix[i][i];
                }
                
                // Calculate the number of rows with repeated elements
                int repeatedRows = 0;
                for (int i = 0; i < size; i++) {
                    BitSet rowSet = new BitSet(size + 1);
                    for (int j = 0; j < size; j++) {
                        rowSet.set(matrix[i][j]);
                    }
                    if (rowSet.cardinality() < size) {
                        repeatedRows++;
                    }
                }
                
                // Calculate the number of columns with repeated elements
                int repeatedColumns = 0;
                for (int i = 0; i < size; i++) {
                    BitSet colSet = new BitSet(size + 1);
                    for (int j = 0; j < size; j++) {
                        colSet.set(matrix[j][i]);
                    }
                    if (colSet.cardinality() < size) {
                        repeatedColumns++;
                    }
                }
                
                // Output the results
                System.out.printf("Case #%d: %d %d %d\n", t, trace, repeatedRows, repeatedColumns);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        MatrixAnalysis.main(args);
    }
}