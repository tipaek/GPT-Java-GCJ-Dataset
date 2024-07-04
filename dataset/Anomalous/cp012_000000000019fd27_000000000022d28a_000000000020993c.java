import java.util.Scanner;
import java.util.HashSet;

public class Matrix {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int test = sc.nextInt();
        
        for (int i = 0; i < test; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < N; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean duplicateInRow = false;
                
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                    
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    
                    if (!duplicateInRow && !rowSet.add(matrix[row][col])) {
                        duplicateInRow = true;
                        rowCount++;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < N; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int row = 0; row < N; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}