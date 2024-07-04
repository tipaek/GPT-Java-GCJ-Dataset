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
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder results = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String moves = input[2];
            int[][] positions = new int[moves.length()][2];

            for (int i = 0; i < moves.length(); i++) {
                positions[i] = move(x, y, moves.charAt(i));
                x = positions[i][0];
                y = positions[i][1];
            }

            int minPath = findMinPath(positions);
            String result = minPath == -1 ? "IMPOSSIBLE" : Integer.toString(minPath);
            results.append("Case #").append(t + 1).append(": ").append(result).append("\n");
        }

        System.out.print(results);
    }
}