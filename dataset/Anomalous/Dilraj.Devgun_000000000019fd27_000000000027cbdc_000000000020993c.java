import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            processTestCase(scanner, n + 1);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int[] matrix = new int[size * size];
        for (int i = 0; i < size * size; i++) {
            matrix[i] = scanner.nextInt();
        }

        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        Set<Integer> rowSet = new HashSet<>();
        Map<Integer, Set<Integer>> columnSets = new HashMap<>();

        for (int idx = 0; idx < size * size; idx++) {
            int row = idx / size;
            int col = idx % size;

            if (row == col) {
                trace += matrix[idx];
            }

            if (col == 0) {
                rowSet.clear();
            }

            if (!rowSet.add(matrix[idx])) {
                repeatedRows++;
                rowSet.clear();
                rowSet.add(matrix[idx]);
            }

            columnSets.computeIfAbsent(col, k -> new HashSet<>()).add(matrix[idx]);
        }

        for (Set<Integer> colSet : columnSets.values()) {
            if (colSet.size() < size) {
                repeatedColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }
}