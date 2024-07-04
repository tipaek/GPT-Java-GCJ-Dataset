import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public int[][] readMatrix(Scanner sc, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
            sc.nextLine();
        }
        return matrix;
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] result = new int[T][3];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] matrix = readMatrix(sc, n);
            result[i][0] = trace(matrix);
            result[i][1] = numberRepeatRows(matrix);
            result[i][2] = numberRepeatCols(matrix);
        }
        for (int i = 0; i < T; i++)
            System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " +
                    result[i][1] + " " + result[i][2]);
    }

    public int trace(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += matrix[i][i];
        return sum;
    }

    public int numberRepeatRows(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                if (set.contains(matrix[i][j])) {
                    count++;
                    break;
                }
                else
                    set.add(matrix[i][j]);
            }
        }
        return count;
    }

    public int numberRepeatCols(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (set.contains(matrix[i][j])) {
                    count++;
                    break;
                }
                else
                    set.add(matrix[i][j]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}