import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static void readLine() throws IOException {
        st = new StringTokenizer(bufferedReader.readLine());
    }

    private static int getInt() {
        return Integer.parseInt(getString());
    }

    private static String getString() {
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        readLine();
        int testCases = getInt();
        for (int tc = 1; tc <= testCases; tc++) {
            readLine();
            int x = getInt();
            int y = getInt();
            String sequence = getString();
            int time = findMinimumTime(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int findMinimumTime(int x, int y, String sequence) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{x, y});
        for (char direction : sequence.toCharArray()) {
            int[] prevPosition = positions.get(positions.size() - 1);
            int newX = prevPosition[0];
            int newY = prevPosition[1];
            switch (direction) {
                case 'N': newY++; break;
                case 'S': newY--; break;
                case 'E': newX++; break;
                case 'W': newX--; break;
            }
            positions.add(new int[]{newX, newY});
        }
        Map<String, Integer> memo = new HashMap<>();
        return calculateMinimumTime(0, 0, positions, memo, 0);
    }

    private static int calculateMinimumTime(int x, int y, List<int[]> positions, Map<String, Integer> memo, int time) {
        String key = x + "-" + y + "-" + time;
        if (memo.containsKey(key)) return memo.get(key);
        if (time >= positions.size()) return -1;
        if (x == positions.get(time)[0] && y == positions.get(time)[1]) {
            memo.put(key, time);
            return time;
        }
        int north = calculateMinimumTime(x + 1, y, positions, memo, time + 1);
        int south = calculateMinimumTime(x - 1, y, positions, memo, time + 1);
        int east = calculateMinimumTime(x, y + 1, positions, memo, time + 1);
        int west = calculateMinimumTime(x, y - 1, positions, memo, time + 1);
        int stay = calculateMinimumTime(x, y, positions, memo, time + 1);
        int minTime = Stream.of(north, south, east, west, stay).filter(t -> t != -1).min(Integer::compare).orElse(-1);
        memo.put(key, minTime);
        return minTime;
    }
}