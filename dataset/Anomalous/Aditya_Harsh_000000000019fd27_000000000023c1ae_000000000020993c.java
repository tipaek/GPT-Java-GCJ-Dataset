import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][4];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            results[i][0] = i + 1;
            results[i][1] = trace;
            results[i][2] = countDuplicateColumns(matrix, n);
            results[i][3] = countDuplicateRows(matrix, n);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + results[i][0] + ": " + results[i][1] + " " + results[i][3] + " " + results[i][2]);
        }
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;

        for (int x = 0; x < n; x++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int y = 0; y < n; y++) {
                if (seen.contains(matrix[y][x])) {
                    hasDuplicate = true;
                    break;
                } else {
                    seen.add(matrix[y][x]);
                }
            }

            if (hasDuplicate) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;

        for (int x = 0; x < n; x++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int y = 0; y < n; y++) {
                if (seen.contains(matrix[x][y])) {
                    hasDuplicate = true;
                    break;
                } else {
                    seen.add(matrix[x][y]);
                }
            }

            if (hasDuplicate) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }
}