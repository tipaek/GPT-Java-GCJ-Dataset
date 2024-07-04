import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            boolean found = false;

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }

                if (isPossible(x, y, j + 1)) {
                    resultBuilder.append("Case #").append(i).append(": ").append(j + 1).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                resultBuilder.append("Case #").append(i).append(": IMPOSSIBLE").append("\n");
            }
        }

        System.out.print(resultBuilder);
    }

    private static boolean isPossible(int x, int y, int steps) {
        return Math.abs(x) + Math.abs(y) <= steps;
    }
}