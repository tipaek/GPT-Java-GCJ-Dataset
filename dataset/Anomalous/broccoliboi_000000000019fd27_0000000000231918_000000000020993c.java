import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            scanner.nextLine();
            for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
                int matrixSize = scanner.nextInt();
                scanner.nextLine();
                int[][] matrix = new int[matrixSize][matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                    scanner.nextLine();
                }
                processCase(caseIndex, matrixSize, matrix);
            }
        }
    }

    private static void processCase(int caseNumber, int size, int[][] matrix) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != size) {
                rowDuplicates++;
            }
            if (colSet.size() != size) {
                colDuplicates++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, colDuplicates);
    }
}