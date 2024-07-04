import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }
            int[] re = get(matrix);

            System.out.println("Case #"+(i+1) +": " + re[0] + " " + re[1] +" " + re[2]);
        }
    }
    private static int[] get(int[][] matrix) {
        int[] re = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            boolean[] row = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (row[matrix[i][j] - 1]) {
                    re[1]++;
                    break;
                }
                row[matrix[i][j] - 1] = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean[] col = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (col[matrix[j][i] - 1]) {
                    re[2]++;
                    break;
                }
                col[matrix[j][i] - 1] = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            re[0] += matrix[i][i];
        }
        return re;
    }

}
