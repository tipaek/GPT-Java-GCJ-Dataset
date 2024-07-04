import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        // traces max?
        // 100 (n) * 100(n) < int max
        for (int testNum = 1; testNum <= numTests; testNum++) {
            int matrixSize = scanner.nextInt();

            List<Set<Integer>> rowSetList = new ArrayList<>();
            List<Set<Integer>> colSetList = new ArrayList<>();

            for (int i = 0; i < matrixSize; i++) {
                rowSetList.add(new HashSet<>());
                colSetList.add(new HashSet<>());
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            int expectedSum = matrixSize * (1 + matrixSize) / 2;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }
                    rowSetList.get(row).add(value);
                    colSetList.get(col).add(value);
                }
            }

            for (int index = 0; index < matrixSize; index++) {
                Set<Integer> rowSet = rowSetList.get(index);
                Set<Integer> colSet = colSetList.get(index);
                if (rowSet.size() != matrixSize || rowSet.stream().reduce((a, b) -> a + b).get() != expectedSum ) {
                    repeatedRows++;
                }
                if (colSet.size() != matrixSize || colSet.stream().reduce((a, b) -> a + b).get() != expectedSum ) {
                    repeatedCols++;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", testNum, trace, repeatedRows, repeatedCols));
        }
        scanner.close();
    }
}
