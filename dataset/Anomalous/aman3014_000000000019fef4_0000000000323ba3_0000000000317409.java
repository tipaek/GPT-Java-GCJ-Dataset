import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();

            int steps = 0;
            boolean reached = false;

            while (steps < moves.length()) {
                char move = moves.charAt(steps);
                switch (move) {
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                }

                steps++;

                if (x == 0 && y == 0) {
                    reached = true;
                    break;
                }

                if (Math.abs(x) >= Math.abs(y)) {
                    if (x > 0) {
                        x--;
                    } else {
                        x++;
                    }
                } else {
                    if (y > 0) {
                        y--;
                    } else {
                        y++;
                    }
                }
            }

            if (reached) {
                System.out.println("Case #" + caseNumber + ": " + steps);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}