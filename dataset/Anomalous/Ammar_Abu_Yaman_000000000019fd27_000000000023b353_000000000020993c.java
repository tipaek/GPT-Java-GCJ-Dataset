import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    private static final Scanner scanner = new Scanner(System.in);
    private static int n, t;
    private static final int[][] matrix = new int[101][101];

    public static void main(String[] args) {
        t = scanner.nextInt();

        for (int v = 1; v <= t; ++v) {
            n = scanner.nextInt();
            int trace = 0;

            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countDuplicateRows();
            int columnDuplicates = countDuplicateColumns();

            System.out.println("Case #" + v + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static int countDuplicateRows() {
        int duplicateRows = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; ++i) {
            set.clear();
            for (int j = 1; j <= n; ++j) {
                set.add(matrix[i][j]);
            }
            if (set.size() != n) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns() {
        int duplicateColumns = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; ++i) {
            set.clear();
            for (int j = 1; j <= n; ++j) {
                set.add(matrix[j][i]);
            }
            if (set.size() != n) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }
}