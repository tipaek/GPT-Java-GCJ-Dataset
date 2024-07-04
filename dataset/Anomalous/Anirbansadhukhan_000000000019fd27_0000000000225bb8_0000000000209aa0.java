// Java program to find the sum of all sub-squares of size k x k
public class SubSquareSum {

    // Size of the given matrix
    static final int MATRIX_SIZE = 6;

    // Function to find the sum of all sub-squares of size k x k in a given square matrix of size n x n
    static void calculateSubSquareSums(int[][] matrix, int k) {

        // k must be smaller than or equal to MATRIX_SIZE
        if (k > MATRIX_SIZE) return;

        // Iterate over each possible starting row of the k x k sub-square
        for (int row = 0; row <= MATRIX_SIZE - k; row++) {

            // Iterate over each possible starting column of the k x k sub-square
            for (int col = 0; col <= MATRIX_SIZE - k; col++) {

                // Calculate the sum of the current k x k sub-square
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

    // Main method to test the above function
    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3, 3, 1, 2},
            {3, 2, 1, 1, 2, 3},
            {1, 3, 2, 2, 3, 1},
            {1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3, 3}
        };

        int k = 3;
        calculateSubSquareSums(matrix, k);
    }
}

// This code is contributed by Anant Agarwal.