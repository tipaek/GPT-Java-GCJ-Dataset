import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in);
        }
    }

    private static void findSolution(int index, Scanner in) {
        String[] input = in.nextLine().split(" ");

        int relativeX = Integer.parseInt(input[0]);
        int relativeY = Integer.parseInt(input[1]);
        String path = input[2];

        int[][] route = getRoute(relativeX, relativeY, path);

        int turn = -1;
        for(int i = 0; i < route.length; i++) {
//            System.err.println(Arrays.toString(route[i]) + "; " + getManhattanDistance(route[i]));
            if(getManhattanDistance(route[i]) <= i) {
                turn = i;
                break;
            }
        }

        String result = turn == -1 ? "IMPOSSIBLE" : "" + turn;
        System.out.println(String.format("Case #%s: %s", index, result));
    }

    private static int[][] getRoute(int relativeX, int relativeY, String path) {
        int[][] route = new int[path.length() + 1][];

        route[0] = new int[]{relativeX, relativeY};
        for(int step = 1; step <= path.length(); step++) {
            char direction = path.charAt(step - 1);
            int[] currentPosition = route[step - 1];

            switch (direction) {
                case 'N':
                    route[step] = new int[] {currentPosition[0], currentPosition[1] + 1};
                    break;
                case 'S':
                    route[step] = new int[] {currentPosition[0], currentPosition[1] - 1};
                    break;
                case 'W':
                    route[step] = new int[] {currentPosition[0] - 1, currentPosition[1]};
                    break;
                case 'E':
                    route[step] = new int[] {currentPosition[0] + 1, currentPosition[1]};
                    break;
            }
        }

        return route;
    }

    private static int getManhattanDistance(int[] target) {
        return Math.abs(target[0]) + Math.abs(target[1]);
    }
}
