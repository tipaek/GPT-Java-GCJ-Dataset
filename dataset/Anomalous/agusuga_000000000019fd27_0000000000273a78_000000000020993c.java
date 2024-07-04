import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            int[][] matrix = new int[size][size];
            Set<Integer>[] columnSets = new HashSet[size];
            for (int j = 0; j < size; j++) {
                columnSets[j] = new HashSet<>();
            }

            for (int j = 0; j < size; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowDup = false;

                for (int k = 0; k < size; k++) {
                    int currentVal = scanner.nextInt();
                    matrix[j][k] = currentVal;

                    if (j == k) {
                        trace += currentVal;
                    }

                    if (!rowSet.add(currentVal) && !rowDup) {
                        repeatedRows++;
                        rowDup = true;
                    }

                    if (!columnSets[k].add(currentVal)) {
                        repeatedColumns++;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}