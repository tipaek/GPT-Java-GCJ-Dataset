import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] colSets = new HashSet[n];

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(row[j]);
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }

                    if (!rowSets[i].add(value)) {
                        repeatRows++;
                        rowSets[i].clear();  // Clear to prevent double counting
                    }

                    if (!colSets[j].add(value)) {
                        repeatCols++;
                        colSets[j].clear();  // Clear to prevent double counting
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatRows + " " + repeatCols);
        }
    }
}