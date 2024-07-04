import java.io.*;
import java.util.*;

class Solution {

    public static void solve(String[][] matrix, int caseNumber) {
        int n = matrix.length;
        int trace = 0, rowCount = 0, colCount = 0;
        Hashtable<String, Integer>[] columnHashTables = new Hashtable[n];
        boolean[] colFlags = new boolean[n];
        Arrays.fill(colFlags, false);

        for (int i = 0; i < n; i++) {
            Hashtable<String, Integer> rowHashTable = new Hashtable<>();
            boolean rowFlag = false;

            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    columnHashTables[j] = new Hashtable<>();
                }

                if (i == j) {
                    trace += Integer.parseInt(matrix[i][j]);
                }

                if (!rowHashTable.containsKey(matrix[i][j])) {
                    rowHashTable.put(matrix[i][j], 1);
                } else {
                    rowFlag = true;
                }

                if (!columnHashTables[j].containsKey(matrix[i][j])) {
                    columnHashTables[j].put(matrix[i][j], 1);
                } else {
                    if (!colFlags[j]) {
                        colFlags[j] = true;
                        colCount++;
                    }
                }
            }

            if (rowFlag) {
                rowCount++;
            }
        }
        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int t = 1; t <= T; t++) {
                int n = Integer.parseInt(br.readLine());
                String[][] matrix = new String[n][];
                for (int i = 0; i < n; i++) {
                    matrix[i] = br.readLine().split(" ");
                }
                solve(matrix, t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}