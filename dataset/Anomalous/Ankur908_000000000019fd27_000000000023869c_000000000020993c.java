import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scan.nextInt();

        for (int k = 0; k < testCases; k++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowFlag = false;
                boolean colFlag = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        sum += matrix[i][j];
                    }

                    if (!rowSet.add(matrix[i][j])) {
                        rowFlag = true;
                    }

                    if (!colSet.add(matrix[j][i])) {
                        colFlag = true;
                    }
                }

                if (rowFlag) {
                    rowDuplicates++;
                }
                if (colFlag) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }

        scan.close();
    }
}