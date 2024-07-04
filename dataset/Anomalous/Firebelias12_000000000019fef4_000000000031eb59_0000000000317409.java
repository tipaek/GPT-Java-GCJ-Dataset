import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < cases; i++) {
            int oX = 0, oY = 0;
            int pX = scanner.nextInt();
            int pY = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input

            String pos = scanner.nextLine();
            int min = 0;

            for (int j = 0; j < pos.length(); j++) {
                if (oX == pX && oY == pY) break;

                char direction = pos.charAt(j);
                if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'W') continue;

                switch (direction) {
                    case 'N':
                        pY++;
                        break;
                    case 'S':
                        pY--;
                        break;
                    case 'E':
                        pX++;
                        break;
                    case 'W':
                        pX--;
                        break;
                }

                if (oX == pX && oY == pY) break;

                if (oX != pX) {
                    oX++;
                } else if (oY != pY) {
                    oY++;
                }

                min++;
            }

            if (oX == pX && oY == pY) {
                System.out.println("Case #" + (i + 1) + ": " + min);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}