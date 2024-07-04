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
        int testCases = getIntFromBufferedReader();
        for (int tc = 1; tc <= testCases; tc++) {
            int[] coordinates = getCoordinates();
            String sequence = getStringFromBufferedReader();
            int time = findSolution(coordinates[0], coordinates[1], sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int getIntFromBufferedReader() throws IOException {
        readLine();
        return getInt();
    }

    private static int[] getCoordinates() throws IOException {
        readLine();
        return new int[]{getInt(), getInt()};
    }

    private static String getStringFromBufferedReader() throws IOException {
        readLine();
        return getString();
    }

    private static int findSolution(int x, int y, String sequence) {
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
        Map<String, Boolean> memoizationMap = new HashMap<>();
        for (int i = 0; i < positions.size(); i++) {
            if (canReach(0, 0, positions.get(i)[0], positions.get(i)[1], i + 1, memoizationMap)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean canReach(int x, int y, int targetX, int targetY, int time, Map<String, Boolean> memoizationMap) {
        String key = generateKey(x, y, targetX, targetY, time);
        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }
        if (x == targetX && y == targetY && time == 0) {
            memoizationMap.put(key, true);
            return true;
        }
        if (time < 0) {
            memoizationMap.put(key, false);
            return false;
        }
        boolean result = canReach(x + 1, y, targetX, targetY, time - 1, memoizationMap) ||
                         canReach(x - 1, y, targetX, targetY, time - 1, memoizationMap) ||
                         canReach(x, y + 1, targetX, targetY, time - 1, memoizationMap) ||
                         canReach(x, y - 1, targetX, targetY, time - 1, memoizationMap) ||
                         canReach(x, y, targetX, targetY, time - 1, memoizationMap);
        memoizationMap.put(key, result);
        return result;
    }

    private static String generateKey(int x, int y, int targetX, int targetY, int time) {
        return Stream.of(x, y, targetX, targetY, time).map(String::valueOf).collect(Collectors.joining("-"));
    }
}