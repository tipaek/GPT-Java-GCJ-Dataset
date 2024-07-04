
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static String solve(int[][] matrix) {
        int trace = 0;
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            Set<Integer> rowNums = new HashSet<>();
            Set<Integer> colNums = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                rowNums.add(matrix[i][j]);
                colNums.add(matrix[j][i]);
            }
            rows += rowNums .size() == matrix.length ? 0 : 1;
            cols+= colNums .size() == matrix.length ? 0 : 1;
        }
        return trace + " " + rows + " " + cols;
    }

    public static void main(String[] args) {
        int T = ni();
        for (int i = 1; i <= T; i++) {
            int N = ni();
            int[][] elements = nim(N, N);
            System.out.println("Case #" + i + ": " + solve(elements));
        }
    }

    static Scanner io = new Scanner(System.in);

    static int ni() {
        return io.nextInt();
    }

    static long nl() {
        return io.nextLong();
    }

    static String ns() {
        return io.next();
    }

    static int[] nia(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = ni();
        }
        return array;
    }

    static int[][] nim(int N, int cols) {
        int[][] matrix = new int[N][cols];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }
}
