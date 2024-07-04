import java.util.HashSet;
import java.util.Scanner;

public class Vestigum {

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

            int r = checkRows();
            int c = checkColumns();

            System.out.println("Case #" + v + ": " + trace + " " + r + " " + c);
        }
    }

    private static int checkRows() {
        int r = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; ++i) {
            set.clear();
            for (int j = 1; j <= n; ++j) {
                set.add(matrix[i][j]);
            }
            if (set.size() != n) {
                r++;
            }
        }

        return r;
    }

    private static int checkColumns() {
        int c = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; ++i) {
            set.clear();
            for (int j = 1; j <= n; ++j) {
                set.add(matrix[j][i]);
            }
            if (set.size() != n) {
                c++;
            }
        }

        return c;
    }
}