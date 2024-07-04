import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcase = 1;
        in.nextLine();
        while (in.hasNextLine()) {
            int repeatedRows = 0;
            int repeatedCols = 0;
            int trace = 0;
            final Integer matrixSize = Integer.valueOf(in.nextLine());
            Map<String, Set<String>> colRowMap = new HashMap<>();
            int traceIndex = 0;
            final int[] containsColDup = new int[matrixSize];
            for (int r = 0; r < matrixSize; r++) {
                final String start = in.nextLine();
                final String[] values = start.split(" ");
                trace += Integer.valueOf(values[traceIndex]);
                boolean containsRowDup = false;
                for (int c = 0; c < values.length; c++) {
                    if (!containsRowDup) {
                        final String rowKey = "r" + r;
                        if (colRowMap.containsKey(rowKey) && colRowMap.get(rowKey).contains(values[c])) {
                            repeatedRows++;
                            containsRowDup = true;
                        } else {
                            if (colRowMap.containsKey(rowKey)) {
                                colRowMap.get(rowKey).add(values[c]);
                            } else {
                                final Set<String> objects = new HashSet<>();
                                objects.add(values[c]);
                                colRowMap.put(rowKey, objects);
                            }
                        }
                    }
                    if (containsColDup[c] != 1) {
                        final String colKey = "c" + c;
                        if (colRowMap.containsKey(colKey) && colRowMap.get(colKey).contains(values[c])) {
                            repeatedCols++;
                            containsColDup[c] = 1;
                        } else {
                            if (colRowMap.containsKey(colKey)) {
                                colRowMap.get(colKey).add(values[c]);
                            } else {
                                final Set<String> objects = new HashSet<>();
                                objects.add(values[c]);
                                colRowMap.put(colKey, objects);
                            }
                        }
                    }
                }
                traceIndex++;
            }

            System.out.println("Case #" + testcase + ": " + trace + ' ' + repeatedRows + ' ' + repeatedCols);
            testcase++;
        }
    }
}
