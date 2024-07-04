import java.util.*;

class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            processTestCase(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void processTestCase(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int diagonalSum = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        // Read matrix and calculate diagonal sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        // Check for row repeats
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for column repeats
        for (int j = 0; j < n; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    columnRepeats++;
                    break;
                }
            }
        }

        // Output results
        System.out.println(diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }
}