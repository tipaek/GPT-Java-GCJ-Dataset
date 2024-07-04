import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution v = new Solution();
        v.first();
    }

    private void first() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++) {
            int y = sc.nextInt();
            int[][] matrix = new int[y][y];
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < y; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            int[] val = findSolution(y, matrix);
            String answer = "Case #" + i + ": " + val[0] + " " + val[1] + " " + val[2];
            System.out.println(answer);
        }
    }

    int[] findSolution(int y, int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < y; i++) {
            int[] col = new int[y + 1];
            int[] row = new int[y + 1];
            for (int j = 0; j < y; j++) {
                if (i == j) {
                    a += matrix[i][j];
                }
                col[matrix[i][j]]++;
                row[matrix[j][i]]++;
            }
            for (int j = 1; j < y + 1; j++) {
                if (col[j] > 1) {
                    b++;
                    break;
                }
            }
            for (int j = 1; j < y + 1; j++) {
                if (row[j] > 1) {
                    c++;
                    break;
                }
            }
        }

        int[] answer = new int[] { a, b, c };
        return answer;
    }
}