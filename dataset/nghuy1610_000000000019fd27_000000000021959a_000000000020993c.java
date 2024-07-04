
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static void vestigium(int n, int[][] matrix) {
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }
        for (int[] row : matrix) {
            boolean[] exist = new boolean[n];
            boolean notDup = true;
            for (int cell : row) {
                if (!exist[cell - 1]) {
                    exist[cell-1] = true;
                } else {
                    notDup = false;
                    break;
                }
            }
            if (!notDup) {
                r += 1;
            }
        }
        for (int i = 0; i < n; i++) {
            boolean[] exist = new boolean[n];
            boolean notDup = true;
            for (int j = 0; j < n; j++) {
                int val = matrix[j][i];
                if (!exist[val - 1]) {
                    exist[val-1] = true;
                } else {
                    notDup = false;
                    break;
                }
            }
            if (!notDup) {
                c += 1;
            }
        }
        System.out.printf("%d %d %d\n", k, r, c);
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            System.out.printf("Case #%d: ", i +1);
            vestigium(n, matrix);
        }
    }
}
