import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int rowCount = getRowCount(matrix, N);
            int colCount = getColumnCount(matrix, N);
            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
        scanner.close();
    }

    private static int getRowCount(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int getColumnCount(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}