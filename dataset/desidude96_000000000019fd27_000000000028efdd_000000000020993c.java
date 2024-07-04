import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int size = in.nextInt();
            List<List<Integer>> rows = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size*size; j++) {
                row.add(in.nextInt());
                if (row.size() == size) {
                    rows.add(row);
                    row = new ArrayList<>();
                }
            }
            System.out.println("Case #" + i + ": " + getValueForMatrix(buildMatrix(rows)));
        }
    }

    private static int[][] buildMatrix(List<List<Integer>> rows) {
        int[][] result = new int[rows.size()][rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < row.size(); j++) result[i][j] = row.get(j);
        }
        return result;
    }

    private static String getValueForMatrix(int[][] matrix) {
        int trace = 0;
        int numRows = 0;
        int numCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
                if (i == j) trace += matrix[i][j];
            }
            if (row.size() != matrix.length) numRows++;
            if (col.size() != matrix.length) numCols++;
        }

        return trace + " " + numRows + " " + numCols;
    }
}