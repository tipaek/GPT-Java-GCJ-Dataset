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
            int distance = Math.abs(X) + Math.abs(Y);
            
            for (char move : S.toCharArray()) {
                if (distance == 0) break;
                
                switch (move) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }
                
                steps++;
                distance = Math.abs(X) + Math.abs(Y);
                
                if (distance <= steps) {
                    break;
                }
            }
            
            if (distance == 0) {
                System.out.println("Case #" + tt + ": " + steps);
            } else {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }
        }
        
        in.close();
    }
}