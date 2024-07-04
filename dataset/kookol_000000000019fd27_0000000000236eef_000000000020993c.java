import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        int trace = 0, repeatedRow = 0, repeatedCol = 0, r = 0, c = 0;
        Set <Integer> rowSet = new HashSet<>();
        Set <Integer> colSet = new HashSet<>();

        for (int s = 1; s <= t; ++s) {
            int n = in.nextInt();
            int [][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();

                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (rowSet.contains(matrix[i][j])) {
                        repeatedRow++;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }
                }
                if(repeatedRow > 0) {
                    r++;
                }
                repeatedRow = 0;
                rowSet.clear();

            }
            for(int p = 0; p < n; p++) {
                for (int k = 0; k < n; k++) {

                    if (colSet.contains(matrix[k][p])) {
                        repeatedCol++;
                    } else {
                        colSet.add(matrix[k][p]);
                    }
                }
                if (repeatedCol > 0) {
                    c++;
                }
                repeatedCol = 0;
                colSet.clear();
            }

            System.out.println("Case #" + s + ": " + trace + " " + r + " " + c);
            rowSet.clear();
            colSet.clear();
            r = 0;
            c = 0;
            trace = 0;
        }
    }
}