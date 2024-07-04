import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int temp = 1;

        while (temp <= r) {
            int c = sc.nextInt();
            int[][] mat = new int[c][c];

            // Read the matrix
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < c; i++) {
                trace += mat[i][i];
            }

            // Calculate the row and column repeats
            int r_count = 0;
            int c_count = 0;

            for (int i = 0; i < c; i++) {
                if (hasDuplicates(mat[i])) {
                    r_count++;
                }
            }

            for (int j = 0; j < c; j++) {
                int[] column = new int[c];
                for (int i = 0; i < c; i++) {
                    column[i] = mat[i][j];
                }
                if (hasDuplicates(column)) {
                    c_count++;
                }
            }

            // Print the result
            System.out.println("Case #" + temp + ": " + trace + " " + r_count + " " + c_count);
            temp++;
        }
        
        sc.close();
    }

    // Helper method to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}