import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt();
        
        if (T < 1 || T > 100) {
            scr.close();
            return;
        }

        for (int i = 0; i < T; i++) {
            int N = scr.nextInt();
            if (N < 2 || N > 100) {
                scr.close();
                return;
            }

            int sum = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scr.nextInt();
                    if (matrix[j][k] < 1 || matrix[j][k] > N) {
                        scr.close();
                        return;
                    }
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
            }

            // Check for duplicates in rows
            for (int[] row : matrix) {
                if (hasDuplicates(row)) {
                    rowDuplicates++;
                }
            }

            // Check for duplicates in columns
            for (int col = 0; col < N; col++) {
                int[] column = new int[N];
                for (int row = 0; row < N; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            // Print the output
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scr.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}