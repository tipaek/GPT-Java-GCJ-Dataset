import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int moveCount = moves.length();
            int minSteps = Integer.MAX_VALUE;
            int steps = 0;
            int distance = Math.abs(x) + Math.abs(y);

            for (int i = 0; i < moveCount; i++) {
                char move = moves.charAt(i);
                if (move == 'S') {
                    y -= 1;
                } else if (move == 'W') {
                    x -= 1;
                } else if (move == 'N') {
                    y += 1;
                } else if (move == 'E') {
                    x += 1;
                }

                steps++;
                distance = Math.abs(x) + Math.abs(y);

                if (steps >= distance) {
                    minSteps = steps;
                    break;
                }
            }

            if (distance > moveCount) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + minSteps);
            }
        }

        scanner.close();
    }
}