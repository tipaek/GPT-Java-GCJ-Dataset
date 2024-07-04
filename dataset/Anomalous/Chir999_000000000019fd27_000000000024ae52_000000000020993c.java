import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] trace = new int[T];
        int[] rowRepeats = new int[T];
        int[] colRepeats = new int[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read matrix
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int x = 0; x < N; x++) {
                trace[i] += matrix[x][x];
            }

            // Check for row and column repeats
            for (int x = 0; x < N; x++) {
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int num = 1; num <= N; num++) {
                    int rowCount = 0;
                    int colCount = 0;

                    for (int y = 0; y < N; y++) {
                        if (matrix[x][y] == num) {
                            rowCount++;
                        }
                        if (matrix[y][x] == num) {
                            colCount++;
                        }
                    }

                    if (rowCount > 1) {
                        rowHasDuplicate = true;
                    }
                    if (colCount > 1) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats[i]++;
                }
                if (colHasDuplicate) {
                    colRepeats[i]++;
                }
            }
        }

        // Output results
        for (int j = 0; j < T; j++) {
            System.out.printf("Case #%d: %d %d %d%n", j + 1, trace[j], rowRepeats[j], colRepeats[j]);
        }
    }
}