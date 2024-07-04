import java.util.*;

public class Main {

    static Map<Integer, Set<Integer>> columnsMap = new HashMap<>();
    static Map<Integer, Set<Integer>> rowsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int trace = 0;
            Set<Integer> repeatedColumns = new HashSet<>();
            Set<Integer> repeatedRows = new HashSet<>();

            for (int i = 0; i < n; i++) {
                rowsMap.put(i, new HashSet<>());
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    // Initialize column sets on the first row
                    if (i == 0) {
                        columnsMap.put(j, new HashSet<>());
                    }

                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check for repeated values in rows and columns
                    if (rowsMap.get(i).contains(value)) {
                        repeatedRows.add(i);
                    }
                    if (columnsMap.get(j).contains(value)) {
                        repeatedColumns.add(j);
                    }

                    // Add value to the respective row and column sets
                    columnsMap.get(j).add(value);
                    rowsMap.get(i).add(value);
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber++, trace, repeatedRows.size(), repeatedColumns.size());
        }
    }
}