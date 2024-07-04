import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        Map<Character, int[]> directions = new HashMap<>();
        directions.put('N', new int[]{1, 0});
        directions.put('S', new int[]{-1, 0});
        directions.put('E', new int[]{0, 1});
        directions.put('W', new int[]{0, -1});


        for (int t = 1; t <= T; t++) {

            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();


            int[][] moves = new int[M.length() + 1][2];

            moves[0] = new int[]{X, Y};

            int curX = Y;
            int curY = X;


            int steps = Integer.MAX_VALUE;

            if (X == 0 && Y == 0) {
                steps = 0;
                System.out.println("Case " + t + "#: " + steps);
                continue;
            }

            for (int i = 1; i <= M.length(); i++) {

                char c = M.charAt(i - 1);

                curX = curX + directions.get(c)[0];
                curY = curY + directions.get(c)[1];

                if (Math.abs(curX) + Math.abs(curY) <= i) {
                    steps = Math.min(steps, i);
                }

            }

            if (steps == Integer.MAX_VALUE) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + steps);
            }

        }
        
    }
}