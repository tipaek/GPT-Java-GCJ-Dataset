import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] matrix = new int[m][m];

            // Read the matrix
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate the trace
            for (int j = 0; j < m; j++) {
                trace += matrix[j][j];
            }

            // Check for row duplicates
            for (int j = 0; j < m; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int k = 0; k < m; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < m; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}