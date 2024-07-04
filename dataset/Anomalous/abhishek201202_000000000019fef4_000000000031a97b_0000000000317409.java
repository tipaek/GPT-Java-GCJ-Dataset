import java.util.Scanner;

public class Que1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder results = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int time = 0;

            if (x == 0 && y == 0) {
                results.append("Case #").append(testCase).append(": 0\n");
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
                int requiredTime = Math.abs(x) + Math.abs(y);
                if (requiredTime <= time) {
                    results.append("Case #").append(testCase).append(": ").append(time).append("\n");
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                results.append("Case #").append(testCase).append(": IMPOSSIBLE\n");
            }
        }

        System.out.print(results);
    }
}