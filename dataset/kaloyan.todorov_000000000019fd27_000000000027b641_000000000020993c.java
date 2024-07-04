import java.util.*;
import java.io.*;
public class Solution {

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int rowsWithRepeatedValues = 0;
            int columnsWithRepeatedValues = 0;

            Set<Integer> rowSet = new HashSet<>();
            Map<Integer, Set<Integer>> columnsMap = new HashMap<>();
            for (int row = 0; row < n; row++) {
                rowSet.clear();
                for (int column = 0; column < n; column++) {
                    int element = in.nextInt();
                    matrix[row][column] = element;

                    if (columnsMap.containsKey(column)) {
                        Set<Integer> columnSet = columnsMap.get(column);
                        columnSet.add(element);
                    } else {
                        Set<Integer> columnSet = new HashSet<>();
                        columnSet.add(element);
                        columnsMap.put(column, columnSet);
                    }

                    rowSet.add(element);
                }

                rowsWithRepeatedValues += rowSet.size() != n ? 1 : 0;
            }

            for (Set<Integer> columnSet : columnsMap.values()) {
                columnsWithRepeatedValues += columnSet.size() != n ? 1 : 0;
            }

            int trace = calculateTrace(matrix);

            System.out.println("Case #" + i + ": " + trace + " " + rowsWithRepeatedValues + " " + columnsWithRepeatedValues);
        }
    }
}