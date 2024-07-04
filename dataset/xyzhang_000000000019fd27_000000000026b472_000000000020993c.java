import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static void test(int cases, Scanner sc) {
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = 0;
        for (int i = 0; i < N; i++) {
            k += matrix[i][i];
        }
        int rowRepeated = 0;
        int[] rows = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(rows, 0);
            for (int j : matrix[i]) {
                if (rows[j - 1] != 0) {
                    rowRepeated++;
                    break;
                } else {
                    rows[j - 1]++;
                }
            }
        }
        int columnRepeated = 0;
        int[] columns = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(columns, 0);
            for (int j = 0; j < N; j++) {
                int temp = matrix[j][i];
                if (columns[temp - 1] != 0) {
                    columnRepeated++;
                    break;
                } else {
                    columns[temp - 1]++;
                }
            }
        }
        System.out.println("Case #" + cases + ": " + k + " " + rowRepeated + " " + columnRepeated);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; i++) {
            test(i, sc);
        }
    }
}
