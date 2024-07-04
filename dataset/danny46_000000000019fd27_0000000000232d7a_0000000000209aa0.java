import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int K = in.nextInt();

            String res = solve(N, K);
            System.out.println("Case #" + x + ": " + res);
        }
    }


    public static String solve(int N, int K) {
        int[][] matrix = new int[N][N];
        if(solveMatrix(matrix, K)){
            StringBuilder sb = new StringBuilder("POSSIBLE");

            // print matrix
            for(int i = 0; i < N; i++) {
                sb.append('\n');
                for(int j = 0; j < N; j++) {
                    sb.append(matrix[i][j]);
                }
            }

            return sb.toString();
        }

        return "IMPOSSIBLE";
    }

    public static boolean solveMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    List<Integer> possible = genPossibleNumber(matrix, i, j);
                    if(possible.size() != 0) {
                        for(int num: possible) {
                            matrix[i][j] = num;
                            if(solveMatrix(matrix, target)) {
                                return true;
                            }

                            matrix[i][j] = 0;
                        }

                        return false;
                    } else {
                        return false;
                    }
                }
            }
        }

        return getTrace(matrix) == target;
    }

    public static int getTrace(int[][] matrix) {
        int trace = 0;
        for(int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }


    public static List<Integer> genPossibleNumber(int[][] matrix, int r, int c) {

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            row.add(matrix[r][i]);
            col.add(matrix[i][c]);
        }

        List<Integer> possible = new ArrayList<>();
        for(int i = 1; i <= matrix.length; i++) {
            if(row.contains(i) || col.contains(i)) continue;
            possible.add(i);
        }


        return possible;
    }
}