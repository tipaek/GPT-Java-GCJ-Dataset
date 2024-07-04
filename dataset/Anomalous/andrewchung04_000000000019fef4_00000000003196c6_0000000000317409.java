import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            boolean isPossible = false;

            for (int moveIndex = 0; moveIndex < moves.length(); moveIndex++) {
                char move = moves.charAt(moveIndex);
                switch (move) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= moveIndex + 1) {
                    System.out.println("Case #" + testCaseIndex + ": " + (moveIndex + 1));
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCaseIndex + ": IMPOSSIBLE");
            }
        }
    }
}