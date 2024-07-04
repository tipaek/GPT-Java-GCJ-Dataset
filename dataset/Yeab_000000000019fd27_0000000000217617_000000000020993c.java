import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int takeInt(Scanner scan) {
        return Integer.parseInt(scan.nextLine());
    }

    public static int getTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int getFoulRows(int[][] matrix) {
        int ct = 0;
        for(int[] row: matrix) {
            Set<Integer> set = new HashSet<>();
            for(int elem: row) set.add(elem);
            if (set.size() != row.length) ct += 1;
        }

        return ct;
    }

    public static int getFoulCols(int[][] matrix) {
        int ct = 0;
        for(int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < matrix.length; j++)  {
                set.add(matrix[j][i]);
            }
            if (set.size() != matrix.length) ct += 1;
        }

        return ct;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = takeInt(scan);

        for (int i = 0; i < cases; i++) {
            int N = takeInt(scan);
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                matrix[j] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int trace = getTrace(matrix);
            int foulRows = getFoulRows(matrix);
            int foulCols = getFoulCols(matrix);

            System.out.printf("Case #%d: %d %d %d\n", (i+1), trace, foulRows, foulCols);
        }
    }
}
