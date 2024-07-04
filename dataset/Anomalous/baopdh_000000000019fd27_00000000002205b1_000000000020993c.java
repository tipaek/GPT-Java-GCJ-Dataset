import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            boolean[][] rowSet = new boolean[n][n];
            boolean[][] colSet = new boolean[n][n];
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    rowSet[i][value - 1] = true;
                    colSet[j][value - 1] = true;
                    if (i == j) {
                        trace += value;
                    }
                }
            }
            
            int rowRepeated = 0;
            int colRepeated = 0;
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet[i][j]) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet[i][j]) {
                        colHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowRepeated++;
                }
                if (colHasDuplicate) {
                    colRepeated++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, rowRepeated, colRepeated);
        }
        
        scanner.close();
    }
}