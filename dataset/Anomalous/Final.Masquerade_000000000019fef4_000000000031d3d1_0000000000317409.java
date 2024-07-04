import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        TestSolver solver = new TestSolver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.solveTestCase(i, reader);
        }
    }

    static class TestSolver {

        public void solveTestCase(int testCaseNumber, BufferedReader reader) throws IOException {
            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];
            int totalMoves = x + y;
            int pathLength = path.length();

            for (int i = 0; i <= pathLength; i++) {
                if (i >= totalMoves) {
                    System.out.println("Case #" + testCaseNumber + ": " + i);
                    return;
                } else {
                    if (i < pathLength) {
                        char direction = path.charAt(i);
                        if (direction == 'S' || direction == 'W') {
                            totalMoves--;
                        } else {
                            totalMoves++;
                        }
                    }
                }
            }

            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        }
    }
}