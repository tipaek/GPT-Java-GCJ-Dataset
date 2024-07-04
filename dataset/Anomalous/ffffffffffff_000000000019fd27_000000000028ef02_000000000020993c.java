import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = in.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for row duplicates
            for (int row = 0; row < N; row++) {
                if (hasDuplicates(matrix[row])) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int col = 0; col < N; col++) {
                int[] column = new int[N];
                for (int row = 0; row < N; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}