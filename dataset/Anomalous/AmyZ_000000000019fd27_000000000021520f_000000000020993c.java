import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;

            for (int row = 0; row < n; row++) {
                String[] values = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int col = 0; col < n; col++) {
                    int number = Integer.parseInt(values[col]);

                    if (row == col) {
                        trace += number;
                    }

                    if (!hasDuplicateInRow && rowSet.contains(number)) {
                        hasDuplicateInRow = true;
                        duplicateRows++;
                    }

                    rowSet.add(number);
                    columnMap.computeIfAbsent(col, k -> new HashSet<>()).add(number);
                }
            }

            for (int col = 0; col < n; col++) {
                if (columnMap.get(col).size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}