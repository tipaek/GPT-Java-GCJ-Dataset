import java.io.*;
import java.util.*;

public class Solution {

    public static int[] move(int x, int y, char direction) {
        switch (direction) {
            case 'N': return new int[]{x, y + 1};
            case 'S': return new int[]{x, y - 1};
            case 'E': return new int[]{x + 1, y};
            case 'W': return new int[]{x - 1, y};
            default: return new int[]{x, y};
        }
    }

    public static int findMinPath(int[][] positions) {
        for (int i = 0; i < positions.length; ++i) {
            int x = positions[i][0];
            int y = positions[i][1];
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; ++t) {
            String[] input = scanner.nextLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            String moves = input[2];

            int[][] positions = new int[moves.length() + 1][2];
            positions[0][0] = startX;
            positions[0][1] = startY;

            int currentX = startX;
            int currentY = startY;

            for (int i = 0; i < moves.length(); ++i) {
                int[] nextPosition = move(currentX, currentY, moves.charAt(i));
                positions[i + 1] = nextPosition;
                currentX = nextPosition[0];
                currentY = nextPosition[1];
            }

            int minPath = findMinPath(positions);
            String resultString = (minPath == -1) ? "IMPOSSIBLE" : Integer.toString(minPath);
            result.append("Case #").append(t + 1).append(": ").append(resultString).append("\n");
        }

        System.out.print(result);
    }
}