import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int caseNo = 1; caseNo <= T; caseNo++) {
            int X = scan.nextInt();
            int Y = scan.nextInt();
            String M = scan.next();
            char[] steps = M.toCharArray();
            int len = steps.length;
            int catX = 0;
            int catY = 0;
            for (int i = 0; i < len; i++) {
                if (steps[i] == 'E') {
                    catX += 1;
                    continue;
                }
                if (steps[i] == 'W') {
                    catX -= 1;
                    continue;
                }
                if (steps[i] == 'S') {
                    catY += 1;
                    continue;
                }
                catY -= 1;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = len - 1; 0 <= i; i--) {
                int distance = Math.abs(X-catX) + Math.abs(Y-catY);
                if (distance <= i + 1) {
                    ans = Math.min(ans, i + 1);
                }
                if (steps[i] == 'E') {
                    catX -= 1;
                    continue;
                }
                if (steps[i] == 'W') {
                    catX += 1;
                    continue;
                }
                if (steps[i] == 'S') {
                    catY -= 1;
                    continue;
                }
                catY += 1;
            }
            if (ans == Integer.MAX_VALUE) {
                System.out.printf("Case #%d: %s\n", caseNo, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: %d\n", caseNo, ans);
            }
        }
    }
}
