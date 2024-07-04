import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int time = 0;

            if (x == 0 && y == 0) {
                result.append("Case #").append(t).append(": 0\n");
                continue;
            }

            boolean reached = false;
            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                time++;
                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= time) {
                    result.append("Case #").append(t).append(": ").append(time).append("\n");
                    reached = true;
                    break;
                }
            }
            if (!reached) {
                result.append("Case #").append(t).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(result);
    }
}