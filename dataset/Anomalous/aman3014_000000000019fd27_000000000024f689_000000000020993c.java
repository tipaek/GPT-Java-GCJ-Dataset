import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CodeJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            
            int duplicateRows = 0, duplicateColumns = 0, trace = 0;
            
            // Reading matrix and calculating duplicate rows
            for (int row = 0; row < matrixSize; row++) {
                ArrayList<Integer> currentRow = new ArrayList<>();
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    currentRow.add(value);
                    
                    if (!rowHasDuplicates && !rowSet.add(value)) {
                        duplicateRows++;
                        rowHasDuplicates = true;
                    }
                }
                matrix.add(currentRow);
            }
            
            // Calculating duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix.get(row).get(col);
                    
                    if (!colHasDuplicates && !colSet.add(value)) {
                        duplicateColumns++;
                        colHasDuplicates = true;
                    }
                }
            }
            
            // Calculating trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix.get(i).get(i);
            }
            
            System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, duplicateRows, duplicateColumns);
        }
        
        scanner.close();
    }
}