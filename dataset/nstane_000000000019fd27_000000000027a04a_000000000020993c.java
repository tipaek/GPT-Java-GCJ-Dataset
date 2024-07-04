package google.codejam;

import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String testInput = scanner.nextLine();

        int testCases = Integer.parseInt(testInput);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());

            int rows = 0;
            int columns = 0;
            int trace = 0;

            Set[] columnSet = new Set[n];

            initSet(n, columnSet);

            for (int i = 0; i < n; i++) {
                boolean duplicateRow = false;
                testInput = scanner.nextLine();

                String[] testDataArray = testInput.split(" ");

                Set<Integer> set = new HashSet<>(n);

                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(testDataArray[j]);

                    if (i == j)
                        trace += input;

                    if (!duplicateRow) {
                        if (set.contains(input)) {
                            rows++;
                            duplicateRow = true;
                        } else {
                            set.add(input);
                        }
                    }

                    if (columnSet[j] != null) {

                        if (columnSet[j].contains(input)) {
                            columns++;
                            columnSet[j] = null;
                        } else {
                            columnSet[j].add(input);
                        }
                    }
                }
            }
            out.println("Case #" + testCase + ": " + trace + " " + rows + " " + columns);
        }

        scanner.close();

    }

    private static void initSet(int n, Set[] columnSet) {
        for (int j = 0; j < n; j++)
            columnSet[j] = new HashSet<Integer>(n);
    }
}
