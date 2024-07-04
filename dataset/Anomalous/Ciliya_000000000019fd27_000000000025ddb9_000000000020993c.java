import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diaSum = 0, rowDup = 0, colDup = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDup = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diaSum += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDup = true;
                    }
                }
                if (rowHasDup) {
                    rowDup++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDup++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + diaSum + " " + rowDup + " " + colDup);
        }

        scanner.close();
    }
}