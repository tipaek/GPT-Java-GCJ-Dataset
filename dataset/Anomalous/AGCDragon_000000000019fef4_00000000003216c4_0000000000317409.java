import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int tt = 1; tt <= T; tt++) {
            int X = in.nextInt(); // East
            int Y = in.nextInt(); // North
            String S = in.next();
            
            int steps = 0;
            boolean reached = false;
            
            for (char move : S.toCharArray()) {
                steps++;
                
                switch (move) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }
                
                if (Math.abs(X) + Math.abs(Y) <= steps) {
                    reached = true;
                    break;
                }
            }
            
            if (reached) {
                System.out.println("Case #" + tt + ": " + steps);
            } else {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }
        }
    }
}