import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static String checkMatrix(Integer[][] matrix, int size) {
        int rowDuplicates = 0;
        int colDuplicates = 0;
        int trace = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);

                if (i == j) {
                    trace += matrix[i][j];
                }
            }

            if (rowSet.size() < size) {
                rowDuplicates++;
            }
            if (colSet.size() < size) {
                colDuplicates++;
            }
        }

        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int k = 1; k <= testCases; k++) {
            int n = scanner.nextInt();
            Integer[][] matrix = new Integer[n][n];
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.valueOf(row[j]);
                }
            }

            System.out.println("Case #" + k + ": " + checkMatrix(matrix, n));
        }
    }
}