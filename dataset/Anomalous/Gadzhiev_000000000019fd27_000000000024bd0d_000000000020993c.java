import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            processMatrix(scanner, caseNumber);
        }
    }

    private static void processMatrix(Scanner scanner, int caseNumber) {
        int matrixSize = scanner.nextInt();
        int trace = 0;
        Map<Integer, Set<Integer>> rowSets = new HashMap<>();
        Map<Integer, Set<Integer>> columnSets = new HashMap<>();
        
        for (int i = 0; i < matrixSize; i++) {
            rowSets.put(i, new HashSet<>());
            columnSets.put(i, new HashSet<>());
        }

        for (int i = 0; i < matrixSize; ++i) {
            Set<Integer> currentRowSet = rowSets.get(i);
            for (int j = 0; j < matrixSize; ++j) {
                int element = scanner.nextInt();
                currentRowSet.add(element);
                columnSets.get(j).add(element);
                if (i == j) {
                    trace += element;
                }
            }
        }

        long duplicateRows = rowSets.values().stream().filter(set -> set.size() < matrixSize).count();
        long duplicateColumns = columnSets.values().stream().filter(set -> set.size() < matrixSize).count();
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}