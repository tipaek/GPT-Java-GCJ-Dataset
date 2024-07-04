import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
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
        int[] referenceArray = createReferenceArray(size);

        for (int i = 0; i < size; i++) {
            int[] row = Arrays.copyOf(matrix[i], size);
            Arrays.sort(row);
            if (!Arrays.equals(row, referenceArray)) {
                duplicates++;
            }
        }

        return duplicates;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        int[] referenceArray = createReferenceArray(size);

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            Arrays.sort(column);
            if (!Arrays.equals(column, referenceArray)) {
                duplicates++;
            }
        }

        return duplicates;
    }

    private static int[] createReferenceArray(int size) {
        int[] referenceArray = new int[size];
        for (int i = 0; i < size; i++) {
            referenceArray[i] = i + 1;
        }
        return referenceArray;
    }
}