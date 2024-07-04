import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] moves = scanner.next().toCharArray();
            
            int currX = x;
            int currY = y;
            int steps = 0;
            boolean reached = false;
            
            for (char move : moves) {
                switch (move) {
                    case 'S': currY--; break;
                    case 'N': currY++; break;
                    case 'E': currX++; break;
                    case 'W': currX--; break;
                }
                steps++;
                
                if (currX == 0 && currY == 0) {
                    reached = true;
                    break;
                }
                
                if (Math.abs(currX) > Math.abs(currY)) {
                    currX -= Integer.signum(currX);
                } else if (Math.abs(currX) < Math.abs(currY)) {
                    currY -= Integer.signum(currY);
                } else {
                    currX -= Integer.signum(currX);
                }
                
                if (currX == 0 && currY == 0) {
                    reached = true;
                    break;
                }
            }
            
            if (reached) {
                System.out.println("Case #" + i + ": " + steps);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}