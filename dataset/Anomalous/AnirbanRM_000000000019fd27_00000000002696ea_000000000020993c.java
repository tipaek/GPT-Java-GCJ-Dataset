import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer>[] colSets = new HashSet[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    rowSet.add(value);
                    colSets[j].add(value);
                }
                if (rowSet.size() < matrixSize) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : colSets) {
                if (colSet.size() < matrixSize) {
                    colRepeats++;
                }
            }

            result.append(String.format("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats));
        }

        System.out.print(result);
    }
}