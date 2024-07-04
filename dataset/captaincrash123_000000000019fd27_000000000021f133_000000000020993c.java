import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new File("output.out"));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int duplicateRows[] = new int[n];
            int duplicateColumns[] = new int[n];
            int trace = 0;

            for (int j = 0; j < n; j++) {
                int[] rowCounter = new int[n];
                boolean goodRow = true;
                boolean continueRow = true;
                for (int k = 0; k < n && continueRow; k++) {
                    rowCounter[matrix[j][k] - 1] = rowCounter[matrix[j][k] - 1] + 1;
                    if (rowCounter[matrix[j][k] - 1] > 1) {
                        goodRow = false;
                    }
                    if (k == j) {
                        trace = trace + matrix[j][k]; 
                    }
                    if (!goodRow && k >= j) {
                        continueRow = false;
                        duplicateRows[j] = 1;
                    }
                }

                int[] columnCounter = new int[n];
                boolean goodColumn = true;
                for (int k = 0; k < n && goodColumn; k++) {
                    columnCounter[matrix[k][j] - 1] = columnCounter[matrix[k][j] - 1] + 1;
                    if (columnCounter[matrix[k][j] - 1] > 1) {
                        goodColumn = false;
                        duplicateColumns[j] = 1;
                    }
                }
            }

            int numRows = 0;
            int numColumns = 0;

            for (int j = 0; j < n; j++) {
                if (duplicateRows[j] == 1) {
                    numRows = numRows + 1;
                }
                if (duplicateColumns[j] == 1) {
                    numColumns = numColumns + 1;
                }
            }
            System.out.print("Case #");
            System.out.print(i + 1);
            System.out.print(": ");
            System.out.print(trace);
            System.out.print(" ");
            System.out.print(numRows);
            System.out.print(" ");
            System.out.println(numColumns);
        }
        in.close();
        out.close();
        
    }
      
}