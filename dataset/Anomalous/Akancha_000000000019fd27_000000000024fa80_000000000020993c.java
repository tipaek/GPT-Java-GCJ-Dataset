import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        // Array to store trace values for each test case
        int[] trace = new int[t];
        
        for (int i = 0; i < t; i++) {
            int dimension = sc.nextInt();
            int sum = (dimension * (dimension + 1)) / 2;
            int[][] matrix = new int[dimension][dimension];
            int rowIssues = 0, colIssues = 0;

            // Input matrix for each test case and calculate trace
            for (int row = 0; row < dimension; row++) {
                int rowSum = 0;
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace[i] += matrix[row][col];
                    }
                    rowSum += matrix[row][col];
                }
                if (rowSum != sum) {
                    rowIssues++;
                }
            }

            // Check column sums
            for (int col = 0; col < dimension; col++) {
                int colSum = 0;
                for (int row = 0; row < dimension; row++) {
                    colSum += matrix[row][col];
                }
                if (colSum != sum) {
                    colIssues++;
                }
            }

            // Output the results for the current test case
            System.out.println(trace[i] + " " + rowIssues + " " + colIssues);
        }
    }
}