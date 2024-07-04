import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String[] input = sc.nextLine().split(" ");
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
                
                if (targetX > currentX) {
                    targetX--;
                } else if (targetX < currentX) {
                    targetX++;
                } else if (targetY > currentY) {
                    targetY--;
                } else if (targetY < currentY) {
                    targetY++;
                }
                
                if (currentX == targetX && currentY == targetY) {
                    minutes = i + 1;
                    break outerLoop;
                }
                
                String currentPos = currentX + "," + currentY;
                String targetPos = targetX + "," + targetY;
                
                if (visitedPositions.containsKey(currentPos)) {
                    minutes = i + 1;
                    break;
                } else {
                    visitedPositions.put(targetPos, i);
                }
            }
            
            String result = (minutes == -1) ? "IMPOSSIBLE" : String.valueOf(minutes);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}