import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            
            int currentX = x;
            int currentY = y;
            
            if (x == 0 && y == 0) {
                System.out.printf("Case #%d: %d\n", caseNumber, 0);
                continue;
            }
            
            char[] steps = movements.toCharArray();
            int length = steps.length;
            int minTime = Integer.MAX_VALUE;
            
            for (int i = 0; i < length; i++) {
                switch (steps[i]) {
                    case 'E': currentX++; break;
                    case 'W': currentX--; break;
                    case 'N': currentY++; break;
                    case 'S': currentY--; break;
                }
                
                int distance = Math.abs(currentX) + Math.abs(currentY);
                if (distance <= i + 1) {
                    minTime = Math.min(minTime, i + 1);
                }
            }
            
            for (int i = length - 1; i >= 0; i--) {
                switch (steps[i]) {
                    case 'E': currentX--; break;
                    case 'W': currentX++; break;
                    case 'N': currentY--; break;
                    case 'S': currentY++; break;
                }
                
                int distance = Math.abs(currentX) + Math.abs(currentY);
                if (distance <= i + 1) {
                    minTime = Math.min(minTime, i + 1);
                }
            }
            
            if (minTime == Integer.MAX_VALUE) {
                System.out.printf("Case #%d: %s\n", caseNumber, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: %d\n", caseNumber, minTime);
            }
        }
    }
}