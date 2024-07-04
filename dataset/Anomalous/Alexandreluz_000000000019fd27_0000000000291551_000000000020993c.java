import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class SolutionVestigium {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberTests = Integer.parseInt(br.readLine());

            for (int i = 0; i < numberTests; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];

                for (int row = 0; row < N; row++) {
                    String[] numbers = br.readLine().split(" ");
                    for (int col = 0; col < N; col++) {
                        matrix[row][col] = Integer.parseInt(numbers[col]);
                    }
                }

                processMatrix(i + 1, N, matrix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processMatrix(int testNumber, int N, int[][] matrix) {
        boolean[] rowDuplicates = new boolean[N];
        boolean[] colDuplicates = new boolean[N];
        List<HashSet<Integer>> rowSets = new ArrayList<>(N);
        List<HashSet<Integer>> colSets = new ArrayList<>(N);
        int trace = 0;

        for (int i = 0; i < N; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                int num = matrix[i][j];
                if (!rowSets.get(i).add(num)) {
                    rowDuplicates[i] = true;
                }
                if (!colSets.get(j).add(num)) {
                    colDuplicates[j] = true;
                }
            }
        }

        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            if (rowDuplicates[i]) {
                rowCount++;
            }
            if (colDuplicates[i]) {
                colCount++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testNumber, trace, rowCount, colCount);
    }
}