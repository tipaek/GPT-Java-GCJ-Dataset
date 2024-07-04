import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            
            // Reading the matrix and calculating the trace
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            int rowRepeats = 0;
            // Checking for duplicate values in rows
            for (int row = 0; row < N; row++) {
                int[] freq = new int[N];
                for (int col = 0; col < N; col++) {
                    int value = matrix[row][col] - 1;
                    freq[value]++;
                    if (freq[value] > 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            int colRepeats = 0;
            // Checking for duplicate values in columns
            for (int col = 0; col < N; col++) {
                int[] freq = new int[N];
                for (int row = 0; row < N; row++) {
                    int value = matrix[row][col] - 1;
                    freq[value]++;
                    if (freq[value] > 1) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}