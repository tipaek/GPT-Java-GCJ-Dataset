import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            
            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            int[] countArray = new int[N];
            
            // Check for duplicate values in rows
            for (int i = 0; i < N; i++) {
                Arrays.fill(countArray, 0);
                for (int j = 0; j < N; j++) {
                    if (countArray[matrix[i][j] - 1] == 1) {
                        duplicateRows++;
                        break;
                    } else {
                        countArray[matrix[i][j] - 1]++;
                    }
                }
            }
            
            // Check for duplicate values in columns
            for (int i = 0; i < N; i++) {
                Arrays.fill(countArray, 0);
                for (int j = 0; j < N; j++) {
                    if (countArray[matrix[j][i] - 1] == 1) {
                        duplicateCols++;
                        break;
                    } else {
                        countArray[matrix[j][i] - 1]++;
                    }
                }
            }
            
            // Print the result for this test case
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}