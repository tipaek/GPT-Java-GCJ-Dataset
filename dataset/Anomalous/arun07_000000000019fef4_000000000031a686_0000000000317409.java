import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int minSteps = Integer.MAX_VALUE;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);

                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }

                int stepsRequired = Math.abs(x) + Math.abs(y);
                if (i + 1 >= stepsRequired && stepsRequired < minSteps) {
                    minSteps = i + 1;
                    break;
                }
            }

            if (minSteps == Integer.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + minSteps);
            }
        }

        scanner.close();
    }
}