import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            processTestCase();
        }
    }

    private static void processTestCase() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String movements = scanner.next();
        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < movements.length(); i++) {
            char direction = movements.charAt(i);
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
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                minSteps = i + 1;
                break;
            }
        }

        if (minSteps < Integer.MAX_VALUE) {
            System.out.println(minSteps);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}