// A simple Java program to find the sum of all 
// sub-squares of size k x k 
public class SubSquareSum {

    // Size of the given matrix 
    static final int MATRIX_SIZE = 3;

    // A function to find the sum of all 
    // sub-squares of size k x k in a given 
    // square matrix of size n x n 
    static void printSubSquareSums(int[][] matrix, int k) {

        // k must be smaller than or equal to MATRIX_SIZE 
        if (k > MATRIX_SIZE) {
            return;
        }

        // Iterate over each possible starting point for sub-squares 
        for (int row = 0; row <= MATRIX_SIZE - k; row++) {
            for (int col = 0; col <= MATRIX_SIZE - k; col++) {

                // Calculate the sum of the current sub-square 
                int sum = 0;
                for (int i = row; i < row + k; i++) {
                    for (int j = col; j < col + k; j++) {
                        sum += matrix[i][j];
                    }
                }

                // Print the sum of the current sub-square 
                System.out.print(sum + " ");
            }

            // Line separator for sub-squares starting with the next row 
            System.out.println();
        }
    }

    // Driver Program to test the above function 
    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3, 3, 1, 2},
            {3, 2, 1, 1, 2, 3},
            {1, 3, 2, 2, 3, 1}
        };

        int k = 3;
        printSubSquareSums(matrix, k);
    }
}