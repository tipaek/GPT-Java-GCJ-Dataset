import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(in, i);
        }
    }

    private static void solve(Scanner sc, int c) {
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int trace = 0;
        for(int i = 0; i < N; ++i) {
            trace += matrix[i][i];
        }

        int rows = 0;
        int cols = 0;
        for(int i = 0; i < N; ++i) {
            Set<Integer> existingRow= new HashSet<>();
            Set<Integer> existingCol = new HashSet<>();
            for(int j = 0; j < N; ++j) {
                existingRow.add(matrix[i][j]);
                existingCol.add(matrix[j][i]);
            }
            if(existingCol.size() < N) {
                ++cols;
            }
            if(existingRow.size() < N) {
                ++rows;
            }
        }
        System.out.println("Case #" + c + ": " + trace + " " + rows + " " + cols);

    }
}
  