import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer st;

    private static void readLine() throws IOException {
        st = new StringTokenizer(bufferedReader.readLine());
    }

    private static int getInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static String getString() {
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readLine();
        int testCases = getInt();
        for (int tc = 1; tc <= testCases; tc++) {
            readLine();
            int x = getInt();
            int y = getInt();
            String sequence = getString();
            int time = solve(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int solve(int x, int y, String sequence) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{x, y});
        for (char direction : sequence.toCharArray()) {
            int[] prevPosition = positions.get(positions.size() - 1);
            switch (direction) {
                case 'N':
                    positions.add(new int[]{prevPosition[0], prevPosition[1] + 1});
                    break;
                case 'S':
                    positions.add(new int[]{prevPosition[0], prevPosition[1] - 1});
                    break;
                case 'E':
                    positions.add(new int[]{prevPosition[0] + 1, prevPosition[1]});
                    break;
                case 'W':
                    positions.add(new int[]{prevPosition[0] - 1, prevPosition[1]});
                    break;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        return canReach(queue, positions);
    }

    private static int canReach(Queue<int[]> queue, List<int[]> positions) {
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            int time = position[2];
            if (time >= positions.size()) {
                return -1;
            }
            if (x == positions.get(time)[0] && y == positions.get(time)[1]) {
                return time;
            }
            queue.add(new int[]{x + 1, y, time + 1});
            queue.add(new int[]{x - 1, y, time + 1});
            queue.add(new int[]{x, y + 1, time + 1});
            queue.add(new int[]{x, y - 1, time + 1});
            queue.add(new int[]{x, y, time + 1});
        }
        return -1;
    }
}