import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            
            int n = sc.nextInt();
            
            int trace = 0;
            
            boolean[][] rows = new boolean[n][n + 1];
            boolean[][] cols = new boolean[n][n + 1];
            
            int wrongRows = 0;
            int wrongCols = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = sc.nextInt();
                    
                    if (i == j) {
                        trace += x;
                    }
                    
                    if (!rows[i][0]) { // check for repeat
                        if (rows[i][0] = rows[i][x]) {
                            wrongRows++;
                        }
                    }
                    
                    if (!cols[j][0]) { // check for repeat
                        if (cols[j][0] = cols[j][x]) {
                            wrongCols++;
                        }
                    }
                    
                    rows[i][x] = cols[j][x] = true;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, wrongRows, wrongCols);
        }
    }
}
