import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String directions = scanner.next();
            int length = directions.length();
            
            int currentX = 0, currentY = 0;
            int distance = Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
            int steps = 0;
            
            for (int i = 0; i < length; i++) {
                if (distance == 0) {
                    break;
                }
                
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        targetY++;
                        break;
                    case 'S':
                        targetY--;
                        break;
                    case 'E':
                        targetX++;
                        break;
                    case 'W':
                        targetX--;
                        break;
                }
                
                if (targetX > currentX) {
                    currentX++;
                } else if (targetX < currentX) {
                    currentX--;
                } else if (targetY > currentY) {
                    currentY++;
                } else if (targetY < currentY) {
                    currentY--;
                }
                
                distance = Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
                steps++;
            }
            
            if (distance != 0) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tc + ": " + steps);
            }
        }
        
        scanner.close();
    }
}