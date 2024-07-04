import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        if (testCases >= 1 && testCases <= 100) {
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();

                if (n >= 2 && n <= 100) {
                    int[][] matrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }

                    int trace = 0, rowRepeats = 0, colRepeats = 0;

                    for (int i = 0; i < n; i++) {
                        trace += matrix[i][i];
                    }

                    for (int i = 0; i < n; i++) {
                        Set<Integer> rowSet = new HashSet<>();
                        Set<Integer> colSet = new HashSet<>();
                        for (int j = 0; j < n; j++) {
                            if (!rowSet.add(matrix[i][j])) {
                                rowRepeats++;
                                break;
                            }
                        }
                        for (int j = 0; j < n; j++) {
                            if (!colSet.add(matrix[j][i])) {
                                colRepeats++;
                                break;
                            }
                        }
                    }

                    System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
                }
            }
        }
    }
}