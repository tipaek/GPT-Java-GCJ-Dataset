import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                // Read matrix and calculate trace
                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicates = false;
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                        if (!rowSet.add(matrix[i][j])) {
                            rowHasDuplicates = true;
                        }
                    }
                    if (rowHasDuplicates) {
                        rowDuplicates++;
                    }
                }

                // Check for column duplicates
                for (int j = 0; j < n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    boolean colHasDuplicates = false;
                    for (int i = 0; i < n; i++) {
                        if (!colSet.add(matrix[i][j])) {
                            colHasDuplicates = true;
                        }
                    }
                    if (colHasDuplicates) {
                        colDuplicates++;
                    }
                }

                System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}