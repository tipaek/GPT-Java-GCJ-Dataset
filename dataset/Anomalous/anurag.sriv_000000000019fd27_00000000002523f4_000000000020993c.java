import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int k = 1; k <= T; k++) {
            int N = sc.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[N][N];
            boolean[] rowCheck, colCheck;

            for (int i = 0; i < N; i++) {
                rowCheck = new boolean[N];
                for (int j = 0; j < N; j++) {
                    int num = sc.nextInt();
                    matrix[i][j] = num;

                    if (i == j) {
                        trace += num;
                    }

                    if (rowCheck[num - 1]) {
                        rowDuplicates++;
                        rowCheck = new boolean[N];
                        break;
                    }
                    rowCheck[num - 1] = true;
                }
            }

            for (int j = 0; j < N; j++) {
                colCheck = new boolean[N];
                for (int i = 0; i < N; i++) {
                    int num = matrix[i][j];

                    if (colCheck[num - 1]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[num - 1] = true;
                }
            }

            System.out.println("Case #" + k + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}