import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            final int n = Integer.parseInt(br.readLine());
            final int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                final String[] curRow = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(curRow[j]);
                }
            }

            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                boolean isSameRow = false;
                boolean isSameCol = false;
                Set<Integer> setRow = new HashSet<>();
                Set<Integer> setCol = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) k += matrix[i][j];
                    if (!setRow.add(matrix[i][j])) isSameRow = true;
                    if (!setCol.add(matrix[j][i])) isSameCol = true;
                }
                if (isSameRow) r += 1;
                if (isSameCol) c += 1;
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}