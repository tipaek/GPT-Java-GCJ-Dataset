import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int t = 1; t <= testCases; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            String directions = scanner.nextLine();
            int steps = directions.length();
            boolean reached = false;
            int stepCount = 0;

            for (int i = 0; i < steps; i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        Y++;
                        break;
                    case 'S':
                        Y--;
                        break;
                    case 'E':
                        X++;
                        break;
                    case 'W':
                        X--;
                        break;
                }

                if (i >= (Math.abs(X) + Math.abs(Y))) {
                    reached = true;
                    stepCount = i + 1;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + t + ": " + stepCount);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}