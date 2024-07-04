import java.util.Scanner;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int N = scn.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scn.nextInt();
                }
            }
            
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int j = 0; j < N; j++) {
                    int rowVal = matrix[i][j];
                    int colVal = matrix[j][i];
                    
                    if (!rowSet.add(rowVal)) {
                        rowHasDuplicate = true;
                    }
                    
                    if (!colSet.add(colVal)) {
                        colHasDuplicate = true;
                    }
                    
                    if (i == j) {
                        trace += rowVal;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
                
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scn.close();
    }
}