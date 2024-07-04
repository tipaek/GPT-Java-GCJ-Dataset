import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();

        for (int round = 1; round <= numberOfRounds; round++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();
            processRound(round, matrixSize, scanner);
        }
    }

    public static void processRound(int roundIndex, int matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String row = scanner.nextLine();
            if (!row.isEmpty()) {
                String[] elements = row.split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
        }

        int trace = calculateTrace(matrix, matrixSize);
        int rowsWithRepeatedElements = countRowsWithRepeatedElements(matrix, matrixSize);
        int colsWithRepeatedElements = countColsWithRepeatedElements(matrix, matrixSize);

        System.out.println("Case #" + roundIndex + ": " + trace + " " + rowsWithRepeatedElements + " " + colsWithRepeatedElements);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix, int size) {
        int repeatedRowsCount = 0;
        for (int i = 0; i < size; i++) {
            if (hasRepeatedElements(matrix[i])) {
                repeatedRowsCount++;
            }
        }
        return repeatedRowsCount;
    }

    private static int countColsWithRepeatedElements(int[][] matrix, int size) {
        int repeatedColsCount = 0;
        for (int i = 0; i < size; i++) {
            int[] col = new int[size];
            for (int j = 0; j < size; j++) {
                col[j] = matrix[j][i];
            }
            if (hasRepeatedElements(col)) {
                repeatedColsCount++;
            }
        }
        return repeatedColsCount;
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> seenElements = new HashSet<>();
        for (int element : array) {
            if (!seenElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}