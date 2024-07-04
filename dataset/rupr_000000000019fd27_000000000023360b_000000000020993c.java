import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        List<Result> results = new ArrayList<>();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            results.add(naturalLatin(matrix, N));
        }

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        for (int i = 0; i < results.size(); i++) {
            Result r = results.get(i);
            pw.println(String.format("Case #%d: %d %d %d", (i + 1), r.trace, r.rows, r.columns));
            pw.flush();
        }


        pw.close();
        scanner.close();
    }

    private static Result naturalLatin(int[][] matrix, int N) {
        int trace = 0;
        List<Set<Integer>> rowSets = new ArrayList<>(N);
        List<Set<Integer>> colSets = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) trace += matrix[i][j];

                rowSets.get(i).add(matrix[i][j]);
                colSets.get(j).add(matrix[i][j]);
            }
        }

        int rows = 0;
        int cols = 0;
        for (int i = 0; i < N; i++) {
            if (rowSets.get(i).size() < N) rows++;
            if (colSets.get(i).size() < N) cols++;
        }

        return new Result(trace, rows, cols);
    }


    private static class Result {
        private int trace;
        private int rows;
        private int columns;

        public Result(int trace, int rows, int columns) {
            this.trace = trace;
            this.rows = rows;
            this.columns = columns;
        }
    }
}
