// Java program to construct an n x n 
// matrix such that every row and every 
// column has distinct values.
public class MatrixConstructor {

    private static final int MAX = 100;
    private static int[][] matrix = new int[MAX][MAX];

    // Fills non-one entries in column j 
    // Given that there is a "1" at 
    // position matrix[i][j], this function 
    // fills other entries of column j.
    private static void fillRemaining(int row, int col, int size) {
        int value = 2;

        // Fill all values below the current row
        for (int k = row + 1; k < size; k++) {
            matrix[k][col] = value++;
        }

        // Fill all values above the current row
        for (int k = 0; k < row; k++) {
            matrix[k][col] = value++;
        }
    }

    // Fills entries in matrix[][] with the given set of rules
    private static void constructMatrix(int size) {
        int right = size - 1, left = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                matrix[i][right] = 1;
                fillRemaining(i, right, size);
                right--;
            } else {
                matrix[i][left] = 1;
                fillRemaining(i, left, size);
                left++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 5;

        // Construct the matrix
        constructMatrix(n);

        // Print the constructed matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}