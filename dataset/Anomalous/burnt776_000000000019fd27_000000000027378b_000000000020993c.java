import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MTix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, matrixSize);
            int rowDuplicateCount = calculateRowDuplicates(matrix, matrixSize);
            int columnDuplicateCount = calculateColumnDuplicates(matrix, matrixSize);

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicateCount + " " + columnDuplicateCount);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateRowDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int calculateColumnDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}