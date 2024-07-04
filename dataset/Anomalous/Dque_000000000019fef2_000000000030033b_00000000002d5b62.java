import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int targetX = Integer.parseInt(tokenizer.nextToken());
            int targetY = Integer.parseInt(tokenizer.nextToken());

            Queue<State> queue = new LinkedList<>();
            boolean isFound = false;
            queue.add(new State(0, 0, ""));

            int maxSteps = 9;
            int[] powersOfTwo = new int[maxSteps + 1];
            powersOfTwo[0] = 1;
            for (int i = 1; i <= maxSteps; i++) {
                powersOfTwo[i] = 2 * powersOfTwo[i - 1];
            }

            while (!queue.isEmpty()) {
                State currentState = queue.poll();
                if (currentState.x == targetX && currentState.y == targetY) {
                    writer.println("Case #" + caseNumber + ": " + currentState.path);
                    isFound = true;
                    break;
                }

                if (currentState.path.length() >= maxSteps) {
                    break;
                }

                int stepIndex = currentState.path.length();
                queue.add(new State(currentState.x - powersOfTwo[stepIndex], currentState.y, currentState.path + "W"));
                queue.add(new State(currentState.x + powersOfTwo[stepIndex], currentState.y, currentState.path + "E"));
                queue.add(new State(currentState.x, currentState.y - powersOfTwo[stepIndex], currentState.path + "S"));
                queue.add(new State(currentState.x, currentState.y + powersOfTwo[stepIndex], currentState.path + "N"));
            }

            if (!isFound) {
                writer.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        writer.close();
    }

    static class State {
        int x, y;
        String path;

        State(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}