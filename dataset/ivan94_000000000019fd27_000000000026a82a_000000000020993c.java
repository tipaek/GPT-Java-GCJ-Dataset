import java.util.HashSet;
import java.util.Scanner;

public class App {

    public static String calc(int[][] matrix) {
        int trace = 0;
        boolean[] rowRepeats = new boolean[matrix.length];
        boolean[] columnRepeats = new boolean[matrix.length];
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer>[] columnSets = new HashSet[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (i == j) {
                    trace += current;
                }
                if (!rowSet.add(current)) {
                    rowRepeats[i] = true;
                }
                if (columnSets[j] == null) {
                    columnSets[j] = new HashSet<>();
                }

                if (!columnSets[j].add(current)) {
                    columnRepeats[j] = true;
                }
            }
            rowSet = new HashSet<>();
        }

        int rowC = 0, columnC = 0;
        for (int i = 0; i < rowRepeats.length; i++) {
            if (rowRepeats[i]) {
                rowC++;
            }

            if (columnRepeats[i]) {
                columnC++;
            }
        }

        return String.format("%d %d %d", trace, rowC, columnC);
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = input.nextInt();
                }
            }
            String result = calc(matrix);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }

        input.close();
    }
}