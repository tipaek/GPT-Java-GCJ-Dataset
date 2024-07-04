import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        if (T < 1 || T > 100) {
            return;
        }

        int[] trace = new int[T];
        int[] rowRepeats = new int[T];
        int[] colRepeats = new int[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }

            // Calculate the trace
            for (int x = 0; x < N; x++) {
                trace[i] += matrix[x][x];
            }

            // Check for repeated elements in rows and columns
            for (int x = 0; x < N; x++) {
                if (hasDuplicates(matrix[x])) {
                    rowRepeats[i]++;
                }

                int[] col = new int[N];
                for (int y = 0; y < N; y++) {
                    col[y] = matrix[y][x];
                }
                if (hasDuplicates(col)) {
                    colRepeats[i]++;
                }
            }
        }

        // Print the results
        for (int j = 0; j < T; j++) {
            System.out.println("Case #" + (j + 1) + ": " + trace[j] + " " + rowRepeats[j] + " " + colRepeats[j]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}