import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i);
        }
    }

    private static void processCase(int caseNumber) {
        int n = scanner.nextInt();
        int trace = 0, duplicateRows = 0, duplicateColumns = 0;
        HashSet<Integer>[] rows = new HashSet[n];
        HashSet<Integer>[] columns = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    trace += value;
                }
                rows[i].add(value);
                columns[j].add(value);
            }
        }

        for (HashSet<Integer> row : rows) {
            if (row.size() < n) {
                duplicateRows++;
            }
        }

        for (HashSet<Integer> column : columns) {
            if (column.size() < n) {
                duplicateColumns++;
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", caseNumber, trace, duplicateRows, duplicateColumns);
    }
}