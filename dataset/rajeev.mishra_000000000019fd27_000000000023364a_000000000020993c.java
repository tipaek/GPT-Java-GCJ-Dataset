
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int noTestCases = in.nextInt();
            for (int i = 0; i < noTestCases; i++) {
                int n = in.nextInt();
                int trace = 0;
                int duplicateRows = 0;
                int duplicateColumns = 0;
                Set<Integer> duplicateRow = new HashSet<>();
                Set<Integer> duplicateColumn = new HashSet<>();
                int mat[][] = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        mat[j][k] = in.nextInt();
                        if(j == k) {
                            trace += mat[j][k];
                        }
                        duplicateRow.add(mat[j][k]);
                    }
                    if(duplicateRow.size() < n) {
                        ++duplicateRows;
                    }
                    duplicateRow.clear();
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        duplicateColumn.add(mat[k][j]);
                    }
                    if(duplicateColumn.size() < n) {
                        ++duplicateColumns;
                    }
                    duplicateColumn.clear();
                }
                System.out.println("Case #"+(i+1)+": "+trace+" "+duplicateRows+" "+duplicateColumns);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
