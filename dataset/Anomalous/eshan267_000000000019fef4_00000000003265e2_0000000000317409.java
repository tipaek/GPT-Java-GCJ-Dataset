import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int time = 0;
            boolean isPossible = false;

            for (int j = 0; j < path.length(); j++) {
                time++;
                char direction = path.charAt(j);

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

                if (time >= Math.abs(x) + Math.abs(y)) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                resultBuilder.append("Case #").append(i + 1).append(": ").append(time).append("\n");
            } else {
                resultBuilder.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            }
        }

        System.out.print(resultBuilder.toString().trim());
    }
}