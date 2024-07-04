import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int testCaseNum = 0;
        while (t-- > 0) {
            testCaseNum += 1;
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int r = 0;
            int c = 0;
            HashMap<Integer, Boolean> occured = new HashMap();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // System.out.println(n + " " + i + " " + j + " " + matrix[i][j]);
                    if (occured.get(matrix[i][j]) != null) {
                        r += 1;
                        break;
                    } else {
                        occured.put(matrix[i][j], true);
                    }
                }
                occured.clear();
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (occured.get(matrix[i][j]) != null) {
                        c += 1;
                        break;
                    } else {
                        occured.put(matrix[i][j], true);
                    }
                }
                occured.clear();
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            System.out.println("Case #" + testCaseNum + ": " + trace + " " + r + " " + c);
        }
    }
}