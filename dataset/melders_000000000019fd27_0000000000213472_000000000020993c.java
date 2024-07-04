import java.io.*;
import java.util.*;

public class Solution {
    private static final String FILE_NAME = "test";

    private static String solve(Scanner in) {
        int N = in.nextInt();

        int trace = 0;
        Set<Integer> repeatingRows = new HashSet<>();

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            Set<Integer> rowNumbers = new HashSet<>();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowNumbers.add(matrix[i][j])) {
                    repeatingRows.add(i);
                }
            }
        }

        Set<Integer> repeatingCols = new HashSet<>();

        for (int j = 0; j < N; j++) {
            Set<Integer> colNumbers = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!colNumbers.add(matrix[i][j])) {
                    repeatingCols.add(j);
                }
            }
        }

        return trace + " " + repeatingRows.size() + " " + repeatingCols.size();
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                System.out.println("Case #" + t + ": " + solution);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
