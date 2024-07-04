import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[][] matrix = new int[m][m];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int j = 0; j < m; j++) {
                trace += matrix[j][j];
            }

            // Calculate row repeats
            for (int j = 0; j < m; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Calculate column repeats
            for (int k = 0; k < m; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < m; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}