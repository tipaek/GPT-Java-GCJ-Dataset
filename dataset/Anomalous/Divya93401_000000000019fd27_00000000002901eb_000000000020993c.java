import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int p = 1; p <= T; p++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int k = calculateTrace(matrix, n);
            int r = countDuplicateRows(matrix, n);
            int c = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + p + ": " + k + " " + r + " " + c);
        }
    }

    public static int calculateTrace(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countDuplicateColumns(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}