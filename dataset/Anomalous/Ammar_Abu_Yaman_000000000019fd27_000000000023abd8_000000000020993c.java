import java.util.HashSet;
import java.util.Scanner;

public class Vestigum {

    private static final Scanner scanner = new Scanner(System.in);
    private static int n, t;
    private static final int[][] matrix = new int[101][101];

    public static void main(String[] args) {
        t = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            n = scanner.nextInt();
            int trace = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countRowDuplicates();
            int colDuplicates = countColumnDuplicates();

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int countRowDuplicates() {
        int duplicateRows = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            uniqueElements.clear();
            for (int j = 1; j <= n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates() {
        int duplicateColumns = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            uniqueElements.clear();
            for (int j = 1; j <= n; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}