import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int xPos = 0, yPos = 0;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            String directions = scanner.nextLine();

            boolean isPossible = false;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                int time = i + 1;

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

                int distance = Math.abs(x - xPos) + Math.abs(y - yPos);
                if (distance <= time) {
                    System.out.println("Case #" + caseNumber + ": " + time);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
            testCases--;
        }
    }
}