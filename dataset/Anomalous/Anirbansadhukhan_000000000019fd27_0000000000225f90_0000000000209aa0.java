class GFG {

    static final int n = 3;

    // Function to find sum of all sub-squares of size k x k in a given square matrix of size n x n
    static void printSumSimple(int[][] mat, int k) {
        // Ensure k is smaller than or equal to n
        if (k > n) return;

        // Iterate over each possible starting point of the k x k sub-squares
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int sum = 0;

                // Calculate sum of the current k x k sub-square
                for (int p = i; p < i + k; p++) {
                    for (int q = j; q < j + k; q++) {
                        sum += mat[p][q];
                    }
                }

                // Print the sum of the current k x k sub-square
                System.out.print(sum + " ");
            }
            // Line separator for sub-squares starting with the next row
            System.out.println();
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[][] mat = {
            {2, 1, 3, 3, 1, 2},
            {3, 2, 1, 1, 2, 3},
            {1, 3, 2, 2, 3, 1}
        };

        int k = 3;
        printSumSimple(mat, k);
    }
}