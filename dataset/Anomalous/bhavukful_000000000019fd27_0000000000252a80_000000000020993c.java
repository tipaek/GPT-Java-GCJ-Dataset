import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateColumns = 0;
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}