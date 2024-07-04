import java.util.*;

public class GoogleCodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < N) {
                    rowCount++;
                }
            }

            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < N) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}