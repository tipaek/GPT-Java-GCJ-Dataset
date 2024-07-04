import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader bufferedReader;
    private static StringTokenizer tokenizer;

    private static void readLine() throws IOException {
        tokenizer = new StringTokenizer(bufferedReader.readLine());
    }

    private static int getInt() {
        return Integer.parseInt(getString());
    }

    private static String getString() {
        return tokenizer.nextToken();
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
            int time = findTimeToReachDestination(x, y, sequence);
            System.out.println("Case #" + tc + ": " + (time == -1 ? "IMPOSSIBLE" : time));
        }
    }

    private static int findTimeToReachDestination(int x, int y, String sequence) {
        List<int[]> positions = new ArrayList<>();
        positions.add(new int[]{x, y});

        for (int i = 0; i < sequence.length(); i++) {
            char direction = sequence.charAt(i);
            int[] prevPosition = positions.get(i);
            int newX = prevPosition[0];
            int newY = prevPosition[1];
            switch (direction) {
                case 'N':
                    newY++;
                    break;
                case 'S':
                    newY--;
                    break;
                case 'E':
                    newX++;
                    break;
                case 'W':
                    newX--;
                    break;
            }
            positions.add(new int[]{newX, newY});
        }

        Map<String, Integer> visited = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0, 0});
        return findMinimumTime(stack, positions, visited);
    }

    private static int findMinimumTime(Stack<int[]> stack, List<int[]> positions, Map<String, Integer> visited) {
        int minimumTime = -1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];
            int time = current[2];

            if (time >= positions.size()) {
                continue;
            }

            if (x == positions.get(time)[0] && y == positions.get(time)[1]) {
                minimumTime = minimumTime == -1 ? time : Math.min(minimumTime, time);
            }

            stack.push(new int[]{x + 1, y, time + 1});
            stack.push(new int[]{x - 1, y, time + 1});
            stack.push(new int[]{x, y + 1, time + 1});
            stack.push(new int[]{x, y - 1, time + 1});
            stack.push(new int[]{x, y, time + 1});
        }

        return minimumTime;
    }
}