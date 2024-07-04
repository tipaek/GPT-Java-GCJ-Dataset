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
            System.out.print("Case #" + h + ": ");
            String[] in = br.readLine().split(" ");
            long x = Long.parseLong(in[0]);
            long y = Long.parseLong(in[1]);
            long xAbs = Math.abs(x);
            long yAbs = Math.abs(y);

            if ((xAbs % 2 == 0 && yAbs % 2 == 0) || (xAbs % 2 != 0 && yAbs % 2 != 0)) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = findPath(xAbs, yAbs);
                if (result.length() == 0) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    adjustPathForNegativeCoordinates(result, x, y);
                    System.out.println(result.toString());
                }
            }
        }

        out.flush();
        br.close();
    }

    private static StringBuilder findPath(long x, long y) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(x, y));
        int count = 0;

        while (count < 64) {
            Queue<State> nextQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                State current = queue.poll();

                if (current.l == 0 && current.r == 0) {
                    return current.moves;
                }

                long step = 1L << count; // Equivalent to 2^count

                if (isValidMove(current.l, current.r, step, current.moves, nextQueue, 'E', -step, 0)) continue;
                if (isValidMove(current.l, current.r, step, current.moves, nextQueue, 'W', step, 0)) continue;
                if (isValidMove(current.l, current.r, step, current.moves, nextQueue, 'N', 0, -step)) continue;
                if (isValidMove(current.l, current.r, step, current.moves, nextQueue, 'S', 0, step)) continue;
            }

            queue = nextQueue;
            count++;
        }

        return new StringBuilder();
    }

    private static boolean isValidMove(long l, long r, long step, StringBuilder moves, Queue<State> queue, char direction, long lChange, long rChange) {
        long newL = l + lChange;
        long newR = r + rChange;

        if ((newL & step) == 0 && (newR & step) == 0) {
            State newState = new State(newL, newR);
            newState.moves.append(moves).append(direction);
            queue.add(newState);
            return true;
        }
        return false;
    }

    private static void adjustPathForNegativeCoordinates(StringBuilder path, long x, long y) {
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
    }
}

class State {
    long l;
    long r;
    StringBuilder moves;

    public State(long l, long r) {
        this.l = l;
        this.r = r;
        this.moves = new StringBuilder();
    }
}