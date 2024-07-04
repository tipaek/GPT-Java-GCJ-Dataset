import java.util.Scanner;

public class TraceCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;

        // Input for number of test cases
        while (true) {
            System.out.println("Enter Test cases between 1 and 100");
            t = sc.nextInt();
            if (t >= 1 && t <= 100) {
                break;
            }
        }

        for (int l = 1; l <= t; l++) {
            int n = 0;

            // Input for size of the matrix
            while (true) {
                System.out.println("Enter N between 2 and 100");
                n = sc.nextInt();
                if (n >= 2 && n <= 100) {
                    break;
                }
            }

            int[][] matrix = new int[n][n];

            // Input for matrix elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter value at " + i + " row and " + j + " Column between 1 and " + n);
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate elements in each row
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in each column
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Output results
            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}