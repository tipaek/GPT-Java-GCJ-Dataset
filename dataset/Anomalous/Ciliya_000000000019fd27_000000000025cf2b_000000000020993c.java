import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int k = 1; k <= T; k++) {
            int diaSum = 0, rowDup = 0, colDup = 0;
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDup = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diaSum += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        hasRowDup = true;
                    }
                }
                if (hasRowDup) {
                    rowDup++;
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDup = false;
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasColDup = true;
                        break;
                    }
                }
                if (hasColDup) {
                    colDup++;
                }
            }

            System.out.println("Case #" + k + ": " + diaSum + " " + rowDup + " " + colDup);
        }

        scanner.close();
    }
}