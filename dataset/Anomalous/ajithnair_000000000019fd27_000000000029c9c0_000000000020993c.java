import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int i = 0; i < size; i++) {
                String[] line = reader.readLine().trim().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != size) {
                    rowDuplicates++;
                }
                if (colSet.size() != size) {
                    colDuplicates++;
                }
            }

            results[t] = "Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}