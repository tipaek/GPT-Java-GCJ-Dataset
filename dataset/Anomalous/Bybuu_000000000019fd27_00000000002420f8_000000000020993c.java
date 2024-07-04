import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            boolean[] colHasDuplicates = new boolean[matrixSize];
            Set<Integer>[] colSets = new HashSet[matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int number = scanner.nextInt();
                    
                    if (i == j) {
                        trace += number;
                    }
                    
                    if (!rowSet.add(number)) {
                        rowHasDuplicate = true;
                    }
                    
                    if (!colSets[j].add(number) && !colHasDuplicates[j]) {
                        colDuplicates++;
                        colHasDuplicates[j] = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}