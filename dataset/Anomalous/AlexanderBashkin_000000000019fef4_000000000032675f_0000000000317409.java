import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int OFFSET = 1002;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        new Solution().execute();
    }

    private void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String path = tokenizer.nextToken();
            processTestCase(t, x, y, path);
        }
    }

    private void processTestCase(int testCaseNumber, int x, int y, String path) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        int[][] distance = new int[OFFSET * 3][OFFSET * 3];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        distance[OFFSET][OFFSET] = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int currentDistance = distance[current.x + OFFSET][current.y + OFFSET];
            if (currentDistance == path.length()) continue;

            for (int[] direction : DIRECTIONS) {
                Coordinate next = new Coordinate(current.x + direction[0], current.y + direction[1]);
                if (distance[next.x + OFFSET][next.y + OFFSET] == -1) {
                    distance[next.x + OFFSET][next.y + OFFSET] = currentDistance + 1;
                    queue.add(next);
                }
            }
        }

        for (int i = 0; i < path.length(); i++) {
            char move = path.charAt(i);
            switch (move) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'W': x--; break;
                case 'E': x++; break;
            }
            if (distance[x + OFFSET][y + OFFSET] != -1 && distance[x + OFFSET][y + OFFSET] <= i + 1) {
                System.out.printf("Case #%d: %d\n", testCaseNumber, i + 1);
                return;
            }
        }
        System.out.printf("Case #%d: IMPOSSIBLE\n", testCaseNumber);
    }

    static class Coordinate {
        final int x, y;
        final String representation;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.representation = x + "#" + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate that = (Coordinate) obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return representation.hashCode();
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}