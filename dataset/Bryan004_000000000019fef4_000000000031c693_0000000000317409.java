import java.util.*;

public class Solution {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
            String[] s = scan.nextLine().split(" ");
            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);
            String path = s[2];          
            int moves = -1;
            int time = 1;
            
            int dx = Math.abs(x);
            int dy = Math.abs(y);
            int sum = dx + dy;
            
            if (sum <= (time)) moves = sum;
            else {
                for (int j = 0; j < path.length(); j++) {
                    time++;
                    if (path.charAt(j) == 'N') y++;
                    if (path.charAt(j) == 'S') y--;
                    if (path.charAt(j) == 'E') x++;
                    if (path.charAt(j) == 'W') x--;
                    
                    dx = Math.abs(x);
                    dy = Math.abs(y);
                    sum = dx + dy;
                    if (sum <= (time)) {
                        moves = Math.max(moves, sum);
                    }           
                }
            }
            if (moves == -1 ||  moves > path.length()) System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else System.out.println("Case #" + (i + 1) + ": " + moves);
        }      
    }
}