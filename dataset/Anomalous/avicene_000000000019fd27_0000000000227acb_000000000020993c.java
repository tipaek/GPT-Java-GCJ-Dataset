import java.io.*;
import java.util.*;

public class LatinMatrix {
    public static void main(String[] args) throws Exception {
        try (FileWriter out = new FileWriter("./output.txt");
             FileReader in = new FileReader("./input.txt");
             BufferedReader bin = new BufferedReader(in)) {

            int cases = Integer.parseInt(bin.readLine());

            for (int z = 0; z < cases; ++z) {
                int mSize = Integer.parseInt(bin.readLine());
                int[][] matrix = new int[mSize][mSize];
                int trace = 0, rowCount = 0, colCount = 0;

                Map<Integer, Set<Integer>> columnMap = new HashMap<>();
                int[] columnDuplicates = new int[mSize];
                int[] rowDuplicates = new int[mSize];

                for (int i = 0; i < mSize; i++) {
                    String[] tokens = bin.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < mSize; j++) {
                        matrix[i][j] = Integer.parseInt(tokens[j]);

                        // Check for column duplicates
                        columnMap.putIfAbsent(j, new HashSet<>());
                        if (!columnMap.get(j).add(matrix[i][j])) {
                            columnDuplicates[j] = 1;
                        }

                        // Check for row duplicates
                        if (!rowSet.add(matrix[i][j])) {
                            rowDuplicates[i] = 1;
                        }
                    }
                    trace += matrix[i][i];
                }

                colCount = Arrays.stream(columnDuplicates).sum();
                rowCount = Arrays.stream(rowDuplicates).sum();

                out.write(String.format("Case #%d: %d %d %d%n", z + 1, trace, rowCount, colCount));
            }
        }
    }
}