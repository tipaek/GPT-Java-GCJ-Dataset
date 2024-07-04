import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            int distinctRows = 0;
            int distinctCols = 0;
            int diagonalSum = 0;

            // Check for distinct elements in rows and columns, and calculate diagonal sum
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    distinctRows++;
                }
                
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                
                if (hasDuplicates(column)) {
                    distinctCols++;
                }
                
                diagonalSum += matrix[j][j];
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + distinctRows + " " + distinctCols);
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            set.add(value);
        }
        return set.size() != array.length;
    }
}