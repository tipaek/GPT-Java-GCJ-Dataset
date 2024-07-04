import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int currentX = 0;
            int currentY = 0;
            int steps = 0;
            boolean reached = false;
            
            System.out.print("Case #" + (i + 1) + ": ");
            String directions = sc.next();
            
            for (int j = 0; j < directions.length(); j++) {
                char move = directions.charAt(j);
                
                switch (move) {
                    case 'N': y += 1; break;
                    case 'S': y -= 1; break;
                    case 'E': x += 1; break;
                    case 'W': x -= 1; break;
                }
                
                steps++;
                
                int xDiff = Math.abs(x - currentX);
                int yDiff = Math.abs(y - currentY);
                
                if (xDiff > yDiff) {
                    if (x > currentX) currentX++;
                    else if (x < currentX) currentX--;
                } else if (xDiff < yDiff) {
                    if (y > currentY) currentY++;
                    else if (y < currentY) currentY--;
                } else {
                    if (x == currentX && y == currentY) {
                        reached = true;
                        break;
                    } else if (j == directions.length() - 1) {
                        steps = -1;
                    } else {
                        char nextMove = directions.charAt(j + 1);
                        if (nextMove == 'S' || nextMove == 'E') {
                            if (x > currentX) currentX++;
                            else if (x < currentX) currentX--;
                        } else {
                            if (y > currentY) currentY++;
                            else if (y < currentY) currentY--;
                        }
                    }
                }
                
                if (x == currentX && y == currentY) {
                    reached = true;
                    break;
                }
                
                if (j == directions.length() - 1) {
                    steps = -1;
                }
            }
            
            if (steps == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(steps);
            }
        }
    }
}