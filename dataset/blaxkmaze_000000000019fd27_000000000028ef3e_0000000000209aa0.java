import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static int[][] rowVisited;
    private static int[][] colVisited;
    private static int[][] matrix;
    private static int[][] sol;

    private static boolean possible;

    private static boolean indicium(int N, int trace) {
        if (N == 0 || trace > N*N || trace < N) {
            return false;
        }

//        matrix = new int[N][N];
//        possible = false;
//        rowVisited = new int[N][N+1];
//        colVisited = new int[N][N+1];
//
//        int traceNum = trace / N;
//        for (int i = 0; i < N; i++) {
//            matrix[i][i] = traceNum;
//            rowVisited[i][traceNum] = 1;
//            colVisited[i][traceNum] = 1;
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (matrix[i][j] == 0) continue;
//                placeNumber(i, j, N);
//            }
//        }

        int total = N * (N+1) / 2;
        if (trace % N != 0 && total != trace) return false;

        boolean reverse = trace % N != 0;

        sol = new int[N][N];

        int traceNum = trace / N;
        int start = 1;
        int x, y;
        for (int i = 0; i < N; i++) {
            if (start == traceNum) start++;
            sol[i][i] = traceNum;

            x = 0;
            y = i + 1;
            while (x < N && y < N) {
                sol[x++][y++] = start;
            }
            x = N-i-1;
            y = 0;
            while (x < N && y < N && x > 0) {
                sol[x++][y++] = start;
            }
            start++;
        }

        if (reverse) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N/2; j++) {
                    swap(sol[i], j, N-1-j);
                }
            }
        }

        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

//    private static void placeNumber(int row, int col, int N) {
//        if ( (row == N - 1) && (col == N - 1) ) {
//            possible = true;
//            sol = new int[N][N];
//
//            for(int i=0; i<N; i++)
//                for(int j=0; j<N; j++)
//                    sol[i][j]=matrix[i][j];
//        } else {
//            if (col == N - 1) backtrack(row + 1, 0, N);
//            else backtrack(row, col + 1, N);
//        }
//    }
//
//    private static void backtrack(int row, int col, int N) {
//        if (matrix[row][col] != 0)  placeNumber(row, col, N);
//
//        for (int i = 1; i <= N; i++) {
//            if (!canPlace(i, row, col)) continue;
//            rowVisited[row][i]++;
//            colVisited[col][i]++;
//            matrix[row][col] = i;
//            placeNumber(row, col, N);
//            if (possible) break;
//            matrix[row][col] = 0;
//            rowVisited[row][i]--;
//            colVisited[col][i]--;
//        }
//    }
//
//    private static boolean canPlace(int num, int row, int col) {
//        return (rowVisited[row][num] + colVisited[col][num]) == 0;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = Integer.valueOf(in.nextInt()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSize; ++i) {
            int N = in.nextInt();
            int trace = in.nextInt();
            boolean output = indicium(N, trace);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #" + i + ": ");
            builder.append(output ? POSSIBLE : IMPOSSIBLE);
            System.out.println(builder.toString().trim());
            if (output) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        System.out.print(sol[x][y]);
                        if (y == N-1) continue;
                        System.out.print(" ");
                    }
                    if (x == N-1) continue;
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}

