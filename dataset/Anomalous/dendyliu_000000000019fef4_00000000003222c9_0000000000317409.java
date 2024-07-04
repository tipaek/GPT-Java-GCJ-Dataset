import java.util.Scanner;

public class Solution {
    private static int[] move(int x, int y, char direction) {
        switch (direction) {
            case 'N': return new int[]{x, y + 1};
            case 'S': return new int[]{x, y - 1};
            case 'E': return new int[]{x + 1, y};
            case 'W': return new int[]{x - 1, y};
            default: return new int[]{x, y};
        }
    }

    private static int findMinPath(int[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (Math.abs(x) + Math.abs(y) <= i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String moves = input[2];

            int[][] positions = new int[moves.length() + 1][2];
            positions[0][0] = x;
            positions[0][1] = y;

            for (int i = 0; i < moves.length(); i++) {
                int[] nextPosition = move(x, y, moves.charAt(i));
                positions[i + 1] = nextPosition;
                x = nextPosition[0];
                y = nextPosition[1];
            }

            int minPath = findMinPath(positions);
            String resultString = (minPath == -1) ? "IMPOSSIBLE" : String.valueOf(minPath);
            result.append("Case #").append(t + 1).append(": ").append(resultString).append("\n");
        }

        System.out.print(result);
        scanner.close();
    }
}