import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            String movements = sc.next();
            int length = movements.length();
            
            int currentX = startX;
            int currentY = startY;
            boolean isPossible = false;
            int resultStep = -1;
            
            for (int step = 1; step <= length; step++) {
                char direction = movements.charAt(step - 1);
                
                switch (direction) {
                    case 'N':
                        currentY++;
                        break;
                    case 'S':
                        currentY--;
                        break;
                    case 'E':
                        currentX++;
                        break;
                    case 'W':
                        currentX--;
                        break;
                }
                
                if (calculateManhattanDistance(currentX, currentY, 0, 0) <= step && !isPossible) {
                    isPossible = true;
                    resultStep = step;
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(resultStep);
            }
        }
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}