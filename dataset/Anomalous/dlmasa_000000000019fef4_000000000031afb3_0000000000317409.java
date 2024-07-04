import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }
    
    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            
            char[] steps = M.toCharArray();
            int len = steps.length;
            int catX = 0, catY = 0;
            
            if (X == 0 && Y == 0) {
                System.out.printf("Case #%d: %d\n", caseNo, 0);
                continue;
            }
            
            for (int i = 0; i < len; i++) {
                switch (steps[i]) {
                    case 'E': catX++; break;
                    case 'W': catX--; break;
                    case 'S': catY++; break;
                    case 'N': catY--; break;
                }
            }
            
            int minSteps = Integer.MAX_VALUE;
            for (int i = len - 1; i >= 0; i--) {
                int distance = Math.abs(X - catX) + Math.abs(Y - catY);
                if (distance <= i + 1) {
                    minSteps = Math.min(minSteps, i + 1);
                }
                
                switch (steps[i]) {
                    case 'E': catX--; break;
                    case 'W': catX++; break;
                    case 'S': catY--; break;
                    case 'N': catY++; break;
                }
            }
            
            if (minSteps == Integer.MAX_VALUE) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNo);
            } else {
                System.out.printf("Case #%d: %d\n", caseNo, minSteps);
            }
        }
    }
}