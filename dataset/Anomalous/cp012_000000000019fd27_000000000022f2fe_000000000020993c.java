import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate trace
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}