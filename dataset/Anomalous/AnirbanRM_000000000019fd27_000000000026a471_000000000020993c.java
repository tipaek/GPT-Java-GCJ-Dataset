import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] colSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    colSets[j].add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : colSets) {
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            result.append("Case #").append(t).append(": ").append(trace).append(" ")
                  .append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }

        System.out.print(result);
    }
}