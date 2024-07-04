import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            processInput(reader);
        }
    }

    private static void processInput(BufferedReader reader) throws IOException {
        int caseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < caseCount; i++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][];
            for (int j = 0; j < matrixSize; j++) {
                matrix[j] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            analyzeMatrix(i + 1, matrix);
        }
    }

    private static void analyzeMatrix(int caseNumber, int[][] matrix) {
        int size = matrix.length;
        int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;
        Set<Integer>[] rowSets = new Set[size];
        Set<Integer>[] colSets = new Set[size];
        boolean[] rowHasDuplicate = new boolean[size];
        boolean[] colHasDuplicate = new boolean[size];

        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!rowHasDuplicate[i] && !rowSets[i].add(matrix[i][j])) {
                    rowHasDuplicate[i] = true;
                    rowDuplicates++;
                }
                if (!colHasDuplicate[j] && !colSets[j].add(matrix[i][j])) {
                    colHasDuplicate[j] = true;
                    colDuplicates++;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
    }
}