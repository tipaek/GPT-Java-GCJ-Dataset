import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowFlag && !rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < n; i++) {
                    if (!colFlag && !colSet.add(matrix[i][j])) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowRepeats, colRepeats);
        }
    }
}