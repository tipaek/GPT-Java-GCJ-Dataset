import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            long sumDiagonal = 0;
            int[] frequency = new int[N + 1];
            int rowDuplicates = 0;
            
            // Read matrix and calculate sum of diagonal elements
            for (int i = 0; i < N; i++) {
                Arrays.fill(frequency, 0);
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        sumDiagonal += matrix[i][j];
                    }
                    frequency[matrix[i][j]]++;
                }
                if (hasDuplicates(frequency, N)) {
                    rowDuplicates++;
                }
            }
            
            int columnDuplicates = 0;
            // Check for duplicates in columns
            for (int i = 0; i < N; i++) {
                Arrays.fill(frequency, 0);
                for (int j = 0; j < N; j++) {
                    frequency[matrix[j][i]]++;
                }
                if (hasDuplicates(frequency, N)) {
                    columnDuplicates++;
                }
            }
            
            System.out.println("Case #" + t + ": " + sumDiagonal + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
    
    private static boolean hasDuplicates(int[] frequency, int N) {
        for (int k = 1; k <= N; k++) {
            if (frequency[k] > 1) {
                return true;
            }
        }
        return false;
    }
}