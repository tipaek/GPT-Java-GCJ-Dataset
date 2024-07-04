import java.util.Scanner;

public class Solution {
    
    static int expogo(int x, int y, int step, int destX, int destY) {
        // Base cases
        if (Math.abs(x) > destX || Math.abs(y) > destY) {
            return Integer.MAX_VALUE;
        }
        if (x == destX && y == destY) {
            return step;
        }

        // Calculate next steps
        int nextStep = step + 1;
        int moveDistance = (int) Math.pow(2, nextStep - 1);

        // Try moving in all four directions
        int moveRight = expogo(x + moveDistance, y, nextStep, destX, destY);
        int moveLeft = expogo(x - moveDistance, y, nextStep, destX, destY);
        int moveUp = expogo(x, y + moveDistance, nextStep, destX, destY);
        int moveDown = expogo(x, y - moveDistance, nextStep, destX, destY);

        // Return the minimum steps required
        return Math.min(Math.min(moveRight, moveLeft), Math.min(moveUp, moveDown));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int result = expogo(0, 0, 0, x, y);

            if (result == Integer.MAX_VALUE) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
        
        sc.close();
    }
}