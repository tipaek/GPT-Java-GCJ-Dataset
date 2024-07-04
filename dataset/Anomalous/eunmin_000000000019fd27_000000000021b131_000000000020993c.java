import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            List<Set<Integer>> columnSets = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }
            
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowSet.add(value);
                    columnSets.get(col).add(value);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }
            
            for (Set<Integer> colSet : columnSets) {
                if (colSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}