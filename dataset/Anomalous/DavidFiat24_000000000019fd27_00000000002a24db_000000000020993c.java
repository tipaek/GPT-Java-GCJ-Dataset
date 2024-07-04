import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int cases = Integer.parseInt(reader.nextLine());
        
        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(reader.nextLine());
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                String[] rowValues = reader.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];
                
                boolean[] rowCheck = new boolean[size + 1];
                boolean[] colCheck = new boolean[size + 1];
                
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int k = 0; k < size; k++) {
                    if (rowCheck[matrix[j][k]]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }
                    
                    if (colCheck[matrix[k][j]]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    repeatedRows++;
                }
                if (colHasDuplicate) {
                    repeatedColumns++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedColumns);
        }
        
        reader.close();
    }
}