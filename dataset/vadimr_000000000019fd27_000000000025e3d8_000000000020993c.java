import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(reader.readLine());

        for (int k = 1; k <= testCases; k++) {
            Integer n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int[] result = solve(matrix, n);
            StringBuilder sb = new StringBuilder();

            sb.append("Case #" + k + ": " + result[0] + " " + result[1] + " " + result[2]);
            System.out.println(sb.toString());
        }
    }

    public static int[] solve(int[][] matrix, int n) {
        int[] result = new int[3];
        //int[] col = new int[n]; // 0 - none, 1 - exist, -1 - exclude col
        //int[] row = new int[n];
       //int[] col = new int[n];
        Map<Integer, HashSet<Integer>> col = new HashMap<>();
        Set<Integer> row = new HashSet<>();
        boolean hasDuplicate = false;
        boolean[] column = new boolean[n];

        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (row.contains(matrix[i][j])) {
                   hasDuplicate = true;
               }
               row.add(matrix[i][j]);
               if (col.get(j) == null) {
                   col.put(j, new HashSet<>());

               }
               if (col.get(j).contains(matrix[i][j])) {
                   column[j] = true;
               }

               col.get(j).add(matrix[i][j]);

            }
            if (hasDuplicate) {
                result[1]++;
            }
            hasDuplicate = false;
            row = new HashSet<>();
        }

        for (boolean b : column) {
            if (b) result[2]++;
        }

        return result;
    }

}
