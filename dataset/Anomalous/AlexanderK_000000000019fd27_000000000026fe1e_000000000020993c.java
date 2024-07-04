package google.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            handleInput(reader);
        }
    }

    private static void handleInput(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][];
            for (int j = 0; j < matrixSize; j++) {
                matrix[j] = Stream.of(reader.readLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
            }
            analyzeMatrix(i + 1, matrix);
        }
    }

    private static void analyzeMatrix(int caseNumber, int[][] matrix) {
        int size = matrix.length;
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        Set<Integer>[] rowSets = new Set[size];
        Set<Integer>[] colSets = new Set[size];
        boolean[] rowHasRepeats = new boolean[size];
        boolean[] colHasRepeats = new boolean[size];

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!rowHasRepeats[i] && !rowSets[i].add(matrix[i][j])) {
                    rowHasRepeats[i] = true;
                    rowRepeats++;
                }
                if (!colHasRepeats[j] && !colSets[j].add(matrix[i][j])) {
                    colHasRepeats[j] = true;
                    colRepeats++;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}