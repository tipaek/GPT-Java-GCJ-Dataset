import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    break;
                }
            }

            // Counting columns with duplicate elements
            int columnDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnDuplicates++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    break;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
            caseNumber++;
        }
    }
}