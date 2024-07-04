import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            
            int rowDuplicates = 0, colDuplicates = 0, trace = 0;
            
            for (int row = 0; row < n; row++) {
                ArrayList<Integer> currentRow = new ArrayList<>();
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    currentRow.add(value);
                    
                    if (!rowHasDuplicate && !rowSet.add(value)) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
                
                matrix.add(currentRow);
            }
            
            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                
                for (int row = 0; row < n; row++) {
                    int value = matrix.get(row).get(col);
                    
                    if (!colHasDuplicate && !colSet.add(value)) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                trace += matrix.get(i).get(i);
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowDuplicates, colDuplicates);
        }
        
        scanner.close();
    }
}