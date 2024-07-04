import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Scratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = scanner.nextInt();
            int r = 0;
            int c = 0;
            int k = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = scanner.nextInt();
                if (n != Arrays.stream(matrix[i]).distinct().count()) r++;
            }
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = matrix[i][j];
                }
                if (n != Arrays.stream(col).distinct().count()) c++;
            }
            for (int i = 0; i < n; i++) {
                k += matrix[i][i];
            }
            System.out.println("Case #" + l + ":" + k + " " + r + " " + c);
        }
    }
}