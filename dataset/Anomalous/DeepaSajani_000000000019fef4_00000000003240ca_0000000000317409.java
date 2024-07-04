import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer tokenizer;

    private static void readLine() throws IOException {
        tokenizer = new StringTokenizer(bufferedReader.readLine());
    }

    private static int nextInt() {
        return Integer.parseInt(nextString());
    }

    private static String nextString() {
        return tokenizer.nextToken();
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readLine();
        int testCases = nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            readLine();
            int x = nextInt();
            int y = nextInt();
            String sequence = nextString();
            int result = solve(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (result == -1 ? "IMPOSSIBLE" : result));
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
        return findReachableTime(queue, positions, new HashMap<>());
    }

    private static int findReachableTime(Queue<int[]> queue, List<int[]> positions, Map<String, Integer> visited) {
        int minTime = -1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            String key = x + "-" + y + "-" + time;

            if (time >= positions.size()) {
                return minTime;
            }

            if ((x == positions.get(time)[0] && y == positions.get(time)[1]) || visited.containsKey(key)) {
                minTime = minTime == -1 ? time : Math.min(minTime, time);
                visited.put(key, time);
            } else {
                queue.add(new int[]{x + 1, y, time + 1});
                queue.add(new int[]{x - 1, y, time + 1});
                queue.add(new int[]{x, y + 1, time + 1});
                queue.add(new int[]{x, y - 1, time + 1});
                queue.add(new int[]{x, y, time + 1});
            }
        }
        return minTime;
    }
}