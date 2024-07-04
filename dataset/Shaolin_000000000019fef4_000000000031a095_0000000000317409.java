

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 1; i <= T ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String S = scanner.next();
            int timeToTakePicture = solution.getMinTimeToTakePicture(x, y, S);
            if (timeToTakePicture == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + timeToTakePicture);
            }
        }
    }

    private int getMinTimeToTakePicture(int x, int y, String path) {

        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);
            if (move == 'E') x++;
            else if (move == 'W') x--;
            else if (move == 'N') y++;
            else y--;
            if (canReach(x,y, i+1)) {
                return i+1;
            }
        }
        return -1;
    }

    private boolean canReach(int x, int y, int time) {
        int requiredTime = Math.abs(x) + Math.abs(y);
        return requiredTime <= time;
    }

}
