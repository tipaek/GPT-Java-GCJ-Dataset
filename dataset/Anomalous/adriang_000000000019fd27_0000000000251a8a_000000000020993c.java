import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int repeatedRowsCount = 0;
            int repeatedColumnsCount = 0;
            Set<Integer> columnElements = new HashSet<>();
            Map<Integer, Boolean> duplicateColumnsMap = new HashMap<>();
            scanner.nextLine();

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowElements = new HashSet<>();
                String[] rowValues = scanner.nextLine().split("\\s");
                trace += Integer.parseInt(rowValues[row]);

                boolean duplicateInRow = false;
                for (int col = 0; col < rowValues.length; col++) {
                    int element = Integer.parseInt(rowValues[col]);

                    if (rowElements.contains(element) && !duplicateInRow) {
                        repeatedRowsCount++;
                        duplicateInRow = true;
                    }
                    rowElements.add(element);

                    int colElementKey = col * 100 + element;
                    if (columnElements.contains(colElementKey) && !duplicateColumnsMap.containsKey(col)) {
                        repeatedColumnsCount++;
                        duplicateColumnsMap.put(col, true);
                    }
                    columnElements.add(colElementKey);
                }
            }

            System.out.println();
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRowsCount + " " + repeatedColumnsCount);
        }
    }
}