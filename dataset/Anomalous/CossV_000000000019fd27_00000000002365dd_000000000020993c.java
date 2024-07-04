import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            Map<Integer, Set<Integer>> columnElements = new HashMap<>();
            for (int col = 0; col < matrixSize; col++) {
                columnElements.put(col, new HashSet<>());
            }
            
            for (int row = 0; row < matrixSize; row++) {
                String[] rowElements = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                
                for (int col = 0; col < matrixSize; col++) {
                    int element = Integer.parseInt(rowElements[col]);
                    rowSet.add(element);
                    columnElements.get(col).add(element);
                    
                    if (row == col) {
                        trace += element;
                    }
                    
                    if (row == matrixSize - 1 && columnElements.get(col).size() < matrixSize) {
                        duplicateCols++;
                    }
                }
                
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}