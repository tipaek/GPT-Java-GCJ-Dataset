import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Solution {
    private static BufferedReader bufferedReader;
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
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        readLine();
        int testCases = getInt();
        for (int tc = 1; tc <= testCases; tc++) {
            readLine();
            int x = getInt();
            int y = getInt();
            String sequence = getString();
            int time = solution(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int solution(int x, int y, String sequence) {
        List<List<Integer>> positions = new ArrayList<>();
        positions.add(new ArrayList<>(asList(x, y)));
        for (int i = 0; i < sequence.length(); i++) {
            char direction = sequence.charAt(i);
            List<Integer> prevPosition = positions.get(i);
            if (direction == 'N') {
                positions.add(new ArrayList<>(asList(prevPosition.get(0), prevPosition.get(1) + 1)));
            } else if (direction == 'S') {
                positions.add(new ArrayList<>(asList(prevPosition.get(0), prevPosition.get(1) - 1)));
            } else if (direction == 'E') {
                positions.add(new ArrayList<>(asList(prevPosition.get(0) + 1, prevPosition.get(1))));
            } else if (direction == 'W') {
                positions.add(new ArrayList<>(asList(prevPosition.get(0) - 1, prevPosition.get(1))));
            }
        }
        positions.remove(0);
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < positions.size(); i++) {
            boolean canReach = canReach(0, 0, positions.get(i).get(0), positions.get(i).get(1), i + 1, map);
            if (canReach) return i + 1;
        }
        return -1;
    }

    private static boolean canReach(int x, int y, int cx, int cy, int time, Map<String, Boolean> map) {
        String position = Stream.of(x, y, cx, cy, time).map(String::valueOf).collect(Collectors.joining("-"));
        if (map.containsKey(position)) return map.get(position);
        if (x == cx && y == cy && time == 0) {
            map.put(position, true);
            return true;
        }
        if (time < 0) {
            map.put(position, false);
            return false;
        }
        boolean north = canReach(x + 1, y, cx, cy, time - 1, map);
        boolean south = north || canReach(x - 1, y, cx, cy, time - 1, map);
        boolean east = south || canReach(x, y + 1, cx, cy, time - 1, map);
        boolean west = east || canReach(x, y - 1, cx, cy, time - 1, map);
        boolean stand = west || canReach(x, y, cx, cy, time - 1, map);
        map.put(position, stand);
        return stand;
    }
}
