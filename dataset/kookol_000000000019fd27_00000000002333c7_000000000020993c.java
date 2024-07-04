import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        int trace = 0, repeatedRow = 0, repeatedCol = 0;
        Set <Integer> rowSet = new HashSet<>();
        Set <Integer> colSet = new HashSet<>();

        for (int s = 1; s <= t; ++s) {
            int n = in.nextInt();
            int [][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (colSet.contains(matrix[j][i])) {
                        repeatedCol ++;
                    } else {
                        colSet.add(matrix[j][i]);
                    }
                    if (rowSet.contains(matrix[i][j])) {
                        repeatedRow++;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }
                }
            }

            System.out.println("Case #" + s + ": " + trace + " " + repeatedRow + " " + repeatedCol);
            rowSet.clear();
            colSet.clear();
        }
    }
}