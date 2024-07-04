import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();

            int currentX = x;
            int currentY = y;
            List<Integer> timeToReachOrigin = new ArrayList<>();

            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'S': currentY--; break;
                    case 'N': currentY++; break;
                    case 'E': currentX++; break;
                    case 'W': currentX--; break;
                }

                int manhattanDistance = calculateManhattanDistance(currentX, currentY, 0, 0);
                timeToReachOrigin.add(manhattanDistance);
            }

            List<Integer> possibleTimes = new ArrayList<>();
            for (int i = 0; i < timeToReachOrigin.size(); i++) {
                if (timeToReachOrigin.get(i) <= (i + 1)) {
                    possibleTimes.add(i + 1);
                }
            }

            if (!possibleTimes.isEmpty()) {
                System.out.println("Case #" + caseNumber + ": " + Collections.min(possibleTimes));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}