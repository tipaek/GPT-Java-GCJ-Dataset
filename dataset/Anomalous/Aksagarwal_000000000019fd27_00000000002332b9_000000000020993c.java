import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < matrixSize; i++) {
                List<Integer> row = new ArrayList<>();
                String[] elements = reader.readLine().split(" ");
                for (String element : elements) {
                    row.add(Integer.parseInt(element));
                }
                matrix.add(row);
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix.get(i).get(i);

                Set<Integer> rowSet = new HashSet<>(matrix.get(i));
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }

                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    colSet.add(matrix.get(j).get(i));
                }
                if (colSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, trace, duplicateRows, duplicateColumns);
        }
    }
}