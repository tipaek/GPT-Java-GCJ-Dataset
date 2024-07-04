import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
            int n = in.nextInt();
//            int m = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;
            boolean rowFlag = false, colFlag = false;
            //Solution
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();

                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                boolean[] foundRow = new boolean[n];
                boolean[] foundCol = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (foundRow[matrix[i][j] - 1]) {
                        rowFlag = true;
                    }
                    foundRow[matrix[i][j] - 1] = true;

                    if (foundCol[matrix[j][i] - 1]) {
                        colFlag = true;
                    }
                    foundCol[matrix[j][i] - 1] = true;
                }
                if (rowFlag) rowCount++;
                if (colFlag) colCount++;
                rowFlag = false;
                colFlag = false;
                foundRow = new boolean[n];
                foundCol = new boolean[n];
            }


            //Result
            System.out.println("Case #" + loops + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}