import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            scanner.nextLine(); // Consume the remaining newline

            int[] result = analyzeMatrix(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix, int size) {
        int duplicateRows = 0;
        int duplicateCols = 0;
        int diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSet.size() != size) duplicateRows++;
            if (colSet.size() != size) duplicateCols++;
            diagonalSum += matrix[i][i];
        }

        return new int[]{diagonalSum, duplicateRows, duplicateCols};
    }
}