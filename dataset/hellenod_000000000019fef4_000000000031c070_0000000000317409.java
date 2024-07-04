import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for(int i = 1; i <= tests; i++){
            int X = input.nextInt();
            int Y = input.nextInt();
            String M = input.next();

            int result = Solve(X, Y, M);
            String r = result == -1 ? "IMPOSSIBLE" : Integer.toString(result);

            System.out.println( String.format("Case #%d: %s", i, r) );
        }
    }

    static int Solve(int X, int Y, String M){
        int[][] path = new int[M.length() + 1][2];
        int x = X;
        int y = Y;

        path[0][0] = x;
        path[0][1] = y;
        for(int i = 0; i < M.length(); i++){
            char move = M.charAt(i);
            if (move == 'N') {
                y++;
            } else if (move == 'E') {
                x++;
            } else if (move == 'S') {
                y--;
            } else {
                x--;
            }

            path[i + 1][0] = x;
            path[i + 1][1] = y;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.add(new int[] { 0, 0 });
        int tick = 0;
        int wait = 1000000;
        while(!q.isEmpty() && tick <= M.length()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int[] pos = q.poll();
                
                if (pos[0] == path[tick][0] && pos[1] == path[tick][1]) {
                    return Math.min(wait, tick);
                }

                for(int j = tick + 1; j <= M.length(); j++){
                    if (pos[0] == path[j][0] && pos[1] == path[j][1]) {
                        wait = Math.min(wait, j);
                    }
                }                

                if (wait <= tick) {
                    return wait;
                }
                
                q.add(new int[] { pos[0] + 1, pos[1] });
                q.add(new int[] { pos[0] - 1, pos[1] });
                q.add(new int[] { pos[0], pos[1] + 1});
                q.add(new int[] { pos[0], pos[1] - 1});
            }            
            
            tick++;
        }

        return -1;
    }

    static int gcd(int a, int b) {
        if (a > 0) {
            return gcd(b % a, a);
        } else {
            return b;
        }
    }
}