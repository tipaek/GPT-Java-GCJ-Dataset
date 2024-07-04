import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCaseCount; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseIndex, Scanner scanner) {
        String[] inputs = scanner.nextLine().split(" ");
        int startX = Integer.parseInt(inputs[0]);
        int startY = Integer.parseInt(inputs[1]);
        String path = inputs[2];

        int[][] positions = calculatePositions(startX, startY, path);
        int result = findMinimumTurn(positions);

        String output = result == -1 ? "IMPOSSIBLE" : String.valueOf(result);
        System.out.println(String.format("Case #%d: %s", caseIndex, output));
    }

    private static int[][] calculatePositions(int startX, int startY, String path) {
        int[][] positions = new int[path.length() + 1][2];
        positions[0] = new int[]{startX, startY};

        for (int step = 1; step <= path.length(); step++) {
            char direction = path.charAt(step - 1);
            int[] previousPosition = positions[step - 1];

            switch (direction) {
                case 'N':
                    positions[step] = new int[]{previousPosition[0], previousPosition[1] + 1};
                    break;
                case 'S':
                    positions[step] = new int[]{previousPosition[0], previousPosition[1] - 1};
                    break;
                case 'W':
                    positions[step] = new int[]{previousPosition[0] - 1, previousPosition[1]};
                    break;
                case 'E':
                    positions[step] = new int[]{previousPosition[0] + 1, previousPosition[1]};
                    break;
            }
        }

        return positions;
    }

    private static int findMinimumTurn(int[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            if (calculateManhattanDistance(positions[i]) <= i) {
                return i;
            }
        }
        return -1;
    }

    private static int calculateManhattanDistance(int[] position) {
        return Math.abs(position[0]) + Math.abs(position[1]);
    }
}