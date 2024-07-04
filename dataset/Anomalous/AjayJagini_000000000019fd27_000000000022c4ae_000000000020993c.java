import java.util.Scanner;

class Trace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating the trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Counting row and column repeats
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
                if (!colSet.add(matrix[j][i])) {
                    colRepeats++;
                    break;
                }
            }
        }

        // Printing the results for each test case
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}