import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int caseNo = 1; caseNo <= t; caseNo++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            evaluateMatrix(matrix, n, caseNo);
        }
    }

    private static void evaluateMatrix(int[][] matrix, int n, int caseNo) {
        int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;
        
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }
        
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }
        
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                colRepeats++;
            }
        }
        
        System.out.println("Case #" + caseNo + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
    }

    private static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, true);
        }
        return false;
    }
}