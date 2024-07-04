import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            processTestCase(caseNumber, matrixSize);
        }
    }

    private static void processTestCase(int caseNumber, int matrixSize) {
        Set<Integer>[] rowSets = new Set[matrixSize];
        Set<Integer>[] columnSets = new Set[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
        }

        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateColumns = new HashSet<>();
        int trace = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();
                if (!rowSets[i].add(value)) {
                    duplicateRows.add(i);
                }
                if (!columnSets[j].add(value)) {
                    duplicateColumns.add(j);
                }
                if (i == j) {
                    trace += value;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows.size(), duplicateColumns.size());
    }
}