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
            processMatrix(mat, n, caseNo);
        }
    }

    static void processMatrix(int[][] mat, int n, int caseNo) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(mat[i])) {
                rowRepeats++;
            }
        }

        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = mat[i][j];
            }
            if (hasDuplicates(col)) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + caseNo + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}