import java.util.Scanner;

class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Checking for duplicate elements in each row
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < n - 1 && !hasDuplicate; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            rowDuplicates++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                }
            }

            // Checking for duplicate elements in each column
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int j = 0; j < n - 1 && !hasDuplicate; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            colDuplicates++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                }
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            t--;
        }
        sc.close();
    }
}