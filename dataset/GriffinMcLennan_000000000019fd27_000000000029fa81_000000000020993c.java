import java.util.*;

public class Vestigium
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            int n = scanner.nextInt();

            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            solve(matrix, (i + 1));
        }

        scanner.close();
    }

    private static void solve(int[][] matrix, int c) {
        int trace = 0;
        int repeatedCol = 0;
        int repeatedRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        //check for number of repeated rows:

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> set = new HashSet<Integer>();

            for (int j = 0; j < matrix.length; j++) {
                if (set.contains(matrix[i][j])) {
                    repeatedRow++;
                    break;
                }
                else {
                    set.add(matrix[i][j]);
                }
            }
        } 

        for (int j = 0; j < matrix.length; j++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < matrix.length; i++) {
                if (set.contains(matrix[i][j])) {
                    repeatedCol++;
                    break;
                }
                else {
                    set.add(matrix[i][j]);
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", c, trace, repeatedRow, repeatedCol);
    }
}