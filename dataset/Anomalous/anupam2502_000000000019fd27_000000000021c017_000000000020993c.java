import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LatinMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            checkLatinMatrix(matrix);
        } finally {
            scanner.close();
        }
    }

    public static void checkLatinMatrix(int[][] matrix) {
        int size = matrix.length;

        int rowDuplicates = countRowDuplicates(matrix, size);
        int colDuplicates = countColDuplicates(matrix, size);
        int trace = calculateTrace(matrix, size);

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
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

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueValues.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicates = 0;

        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueValues.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }
}