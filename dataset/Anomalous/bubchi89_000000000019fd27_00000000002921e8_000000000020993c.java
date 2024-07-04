import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            processTestCase(i, matrixSize, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, int matrixSize, Scanner scanner) {
        int trace = 0;
        List<Set<Integer>> rowSets = IntStream.range(0, matrixSize)
                                              .mapToObj(i -> new HashSet<Integer>(matrixSize))
                                              .collect(Collectors.toList());
        List<Set<Integer>> colSets = IntStream.range(0, matrixSize)
                                              .mapToObj(i -> new HashSet<Integer>(matrixSize))
                                              .collect(Collectors.toList());

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int value = scanner.nextInt();
                rowSets.get(row).add(value);
                colSets.get(col).add(value);
                if (row == col) {
                    trace += value;
                }
            }
        }

        long brokenRowsCount = rowSets.stream().filter(set -> set.size() < matrixSize).count();
        long brokenColsCount = colSets.stream().filter(set -> set.size() < matrixSize).count();

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, brokenRowsCount, brokenColsCount);
    }
}