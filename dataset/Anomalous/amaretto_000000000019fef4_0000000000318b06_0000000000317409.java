import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int minSteps = Integer.MAX_VALUE;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            int steps = 0;

            for (int i = 0; i < movements.length(); i++) {
                steps++;
                char move = movements.charAt(i);

                switch (move) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= steps) {
                    minSteps = Math.min(steps, minSteps);
                }
            }

            if (minSteps != Integer.MAX_VALUE) {
                System.out.println("Case #" + testCase + ": " + minSteps);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}