import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;

                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowFlag) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowRepeats++;
                            rowFlag = true;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();

                for (int i = 0; i < N; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colRepeats++;
                        break;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}