import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(scanner, testCase);
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        int matrixSize = scanner.nextInt();
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        Map<Integer, Set<Integer>> rowValues = new HashMap<>();
        Map<Integer, Set<Integer>> columnValues = new HashMap<>();

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int value = scanner.nextInt();
                if (row == col) {
                    trace += value;
                }
                addValueToMap(rowValues, row, value);
                addValueToMap(columnValues, col, value);
            }
        }

        repeatedRows = countRepeatedEntries(rowValues, matrixSize);
        repeatedColumns = countRepeatedEntries(columnValues, matrixSize);

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    private static void addValueToMap(Map<Integer, Set<Integer>> map, int key, int value) {
        map.computeIfAbsent(key, k -> new HashSet<>()).add(value);
    }

    private static int countRepeatedEntries(Map<Integer, Set<Integer>> map, int expectedSize) {
        int repeatedCount = 0;
        for (Set<Integer> values : map.values()) {
            if (values.size() != expectedSize) {
                repeatedCount++;
            }
        }
        return repeatedCount;
    }
}