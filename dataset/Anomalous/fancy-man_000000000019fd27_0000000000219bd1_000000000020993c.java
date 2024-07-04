package c2020;

import java.util.*;
import java.io.*;

public class VE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            
            int[][] matrix = new int[n][n];
            int[][] colBounds = new int[2][n];
            int[][] rowBounds = new int[2][n];
            
            Arrays.fill(colBounds[0], n);
            Arrays.fill(colBounds[1], 1);
            Arrays.fill(rowBounds[0], n);
            Arrays.fill(rowBounds[1], 1);
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int cell = Integer.parseInt(tokens[j]);
                    matrix[i][j] = cell;
                    
                    colBounds[0][j] = Math.min(colBounds[0][j], cell);
                    colBounds[1][j] = Math.max(colBounds[1][j], cell);
                    rowBounds[0][i] = Math.min(rowBounds[0][i], cell);
                    rowBounds[1][i] = Math.max(rowBounds[1][i], cell);
                }
                trace += matrix[i][i];
            }
            
            int colDiff = 0, rowDiff = 0;
            for (int i = 0; i < n; i++) {
                if (colBounds[0][i] > 1 || colBounds[1][i] < n) colDiff++;
                if (rowBounds[0][i] > 1 || rowBounds[1][i] < n) rowDiff++;
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDiff + " " + colDiff);
        }
    }
}