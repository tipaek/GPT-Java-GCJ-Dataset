import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Number of test cases
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");

            // Size of the matrix
            int N = in.nextInt();

            int[][] matrix = new int[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += matrix[j][j];
            }

            // Calculate the number of rows with duplicate elements
            int r = 0;
            for (int x = 0; x < N; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < N; y++) {
                    if (!rowSet.add(matrix[x][y])) {
                        r++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with duplicate elements
            int c = 0;
            for (int y = 0; y < N; y++) {
                Set<Integer> colSet = new HashSet<>();
                for (int x = 0; x < N; x++) {
                    if (!colSet.add(matrix[x][y])) {
                        c++;
                        break;
                    }
                }
            }

            // Print results
            System.out.println(trace + " " + r + " " + c);
        }
    }
}