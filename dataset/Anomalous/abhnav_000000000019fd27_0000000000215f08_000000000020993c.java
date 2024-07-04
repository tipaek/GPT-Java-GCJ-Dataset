import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();
        for (int count = 0; count < t; count++) {
            int n = scn.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scn.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }

                    colMap.putIfAbsent(j, new HashSet<>());
                    HashSet<Integer> colSet = colMap.get(j);
                    if (!colSet.add(matrix[i][j])) {
                        duplicateCols++;
                    }
                }
            }
            System.out.println("Case #" + (count + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}