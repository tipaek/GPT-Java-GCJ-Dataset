import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = Integer.parseInt(reader.readLine());
            List<List<Integer>> matrix = new ArrayList<>();

            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;

            for (int row = 0; row < size; row++) {
                String[] line = reader.readLine().split(" ");
                List<Integer> rowData = new ArrayList<>();
                Set<Integer> rowSet = new HashSet<>();
                
                for (int col = 0; col < size; col++) {
                    int value = Integer.parseInt(line[col]);
                    rowData.add(value);
                    rowSet.add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
                matrix.add(rowData);
            }

            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (List<Integer> rowData : matrix) {
                    colSet.add(rowData.get(col));
                }
                if (colSet.size() != size) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}