import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        HashSet<Integer> seen = new HashSet();

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

        int res = 100000;
        for(int i = 0; i <= M.length(); i++){
            int[] p = path[i];
            int ticks = Math.abs(p[0]) + Math.abs(p[1]);
            if (ticks <= i) {
                res = Math.min(res, ticks);
                res = Math.max(res, i);
                return res;
            }
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