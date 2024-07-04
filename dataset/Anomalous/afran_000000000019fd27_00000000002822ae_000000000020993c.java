import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                trace += matrix[i][i];
            }

            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedColumns = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;

        for (int i = 0; i < size; i++) {
            HashMap<Integer, Boolean> rowMap = new HashMap<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (rowMap.containsKey(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
                rowMap.put(matrix[i][j], true);
            }

            if (hasDuplicate) {
                repeatedRows++;
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;

        for (int i = 0; i < size; i++) {
            HashMap<Integer, Boolean> columnMap = new HashMap<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (columnMap.containsKey(matrix[j][i])) {
                    hasDuplicate = true;
                    break;
                }
                columnMap.put(matrix[j][i], true);
            }

            if (hasDuplicate) {
                repeatedColumns++;
            }
        }

        return repeatedColumns;
    }
}