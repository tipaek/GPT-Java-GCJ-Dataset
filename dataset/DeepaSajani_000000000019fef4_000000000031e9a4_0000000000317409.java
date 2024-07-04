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
        Map<String, Integer> map = new HashMap<>();
        return canReach(0, 0, positions, map, 0);
    }

    private static int canReach(int x, int y, List<List<Integer>> positions, Map<String, Integer> map, int time) {
        String position = Stream.of(x, y, time).map(String::valueOf).collect(Collectors.joining("-"));
        if (map.containsKey(position)) return map.get(position);
        if (time >= positions.size()) return -1;
        if (x == positions.get(time).get(0) && y == positions.get(time).get(1)) {
            map.put(position, time);
            return time;
        }
        int north = canReach(x + 1, y, positions, map, time + 1);
        int south = canReach(x - 1, y, positions, map, time + 1);
        int east = canReach(x, y + 1, positions, map, time + 1);
        int west = canReach(x, y - 1, positions, map, time + 1);
        int stand = canReach(x, y, positions, map, time + 1);
        Integer value = Stream.of(north, south, east, west, stand).filter(v -> v != -1).min(Integer::compare).orElse(-1);
        map.put(position, value);
        return value;
    }
}
