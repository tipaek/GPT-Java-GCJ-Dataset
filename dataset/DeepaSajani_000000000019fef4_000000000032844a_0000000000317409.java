import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        Queue<List<Integer>> stack = new LinkedList<>();
        stack.add(new ArrayList<>(asList(0, 0, 0)));
        return canReachIterBFS(stack, positions);
    }

    private static int canReachIterBFS(Queue<List<Integer>> queue, List<List<Integer>> positions) {
        HashSet<List<Integer>> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            List<Integer> position = queue.poll();
            Integer x = position.get(0);
            Integer y = position.get(1);
            Integer stackTime = position.get(2);
            if (stackTime >= positions.size()) {
                return -1;
            }
            if (x.equals(positions.get(stackTime).get(0)) && y.equals(positions.get(stackTime).get(1))) {
                return stackTime;
            }
            List<Integer> east = asList(x + 1, y, stackTime + 1);
            if (!visited.contains(east)) {
                queue.add(east);
                visited.add(east);
            }
            List<Integer> west = asList(x - 1, y, stackTime + 1);
            if (!visited.contains(west)) {
                queue.add(west);
                visited.add(west);
            }
            List<Integer> north = asList(x, y + 1, stackTime + 1);
            if (!visited.contains(north)) {
                queue.add(north);
                visited.add(north);
            }
            List<Integer> south = asList(x, y - 1, stackTime + 1);
            if (!visited.contains(south)) {
                queue.add(south);
                visited.add(south);
            }
            List<Integer> stand = asList(x, y, stackTime + 1);
            queue.add(stand);
        }
        return -1;
    }
}
