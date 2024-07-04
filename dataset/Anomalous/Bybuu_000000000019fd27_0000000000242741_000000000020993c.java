import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            boolean[] columnHasDuplicates = new boolean[matrixSize];
            HashSet<Integer>[] columnSets = new HashSet[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }
            
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int number = scanner.nextInt();
                    
                    if (i == j) {
                        trace += number;
                    }
                    
                    if (!rowSet.add(number)) {
                        rowHasDuplicates = true;
                    }
                    
                    if (!columnSets[j].add(number)) {
                        if (!columnHasDuplicates[j]) {
                            colDuplicates++;
                            columnHasDuplicates[j] = true;
                        }
                    }
                }
                
                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}