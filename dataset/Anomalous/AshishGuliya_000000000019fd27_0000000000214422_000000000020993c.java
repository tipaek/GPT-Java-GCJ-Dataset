import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
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

                int rowCount = getDuplicateCount(matrix, N, true);
                int colCount = getDuplicateCount(matrix, N, false);

                System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
            }
        }
    }

    private static int getDuplicateCount(int[][] matrix, int n, boolean isRow) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (set.contains(value)) {
                    count++;
                    break;
                }
                set.add(value);
            }
        }

        return count;
    }
}