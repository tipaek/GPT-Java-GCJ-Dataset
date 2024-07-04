import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int caseNo = 1; caseNo <= t; caseNo++) {
            int n = Integer.parseInt(br.readLine());
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(temp[j]);
                }
            }
            checkMatrix(mat, n, caseNo);
        }
    }

    static void checkMatrix(int[][] mat, int n, int caseNo) {
        int sum = 0, duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(mat[i])) {
                duplicateRows++;
            }
        }

        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = mat[i][j];
            }
            if (hasDuplicates(col)) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + caseNo + ": " + sum + " " + duplicateRows + " " + duplicateCols);
    }

    static boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}