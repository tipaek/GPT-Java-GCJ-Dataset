

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalNumberOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= totalNumberOfTestCases; ++testCase) {
            int sizeOfSquareMatrix = in.nextInt();
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
            int[] rowMap;
            int[][] columnMap = new int[sizeOfSquareMatrix + 1][sizeOfSquareMatrix + 1];
            List columnMarked = new ArrayList(sizeOfSquareMatrix);
            List rowMarked = new ArrayList(sizeOfSquareMatrix);
            for (int row = 0; row < sizeOfSquareMatrix; row++) {
                rowMap = new int[sizeOfSquareMatrix + 1];
                for (int column = 0; column < sizeOfSquareMatrix; column++) {
                    int currentValue = in.nextInt();
                    // find trace
                    if (row == column) {
                        trace += currentValue;
                    }
                    // find no of duplicate rows
                    if (!rowMarked.contains(row)) {
                        if (rowMap[currentValue] > 0) {
                            rowDuplicates++;
                            rowMarked.add(row);
                        } else {
                            rowMap[currentValue] = 1;
                        }
                    }
                    // find no of duplicate columns
                    if (!columnMarked.contains(column)) {
                        if (columnMap[currentValue][column] > 0) {
                            columnDuplicates++;
                            columnMarked.add(column);
                        } else {
                            columnMap[currentValue][column] = 1;
                        }
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}
