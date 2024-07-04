import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = in.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] colSets = new HashSet[n];

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = in.nextInt();
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    rowSets[i].add(value);
                    colSets[j].add(value);
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowSets[i].size() != n) {
                    duplicateRows++;
                }
                if (colSets[i].size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}