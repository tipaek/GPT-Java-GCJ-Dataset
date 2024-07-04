import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            StringBuilder output = new StringBuilder();

            for (int t = 1; t <= testCases; t++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0;
                int rowRepeats = 0;
                int colRepeats = 0;

                for (int i = 0; i < matrixSize; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < matrixSize; j++) {
                        int value = scanner.nextInt();
                        matrix[i][j] = value;
                        if (i == j) {
                            trace += value;
                        }
                        rowSet.add(value);
                    }
                    if (rowSet.size() != matrixSize) {
                        rowRepeats++;
                    }
                }

                for (int j = 0; j < matrixSize; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int i = 0; i < matrixSize; i++) {
                        colSet.add(matrix[i][j]);
                    }
                    if (colSet.size() != matrixSize) {
                        colRepeats++;
                    }
                }

                output.append(String.format("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats));
            }

            System.out.print(output.toString());
        }
    }
}