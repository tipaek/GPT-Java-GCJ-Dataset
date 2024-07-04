import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer stringTokenizer;

    private static void readLine() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    }

    private static int getInt() {
        return Integer.parseInt(getString());
    }

    private static String getString() {
        return stringTokenizer.nextToken();
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readLine();
        int testCases = getInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            readLine();
            int x = getInt();
            int y = getInt();
            String sequence = getString();
            int time = calculateTime(x, y, sequence);
            System.out.println("Case #" + testCase + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int calculateTime(int x, int y, String sequence) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{x, y});
        for (char direction : sequence.toCharArray()) {
            int[] previousPosition = positions.get(positions.size() - 1);
            int newX = previousPosition[0], newY = previousPosition[1];
            switch (direction) {
                case 'N': newY++; break;
                case 'S': newY--; break;
                case 'E': newX++; break;
                case 'W': newX--; break;
            }
            positions.add(new int[]{newX, newY});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        return bfs(queue, positions);
    }

    private static int bfs(Queue<int[]> queue, List<int[]> positions) {
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0], y = position[1], time = position[2];
            if (time >= positions.size()) {
                return -1;
            }
            if (x == positions.get(time)[0] && y == positions.get(time)[1]) {
                return time;
            }
            addToQueue(queue, visited, x + 1, y, time + 1);
            addToQueue(queue, visited, x - 1, y, time + 1);
            addToQueue(queue, visited, x, y + 1, time + 1);
            addToQueue(queue, visited, x, y - 1, time + 1);
            addToQueue(queue, visited, x, y, time + 1);
        }
        return -1;
    }

    private static void addToQueue(Queue<int[]> queue, Set<String> visited, int x, int y, int time) {
        String key = x + "," + y + "," + time;
        if (!visited.contains(key)) {
            queue.add(new int[]{x, y, time});
            visited.add(key);
        }
    }
}