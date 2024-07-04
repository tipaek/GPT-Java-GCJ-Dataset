import java.io.*;
import java.util.*;

public class Solution {
    private static class State {
        private int x, y, idx;
        
        State(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, idx);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            State other = (State) obj;
            return x == other.x && y == other.y && idx == other.idx;
        }
    }

    public static int[] nextMove(int x, int y, char move) {
        int[] next = {x, y};
        switch (move) {
            case 'N': next[1]++; break;
            case 'S': next[1]--; break;
            case 'W': next[0]--; break;
            case 'E': next[0]++; break;
        }
        return next;
    }

    public static int findPath(Map<State, Integer> dp, int xp, int yp, String moves, int x, int y, int idx) {
        if (x == xp && y == yp) return 0;
        if (idx == moves.length()) return Integer.MAX_VALUE;
        
        State state = new State(x, y, idx);
        if (dp.containsKey(state)) return dp.get(state);
        
        int[] nextP = nextMove(xp, yp, moves.charAt(idx));
        int left = findPath(dp, nextP[0], nextP[1], moves, x - 1, y, idx + 1);
        int right = findPath(dp, nextP[0], nextP[1], moves, x + 1, y, idx + 1);
        int down = findPath(dp, nextP[0], nextP[1], moves, x, y - 1, idx + 1);
        int up = findPath(dp, nextP[0], nextP[1], moves, x, y + 1, idx + 1);
        int still = findPath(dp, nextP[0], nextP[1], moves, x, y, idx + 1);
        
        int res = Math.min(left, Math.min(right, Math.min(down, Math.min(up, still))));
        dp.put(state, res == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + res);
        return dp.get(state);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        
        for (int t = 0; t < T; ++t) {
            String[] input = scan.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String moves = input[2];
            
            Map<State, Integer> dp = new HashMap<>();
            int minPath = findPath(dp, X, Y, moves, 0, 0, 0);
            String res = minPath == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(minPath);
            result.append("Case #").append(t + 1).append(": ").append(res).append("\n");
        }
        
        System.out.print(result);
    }
}