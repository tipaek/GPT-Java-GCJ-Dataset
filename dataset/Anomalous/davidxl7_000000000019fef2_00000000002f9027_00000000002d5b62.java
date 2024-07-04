import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, ""));

        int maxMoves = 1;
        while (Math.pow(2, maxMoves) < Math.max(Math.abs(X), Math.abs(Y))) {
            maxMoves++;
        }
        maxMoves += 2;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.x == X && current.y == Y) {
                System.out.println(current.path);
                return;
            }

            if (current.moves == maxMoves) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            int step = (int) Math.pow(2, current.moves);
            queue.add(new State(current.x - step, current.y, current.moves + 1, current.path + "W"));
            queue.add(new State(current.x, current.y - step, current.moves + 1, current.path + "S"));
            queue.add(new State(current.x + step, current.y, current.moves + 1, current.path + "E"));
            queue.add(new State(current.x, current.y + step, current.moves + 1, current.path + "N"));
        }
    }

    static class State {
        int x, y, moves;
        String path;

        public State(int x, int y, int moves, String path) {
            this.x = x;
            this.y = y;
            this.moves = moves;
            this.path = path;
        }
    }
}