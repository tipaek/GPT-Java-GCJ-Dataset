import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int[][] mat = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = in.nextInt();
                    }
                }
                checkMatrix(mat);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void checkMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            System.out.println("0 0 0");
            return;
        }
        
        int n = mat.length;
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(mat[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(mat[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }
}