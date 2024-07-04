import java.util.*;

public class Solution {

    public static void ref(int[][] matrix, int n, int caseNumber) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() < n) rowRepeats++;
            if (colSet.size() < n) colRepeats++;
        }

        System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowRepeats, colRepeats);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n * n; j++) {
                int row = j / n;
                int col = j % n;
                matrix[row][col] = sc.nextInt();
            }
            
            ref(matrix, n, i);
        }
    }
}