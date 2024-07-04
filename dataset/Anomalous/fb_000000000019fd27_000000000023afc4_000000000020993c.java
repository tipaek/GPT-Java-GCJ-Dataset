import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            processCase(i, scanner);
        }
    }

    private static void processCase(int caseId, Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int trace = calculateTrace(matrix, size);
        int rowDuplicates = countRowDuplicates(matrix, size);
        int colDuplicates = countColumnDuplicates(matrix, size);

        System.out.printf("Case #%d: %d %d %d%n", caseId, trace, rowDuplicates, colDuplicates);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size];
            for (int col = 0; col < size; col++) {
                int value = matrix[row][col] - 1;
                if (seen[value]) {
                    duplicates++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size];
            for (int row = 0; row < size; row++) {
                int value = matrix[row][col] - 1;
                if (seen[value]) {
                    duplicates++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicates;
    }
}