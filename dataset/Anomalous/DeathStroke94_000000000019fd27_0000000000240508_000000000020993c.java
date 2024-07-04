import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(temp[j]);
                }
            }
            checkMatrix(mat, n, testCase);
        }
    }

    static void checkMatrix(int[][] mat, int n, int caseNo) {
        int sum = 0, duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
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

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}