import java.util.Scanner;

public class LatinSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;

            // Reading the matrix and calculating the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Checking for duplicate values in rows and columns
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(arr[j])) {
                    rowDuplicates++;
                }
                
                int[] colArray = new int[n];
                for (int k = 0; k < n; k++) {
                    colArray[k] = arr[k][j];
                }
                if (hasDuplicates(colArray)) {
                    colDuplicates++;
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value < 1 || value > array.length || seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}