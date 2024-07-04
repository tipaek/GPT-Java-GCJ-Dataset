import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            Integer matrixSize = Integer.parseInt(in.nextLine());
            Set<Integer> rowsWithDuplicates = new HashSet<>();
            Set<Integer> colsWithDuplicates = new HashSet<>();
            Integer matrixTrace = 0;

            // read row x N times
            Map<Integer, Set<Integer>> rows = new HashMap<>();
            Map<Integer, Set<Integer>> columns = new HashMap<>();
            for (int row = 0; row < matrixSize; row++) {
                String line = in.nextLine();
                String rowElements[] = line.split(" ");

                for (int col = 0; col < matrixSize; col++) {
                    Integer element = Integer.parseInt(rowElements[col]);

                    // calculate trace
                    if (row == col) {
                        matrixTrace += element;
                    }

                    // check if this element is a duplicate in a row
                    if (rows.keySet().contains(row) && rows.get(row).contains(element)) {
                        rowsWithDuplicates.add(row);
                    }

                    if (columns.keySet().contains(col) && columns.get(col).contains(element)) {
                        colsWithDuplicates.add(col);
                    }

                    // add new element to rows
                    if (!rows.keySet().contains(row)) {
                        rows.put(row, new HashSet<>(element));
                        rows.get(row).add(element);
                    } else {
                        rows.get(row).add(element);
                    }

                    // add new element to columns
                    if (!columns.keySet().contains(col)) {
                        columns.put(col, new HashSet<>());
                        columns.get(col).add(element);
                    } else {
                        columns.get(col).add(element);
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + matrixTrace + " " + rowsWithDuplicates.size() + " " + colsWithDuplicates.size());
        }
    }
}
