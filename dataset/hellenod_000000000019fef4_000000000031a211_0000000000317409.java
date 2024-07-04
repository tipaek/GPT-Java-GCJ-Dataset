import java.util.ArrayDeque;
import java.util.HashMap;
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
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.add(new int[] { 0, 0 });
        int tick = 0;

        while(!q.isEmpty() && tick <= M.length()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int[] pos = q.poll();
                if (pos[0] == X && pos[1] == Y) {
                    return tick;
                }

                q.add(new int[] { pos[0], pos[1] });
                q.add(new int[] { pos[0] + 1, pos[1] });
                q.add(new int[] { pos[0] - 1, pos[1] });
                q.add(new int[] { pos[0], pos[1] + 1});
                q.add(new int[] { pos[0], pos[1] - 1});
            }

            if (tick == M.length()) {
                break;
            }
            char move = M.charAt(tick);
            if (move == 'N') {
                Y++;
            } else if (move == 'E') {
                X++;
            } else if (move == 'S') {
                Y--;
            } else {
                X--;
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