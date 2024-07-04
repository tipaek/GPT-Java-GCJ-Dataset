import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 0 ; tc < tests ; tc++) {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] matrix = new int[n][n];


            for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }

            System.out.println("Case #" + (tc+1) + ": "+ solve(n, matrix));
        }

        scanner.close();
    }

    public static String solve(int n, int[][] matrix) {
        int trace = 0, row = 0, col = 0;

        for (int i = 0 ; i < n ; i++) {
            trace += matrix[i][i];
            Set<Integer> valuesInRow = new HashSet<>();
            Set<Integer> valuesInCol = new HashSet<>();

            for (int j = 0 ; j < n ; j++) {
                valuesInRow.add(matrix[i][j]);
                valuesInCol.add(matrix[j][i]);
            }
            
            if (valuesInRow.size() != n) {
                row++;
            }
            
            if (valuesInCol.size() != n) {
                col++;
            }
        }
        return trace + " " + row + " " + col;
    }
}
