import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < N; ++i) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; ++j) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != N) {
                    rowRepeats++;
                }
            }

            colRepeats = countColumnRepeats(matrix);

            results.add(String.format("Case #%d: %d %d %d", t, trace, rowRepeats, colRepeats));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int countColumnRepeats(int[][] matrix) {
        int N = matrix.length;
        int colRepeats = 0;

        for (int j = 0; j < N; ++j) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < N; ++i) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != N) {
                colRepeats++;
            }
        }

        return colRepeats;
    }
}