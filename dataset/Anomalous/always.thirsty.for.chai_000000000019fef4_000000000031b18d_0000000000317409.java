import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int originalT = t;

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            char[] path = M.toCharArray();
            int len = path.length;
            int currX = X;
            int currY = Y;
            int time = 0;
            int minTime = Integer.MAX_VALUE;
            boolean canReach = false;

            for (char direction : path) {
                switch (direction) {
                    case 'S':
                        currY--;
                        break;
                    case 'N':
                        currY++;
                        break;
                    case 'E':
                        currX++;
                        break;
                    case 'W':
                        currX--;
                        break;
                }
                time++;
                int totalPath = Math.abs(currX) + Math.abs(currY);

                if (totalPath <= time) {
                    canReach = true;
                    minTime = Math.min(minTime, time);
                }
            }

            if (canReach) {
                System.out.println("Case #" + caseNum + ": " + minTime);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}