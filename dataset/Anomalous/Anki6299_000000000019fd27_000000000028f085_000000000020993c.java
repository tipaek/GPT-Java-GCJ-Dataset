import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int k = 1; k <= n; k++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            
            // Input matrix elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate the sum of diagonal elements
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }
            
            // Print the sum of diagonal elements
            System.out.println("SUM of DIAGONAL elements of the matrix = " + diagonalSum);
        }
        
        sc.close();
    }
}