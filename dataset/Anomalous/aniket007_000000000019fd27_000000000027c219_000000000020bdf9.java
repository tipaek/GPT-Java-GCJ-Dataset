import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;
            int cCount = 0, jCount = 0;
            
            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean canAssignToC = true;
                boolean canAssignToJ = true;
                
                for (int u = 0; u < cCount; u++) {
                    if (!(start >= C[1][u] || end <= C[0][u])) {
                        canAssignToC = false;
                        break;
                    }
                }
                
                if (canAssignToC) {
                    C[0][cCount] = start;
                    C[1][cCount] = end;
                    cCount++;
                    schedule.append("C");
                    continue;
                }
                
                for (int y = 0; y < jCount; y++) {
                    if (!(start >= J[1][y] || end <= J[0][y])) {
                        canAssignToJ = false;
                        break;
                    }
                }
                
                if (canAssignToJ) {
                    J[0][jCount] = start;
                    J[1][jCount] = end;
                    jCount++;
                    schedule.append("J");
                } else {
                    isPossible = false;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break outerLoop;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
        
        sc.close();
    }
}