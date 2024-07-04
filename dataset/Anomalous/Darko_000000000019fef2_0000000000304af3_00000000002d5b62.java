import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static final int OFFSET = 100;
    private static final int LIMIT = 100;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String DIRECTIONS = "NESW";
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private final String[][] ans = new String[2 * LIMIT + 1][2 * LIMIT + 1];

    public static void main(String[] args) {
        new Solution().work();
    }

    private void work() {
        generatePaths();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if ((x + y) % 2 == 0 || Math.abs(x) > LIMIT || Math.abs(y) > LIMIT) {
                    System.out.printf("Case #%d: %s\n", caseNumber, IMPOSSIBLE);
                } else {
                    System.out.printf("Case #%d: %s\n", caseNumber, ans[x + OFFSET][y + OFFSET]);
                }
            }
        }
    }

    private void generatePaths() {
        for (int i = -LIMIT; i <= LIMIT; i++) {
            for (int j = -LIMIT; j <= LIMIT; j++) {
                ans[i + OFFSET][j + OFFSET] = IMPOSSIBLE;
            }
        }

        Queue<State> currentQueue = new LinkedList<>();
        Queue<State> nextQueue = new LinkedList<>();
        currentQueue.add(new State(0, 0, ""));
        
        for (int step = 0, power = 1; step < 10; step++, power *= 2) {
            nextQueue.clear();
            while (!currentQueue.isEmpty()) {
                State state = currentQueue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    int newX = state.x + power * DX[direction];
                    int newY = state.y + power * DY[direction];
                    String newPath = state.path + DIRECTIONS.charAt(direction);
                    if (isWithinBounds(newX, newY) && ans[newX + OFFSET][newY + OFFSET].equals(IMPOSSIBLE)) {
                        ans[newX + OFFSET][newY + OFFSET] = newPath;
                    }
                    nextQueue.add(new State(newX, newY, newPath));
                }
            }
            currentQueue.addAll(nextQueue);
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= -LIMIT && x <= LIMIT && y >= -LIMIT && y <= LIMIT;
    }

    private static class State {
        final int x, y;
        final String path;

        State(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}