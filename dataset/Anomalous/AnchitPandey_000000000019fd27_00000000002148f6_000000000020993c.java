import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int test = 1; test <= testCases; test++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
            }

            int columnDuplicates = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> columnMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (columnMap.containsKey(matrix[j][i])) {
                        columnDuplicates++;
                        break;
                    } else {
                        columnMap.put(matrix[j][i], 1);
                    }
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}