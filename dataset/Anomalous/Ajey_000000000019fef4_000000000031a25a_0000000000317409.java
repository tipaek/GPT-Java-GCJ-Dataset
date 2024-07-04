import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();
            int steps = 0;

            for (steps = 0; steps < movements.length(); steps++) {
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    break;
                }

                char move = movements.charAt(steps);
                switch (move) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }

            if (steps == movements.length() && Math.abs(x) + Math.abs(y) > steps) {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCaseNumber + ": " + steps);
            }
        }

        scanner.close();
    }
}