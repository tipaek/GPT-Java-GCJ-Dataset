import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int c = 0; c < cases; c++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for (int l = 0; l < n; l++) {
                String line = br.readLine();
                String[] arr = line.split(" ", n);
                for (int a = 0; a < arr.length; a++) {
                    matrix[l][a] = Integer.parseInt(arr[a]);
                }
            }
            System.out.println("Case #" + (c + 1) + ": " + getResult(matrix, n));
        }
    }

    public static String getResult(int[][] matrix, int n) {
        Set<Integer>[] rowSet = new Set[n];
        Set<Integer>[] columnSet = new Set[n];
        int fullrows = 0;
        int fullcolumns = 0;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    trace += matrix[i][j];
                if (rowSet[i] == null) {
                    rowSet[i] = new HashSet<>();
                }
                rowSet[i].add(matrix[i][j]);
                if (rowSet[i].size() == n) {
                    fullrows += 1;
                }

                if (columnSet[j] == null) {
                    columnSet[j] = new HashSet<>();
                }
                columnSet[j].add(matrix[i][j]);
                if (columnSet[j].size() == n) {
                    fullcolumns += 1;
                }
            }
        }
        return trace + " " + (n - fullrows) + " " + (n - fullcolumns);

    }
}