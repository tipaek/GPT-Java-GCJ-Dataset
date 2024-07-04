import java.util.*;

class Solution {
 
    public static void main (String args[]) {
        
        Scanner scanner = new Scanner (System.in);
        int t = scanner.nextInt ();
        
        for (int c = 0; c < t; c++) {
            int len = scanner.nextInt ();
            int [][] matrix = new int [len][len];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            for (int i = 0; i < len; i++) {
                boolean isRepeated = false;
                HashSet <Integer> currentRow = new HashSet <> ();
                for (int j = 0; j < len; j++) {
                    matrix [i][j] = scanner.nextInt ();
                    if (i == j) trace += matrix [i][j];
                    if (currentRow.contains (matrix [i][j])
                        && !isRepeated) {
                        isRepeated = !isRepeated;
                        rows++;
                    }
                    currentRow.add (matrix [i][j]);
                }
            }
            
            for (int i = 0; i < len; i++) {
                boolean isRepeated = false;
                HashSet <Integer> currentCol = new HashSet <> ();
                for (int j = 0; j < len; j++) {
                    if (currentCol.contains (matrix [j][i])
                        && !isRepeated) {
                        isRepeated = !isRepeated;
                        cols++;
                    }
                    currentCol.add (matrix [j][i]);
                }
            }
            System.out.println (
                "Case #" +c + ": " + trace + " " + rows + " " + cols
            );
        }
        
        scanner.close ();
        
    }   
    
}