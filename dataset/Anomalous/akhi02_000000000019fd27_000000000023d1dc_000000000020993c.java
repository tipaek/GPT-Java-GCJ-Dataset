import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate) {
                        if (!rowSet.add(matrix[i][j])) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        }
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}