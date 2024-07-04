import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int matrixSize = input.nextInt();
            
            boolean[] columnDuplicates = new boolean[matrixSize];
            List<Set<Integer>> columns = new ArrayList<>(matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                columns.add(new HashSet<>());
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> row = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    int element = input.nextInt();
                    if (!row.add(element)) rowHasDuplicate = true;
                    if (!columns.get(j).add(element)) columnDuplicates[j] = true;
                    if (i == j) trace += element;
                }
                if (rowHasDuplicate) duplicateRows++;
            }
            
            for (boolean hasDuplicate : columnDuplicates) {
                if (hasDuplicate) duplicateColumns++;
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateColumns);
        }
    }
}