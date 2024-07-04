import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            boolean[] rowRepeated = new boolean[matrixSize];
            boolean[] colRepeated = new boolean[matrixSize];
            Set<Integer>[] rowSets = new HashSet[matrixSize];
            Set<Integer>[] colSets = new HashSet[matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowRepeated[i]) {
                        if (!rowSets[i].add(matrix[i][j])) {
                            rowRepeated[i] = true;
                            rowDuplicates++;
                        }
                    }
                    if (!colRepeated[j]) {
                        if (!colSets[j].add(matrix[i][j])) {
                            colRepeated[j] = true;
                            colDuplicates++;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }
}