import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int n = Integer.parseInt(br.readLine());

            int diagonalSum = 0;
            List<HashSet<Integer>> rowSets = new ArrayList<>();
            List<HashSet<Integer>> columnSets = new ArrayList<>();

            for (int row = 0; row < n; row++) {
                String[] inputData = br.readLine().split(" ");
                HashSet<Integer> currentRowSet = new HashSet<>();
                rowSets.add(currentRowSet);

                for (int column = 0; column < n; column++) {
                    int number = Integer.parseInt(inputData[column]);
                    currentRowSet.add(number);

                    if (columnSets.size() <= column) {
                        columnSets.add(new HashSet<>());
                    }
                    columnSets.get(column).add(number);

                    if (row == column) {
                        diagonalSum += number;
                    }
                }
            }

            int duplicateRowsCount = 0;
            int duplicateColumnsCount = 0;

            for (HashSet<Integer> rowSet : rowSets) {
                if (rowSet.size() != n) {
                    duplicateRowsCount++;
                }
            }

            for (HashSet<Integer> columnSet : columnSets) {
                if (columnSet.size() != n) {
                    duplicateColumnsCount++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", test, diagonalSum, duplicateRowsCount, duplicateColumnsCount);
        }
    }
}