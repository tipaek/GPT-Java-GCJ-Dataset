import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        for (int tc = 1; tc <= testCases; tc++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String sequence = st.nextToken();
            int time = findMinimumTime(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int findMinimumTime(int x, int y, String sequence) {
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
        return bfs(queue, positions);
    }

    private static int bfs(Queue<int[]> queue, List<int[]> positions) {
        Set<String> visited = new HashSet<>();
        int finalTime = -1;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            int time = position[2];

            if (time >= positions.size()) {
                return finalTime;
            }

            if (x == positions.get(time)[0] && y == positions.get(time)[1]) {
                finalTime = finalTime == -1 ? time : Math.min(finalTime, time);
            }

            String key = x + "," + y + "," + time;
            if (!visited.contains(key)) {
                visited.add(key);
                queue.add(new int[]{x + 1, y, time + 1});
                queue.add(new int[]{x - 1, y, time + 1});
                queue.add(new int[]{x, y + 1, time + 1});
                queue.add(new int[]{x, y - 1, time + 1});
                queue.add(new int[]{x, y, time + 1});
            }
        }
        return finalTime;
    }
}