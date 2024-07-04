import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int targetX = Integer.parseInt(input[0]);
            int targetY = Integer.parseInt(input[1]);
            String path = input[2];

            int currentX = 0;
            int currentY = 0;
            int minutes = -1;
            Map<String, Integer> visitedPositions = new HashMap<>();

            outerLoop:
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'N':
                        currentY--;
                        break;
                    case 'S':
                        currentY++;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                }

                if (currentX == targetX && currentY == targetY) {
                    minutes = i;
                    break;
                }

                String key = currentX + "," + currentY;
                if (visitedPositions.containsKey(key)) {
                    minutes = i;
                    break;
                } else {
                    visitedPositions.put(key, i);
                }

                if (currentX != targetX) {
                    targetX += (currentX < targetX) ? -1 : 1;
                } else if (currentY != targetY) {
                    targetY += (currentY < targetY) ? -1 : 1;
                }
            }

            String result = (minutes == -1) ? "IMPOSSIBLE" : String.valueOf(minutes + 1);
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}