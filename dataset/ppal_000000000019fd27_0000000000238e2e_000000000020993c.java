import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int testCases = in.nextInt();
            for (int cases = 0; cases < testCases; cases++) {
                int n = in.nextInt();
                int trace = 0;
                int duplicateRows = 0;
                int duplicateCols = 0;
                Set<Integer> duplicateRow = new HashSet<>();
                Set<Integer> duplicateCol = new HashSet<>();
                int matrix[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = in.nextInt();
                        if(i == j) {
                            trace += matrix[i][j];
                        }
                        duplicateRow.add(matrix[i][j]);
                    }
                    if(duplicateRow.size() < n) {
                        ++duplicateRows;
                    }
                    duplicateRow.clear();
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        duplicateCol.add(matrix[k][j]);
                    }
                    if(duplicateCol.size() < n) {
                        ++duplicateCols;
                    }
                    duplicateCol.clear();
                }
                System.out.println("Case #"+(cases+1)+": "+trace+" "+duplicateRows+" "+duplicateCols);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
