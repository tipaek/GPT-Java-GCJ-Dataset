import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for (int i = 0; i < testcases; i++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] inputArray = new String[size];

            for (int j = 0; j < size; j++) {
                inputArray[j] = scanner.nextLine();
            }

            int[][] matrix = createMatrix(inputArray);
            printSolution(i, matrix);
        }

        scanner.close();
    }

    private static void printSolution(int testcase, int[][] matrix) {
        int diagSum = calculateDiagonalSum(matrix);
        int rowDuplicates = countRowDuplicates(matrix);
        int columnDuplicates = countColumnDuplicates(matrix);

        System.out.printf("Case #%d: %d %d %d\n", testcase + 1, diagSum, rowDuplicates, columnDuplicates);
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueValues = new HashSet<>();

            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueValues.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;

        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> uniqueValues = new HashSet<>();

            for (int col = 0; col < matrix.length; col++) {
                if (!uniqueValues.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private static int[][] createMatrix(String[] input) {
        int size = input.length;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] values = input[i].split(" ");
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        return matrix;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }
}