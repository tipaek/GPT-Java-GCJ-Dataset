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
        Map<String, Integer> map = new HashMap<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(new ArrayList<>(asList(0, 0, 0)));
        return canReachIter(stack, positions, map);
    }

    private static int canReachIter(Stack<List<Integer>> stack, List<List<Integer>> positions, Map<String, Integer> map) {
        int finalTime = -1;
        while (!stack.isEmpty()) {
            List<Integer> position = stack.pop();
            Integer x = position.get(0);
            Integer y = position.get(1);
            Integer stackTime = position.get(2);
            if (stackTime >= positions.size()) {
                continue;
            }
            if (x == positions.get(stackTime).get(0) && y == positions.get(stackTime).get(1)) {
                finalTime = finalTime == -1 ? stackTime : Math.min(finalTime, stackTime);
            }
            stack.push(asList(x + 1, y, stackTime + 1));
            stack.push(asList(x - 1, y, stackTime + 1));
            stack.push(asList(x, y + 1, stackTime + 1));
            stack.push(asList(x, y - 1, stackTime + 1));
            stack.push(asList(x, y, stackTime + 1));
        }
        return finalTime;
    }
}
