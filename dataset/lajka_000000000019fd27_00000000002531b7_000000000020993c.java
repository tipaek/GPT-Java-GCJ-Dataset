package code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Integer numberOfTestCases = Integer.parseInt(stdin.readLine());

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            Integer matrixSize = Integer.parseInt(stdin.readLine());
            Set<Integer> rowsWithDuplicates = new HashSet<>();
            Set<Integer> colsWithDuplicates = new HashSet<>();
            Integer matrixTrace = 0;

            // read row x N times
            Map<Integer, Set<Integer>> rows = new HashMap<>();
            Map<Integer, Set<Integer>> columns = new HashMap<>();
            for (int row = 0; row < matrixSize; row++) {
                String line = stdin.readLine();
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
