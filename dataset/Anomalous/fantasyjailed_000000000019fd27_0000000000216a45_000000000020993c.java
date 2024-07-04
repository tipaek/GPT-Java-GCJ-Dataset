import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            List<Set<Integer>> columnSets = IntStream.range(0, matrixSize)
                                                     .mapToObj(i -> new HashSet<Integer>())
                                                     .collect(Collectors.toList());

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);
                    columnSets.get(col).add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() != matrixSize) {
                    repeatedRows++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() != matrixSize) {
                    repeatedColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedRows, repeatedColumns);
        }
    }
}