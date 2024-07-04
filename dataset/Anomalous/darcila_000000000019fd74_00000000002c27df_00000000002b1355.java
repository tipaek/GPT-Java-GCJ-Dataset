import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[r][c];
            int[][] nb = new int[r][c];
            int[][] sum = new int[r][c];

            int totalSum = 0;

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    totalSum += matrix[i][j];
                }
            }

            int ans = totalSum;
            boolean removed = true;

            while (removed) {
                removed = false;
                for (int i = 0; i < r; i++) {
                    Arrays.fill(nb[i], 0);
                    Arrays.fill(sum[i], 0);
                }

                for (int i = 0; i < r; i++) {
                    processRow(matrix, nb, sum, i, c);
                }

                for (int j = 0; j < c; j++) {
                    processColumn(matrix, nb, sum, j, r);
                }

                int removedTotal = 0;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (matrix[i][j] > 0 && matrix[i][j] * nb[i][j] < sum[i][j]) {
                            removedTotal += matrix[i][j];
                            removed = true;
                            matrix[i][j] = -1;
                        }
                    }
                }

                if (removed) {
                    ans += totalSum - removedTotal;
                    totalSum -= removedTotal;
                }
            }

            System.out.println("Case #" + t + ": " + ans);
        }
    }

    private static void processRow(int[][] matrix, int[][] nb, int[][] sum, int row, int columns) {
        int lastValue = -1;
        int lastX = 0, lastY = 0;
        for (int j = 0; j < columns; j++) {
            if (matrix[row][j] > 0) {
                if (lastValue > 0) {
                    nb[lastX][lastY]++;
                    nb[row][j]++;
                    sum[lastX][lastY] += matrix[row][j];
                    sum[row][j] += lastValue;
                }
                lastValue = matrix[row][j];
                lastX = row;
                lastY = j;
            }
        }
    }

    private static void processColumn(int[][] matrix, int[][] nb, int[][] sum, int column, int rows) {
        int lastValue = -1;
        int lastX = 0, lastY = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][column] > 0) {
                if (lastValue > 0) {
                    nb[lastX][lastY]++;
                    nb[i][column]++;
                    sum[lastX][lastY] += matrix[i][column];
                    sum[i][column] += lastValue;
                }
                lastValue = matrix[i][column];
                lastX = i;
                lastY = column;
            }
        }
    }
}