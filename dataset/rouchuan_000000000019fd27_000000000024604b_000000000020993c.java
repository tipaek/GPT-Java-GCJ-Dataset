import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            helper(in, i + 1);
        }
    }

    private static void helper(Scanner in, int id) {
        int N = in.nextInt();
        int diagonal = 0;
        int row = 0;
        int col = 0;

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            boolean rowDup = false;

            HashSet<Integer> colSet = new HashSet<>();
            boolean colDup = false;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    diagonal += matrix[i][j];
                }
                if (!rowDup) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDup = true;
                        row++;
                    }
                }

                if (!colDup) {
                    if (!colSet.add(matrix[j][i])) {
                        colDup = true;
                        col++;
                    }
                }
            }
        }

        System.out.println("Case #" + id + ": " + diagonal + " " + row + " " + col);
    }
}