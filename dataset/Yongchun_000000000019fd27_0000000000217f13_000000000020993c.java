import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static int sumOfDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int checkRow(int[][] matrix) {
        int n = matrix.length;
        int repeated = 0;
        for (int[] row : matrix) {
            Set<Integer> set = IntStream.of(row).boxed().collect(Collectors.toSet());
            if (set.size() != n) {
                repeated++;
            }
        }
        return repeated;
    }

    static int checkColumn(int[][] matrix) {
        int n = matrix.length;
        int repeated = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int[] col : matrix) {
                set.add(col[i]);
            }
            if (set.size() != n) {
                repeated++;
            }
        }
        return repeated;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": "
                    + sumOfDiagonal(mat) + " "
                    + checkRow(mat) + " "
                    + checkColumn(mat));
        }
    }
} 