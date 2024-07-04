import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[] rowSum = new int[N];
            int[] colSum = new int[N];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    rowSum[i] += matrix[i][j];
                    colSum[j] += matrix[i][j];
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() < N) {
                    repeatedRows++;
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < N) {
                    repeatedCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedCols);
        }

        sc.close();
    }
}