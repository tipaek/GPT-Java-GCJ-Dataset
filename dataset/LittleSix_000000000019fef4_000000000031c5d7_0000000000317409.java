import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String path = in.next();
            int timeLength = path.length();
            int currentX = X;
            int currentY = Y;
            String result = "IMPOSSIBLE";
            for (int leftTime = timeLength; leftTime >= 0; leftTime--) {
                int timeCost = timeLength - leftTime;
                int distense = Math.abs(currentX) + Math.abs(currentY);
                if (distense <= timeCost) {
                    result = "" + timeCost;
                    break;
                }
                if (leftTime > 0) {
                    if (path.charAt(timeCost) == 'N') {
                        currentY++;
                    } else if (path.charAt(timeCost) == 'S') {
                        currentY--;
                    } else if (path.charAt(timeCost) == 'E') {
                        currentX++;
                    } else if (path.charAt(timeCost) == 'W') {
                        currentX--;
                    }
                }
            }
            
            System.out.println("Case #" + caseNum +": " + result);
        }
    }
}