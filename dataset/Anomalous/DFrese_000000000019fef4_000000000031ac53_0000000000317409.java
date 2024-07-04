import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int startX = Integer.parseInt(input[0]);
        int startY = Integer.parseInt(input[1]);
        String path = input[2];

        int[][] route = calculateRoute(startX, startY, path);
        int resultTurn = findTurn(route);

        String result = resultTurn == -1 ? "IMPOSSIBLE" : String.valueOf(resultTurn);
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }

    private static int[][] calculateRoute(int startX, int startY, String path) {
        int[][] route = new int[path.length() + 1][2];
        route[0] = new int[]{startX, startY};

        for (int step = 1; step <= path.length(); step++) {
            char direction = path.charAt(step - 1);
            int[] previousPosition = route[step - 1];

            switch (direction) {
                case 'N':
                    route[step] = new int[]{previousPosition[0], previousPosition[1] + 1};
                    break;
                case 'S':
                    route[step] = new int[]{previousPosition[0], previousPosition[1] - 1};
                    break;
                case 'E':
                    route[step] = new int[]{previousPosition[0] + 1, previousPosition[1]};
                    break;
                case 'W':
                    route[step] = new int[]{previousPosition[0] - 1, previousPosition[1]};
                    break;
            }
        }

        return route;
    }

    private static int findTurn(int[][] route) {
        for (int i = 0; i < route.length; i++) {
            if (calculateManhattanDistance(route[i]) <= i) {
                return i;
            }
        }
        return -1;
    }

    private static int calculateManhattanDistance(int[] position) {
        return Math.abs(position[0]) + Math.abs(position[1]);
    }
}