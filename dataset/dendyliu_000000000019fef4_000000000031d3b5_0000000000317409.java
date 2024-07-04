import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    private static class State {
        private int x;
        private int y;
        private int idx;
        State(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int hashCode() {
            int prime = 7;
            prime = prime + 11 * this.x;
            prime = prime + 11 * this.y;
            prime = prime + 11 * this.idx;
            return prime;
        }

        @Override
        public boolean equals(Object obj) {
            State other = (State) obj;
            return this.x == other.x && this.y == other.y && this.idx == other.idx;
        }
    }

    public static int[] nextMove(int x, int y, char move) {
        int[] next = new int[2];
        next[0] = x;
        next[1] = y;
        if (move == 'N') next[1]++;
        else if (move == 'S') next[1]--;
        else if (move == 'W') next[0]--;
        else next[0]++;
        return next;
    }

    public static int findPath(HashMap<State, Integer> dp, int xp, int yp, String moves, int x, int y, int idx) {
        if (x == xp && y == yp) return 0;
        if (idx == moves.length()) return Integer.MAX_VALUE;
        State state = new State(x, y, idx);
        if (dp.containsKey(state)) return dp.get(state);
        int[] nextP = nextMove(xp, yp, moves.charAt(idx));
        int left = findPath(dp, nextP[0], nextP[1], moves, x - 1, y, idx + 1);
        int right = findPath(dp, nextP[0], nextP[1], moves, x + 1, y, idx + 1);
        int bottom = findPath(dp, nextP[0], nextP[1], moves, x, y - 1, idx + 1);
        int up = findPath(dp, nextP[0], nextP[1], moves, x, y + 1, idx + 1);
        int still = findPath(dp, nextP[0], nextP[1], moves, x, y, idx + 1);
        int res = Math.min(left, Math.min(right, Math.min(bottom, Math.min(up, still))));
        if (res == Integer.MAX_VALUE) {
            dp.put(state, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        dp.put(state, 1 + res);
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
            HashMap<State, Integer> dp = new HashMap<>();
            int minPath = findPath(dp, X, Y, moves, 0, 0, 0);
            String res = minPath == Integer.MAX_VALUE ? "IMPOSSIBLE" : minPath + " ";
            String answer = "Case #" + (t + 1) + ": " + res;
            result.append(answer + "\n");
        }
        System.out.println(result);
    }
}