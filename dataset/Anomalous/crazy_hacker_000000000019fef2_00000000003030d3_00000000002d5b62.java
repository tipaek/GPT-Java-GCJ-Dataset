import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        
        for (int h = 1; h <= t; h++) {
            out.print("Case #" + h + ": ");
            String[] in = br.readLine().split(" ");
            long x = Long.parseLong(in[0]);
            long y = Long.parseLong(in[1]);
            long xAbs = Math.abs(x);
            long yAbs = Math.abs(y);

            if ((xAbs % 2 == 0 && yAbs % 2 == 0) || (xAbs % 2 != 0 && yAbs % 2 != 0)) {
                out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = findPath(x, y, xAbs, yAbs);
                out.println(result.length() == 0 ? "IMPOSSIBLE" : result.toString());
            }
        }
        
        out.flush();
        br.close();
    }

    private static StringBuilder findPath(long x, long y, long xAbs, long yAbs) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(xAbs, yAbs));
        int count = 0;

        while (count < 64) {
            Queue<State> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                State current = queue.poll();
                if (current.l == 0 && current.r == 0) {
                    return adjustPath(current.moves, x, y);
                }
                addNextStates(queue, current, count);
            }
            count++;
        }
        return new StringBuilder();
    }

    private static void addNextStates(Queue<State> queue, State current, int count) {
        long val = (long) Math.pow(2, count);

        if (isValidState(current.r, val)) {
            queue.add(new State(current.l - val, current.r, new StringBuilder(current.moves).append("E")));
            queue.add(new State(current.l + val, current.r, new StringBuilder(current.moves).append("W")));
        }

        if (isValidState(current.l, val)) {
            queue.add(new State(current.l, current.r - val, new StringBuilder(current.moves).append("N")));
            queue.add(new State(current.l, current.r + val, new StringBuilder(current.moves).append("S")));
        }
    }

    private static boolean isValidState(long coordinate, long val) {
        return (coordinate >= val && (coordinate & val) == 0);
    }

    private static StringBuilder adjustPath(StringBuilder path, long x, long y) {
        if (y < 0) {
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'N') {
                    path.setCharAt(i, 'S');
                } else if (path.charAt(i) == 'S') {
                    path.setCharAt(i, 'N');
                }
            }
        }
        if (x < 0) {
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'E') {
                    path.setCharAt(i, 'W');
                } else if (path.charAt(i) == 'W') {
                    path.setCharAt(i, 'E');
                }
            }
        }
        return path;
    }
}

class State {
    long l;
    long r;
    StringBuilder moves;

    public State(long l, long r) {
        this(l, r, new StringBuilder());
    }

    public State(long l, long r, StringBuilder moves) {
        this.l = l;
        this.r = r;
        this.moves = moves;
    }
}