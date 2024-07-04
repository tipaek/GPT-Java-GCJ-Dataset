import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            String result = solve(matrix);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    public static String solve(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateCols = countDuplicateCols(matrix, size);

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return duplicateCols;
    }
}