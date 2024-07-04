import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String directions = scanner.next();
            boolean found = false;

            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'N':
                        b++;
                        break;
                    case 'E':
                        a++;
                        break;
                    case 'S':
                        b--;
                        break;
                    case 'W':
                        a--;
                        break;
                }

                if (isPossible(a, b, j + 1)) {
                    result.append("Case #").append(i).append(": ").append(j + 1).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.append("Case #").append(i).append(": IMPOSSIBLE").append("\n");
            }
        }

        System.out.print(result);
    }

    private static boolean isPossible(int x, int y, int steps) {
        return Math.abs(x) + Math.abs(y) <= steps;
    }
}