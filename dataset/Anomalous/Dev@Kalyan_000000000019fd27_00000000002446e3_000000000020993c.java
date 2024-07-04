package src;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] trace = new int[T];
        int[] rowRepeats = new int[T];
        int[] colRepeats = new int[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            boolean[] rowFlag = new boolean[N];
            boolean[] colFlag = new boolean[N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace[i] += matrix[j][k];
                    }
                }
            }

            rowRepeats[i] = countRepeats(matrix, true, rowFlag);
            colRepeats[i] = countRepeats(matrix, false, colFlag);
        }

        scanner.close();

        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace[i], rowRepeats[i], colRepeats[i]);
        }
    }

    private static int countRepeats(int[][] matrix, boolean isRow, boolean[] flag) {
        int N = matrix.length;
        int repeats = 0;

        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen[value]) {
                    if (!flag[i]) {
                        flag[i] = true;
                        repeats++;
                    }
                } else {
                    seen[value] = true;
                }
            }
        }

        return repeats;
    }
}