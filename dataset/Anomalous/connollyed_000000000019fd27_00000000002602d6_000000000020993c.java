import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();

        for (int t = 0; t < T; t++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];

            // Read matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = input.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            int repeatedRows = 0;
            for (int r = 0; r < N; r++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (!seen.add(matrix[r][c])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            int repeatedCols = 0;
            for (int c = 0; c < N; c++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!seen.add(matrix[r][c])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}