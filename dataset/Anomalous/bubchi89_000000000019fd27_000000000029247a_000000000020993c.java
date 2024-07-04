import java.util.*;
import java.io.*;

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
        List<Set<Integer>> rowSets = new ArrayList<>(matrixSize);
        List<Set<Integer>> colSets = new ArrayList<>(matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            rowSets.add(new HashSet<>(matrixSize));
            colSets.add(new HashSet<>(matrixSize));
        }

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

        long brokenRows = rowSets.stream().filter(set -> set.size() < matrixSize).count();
        long brokenCols = colSets.stream().filter(set -> set.size() < matrixSize).count();

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, brokenRows, brokenCols);
    }
}