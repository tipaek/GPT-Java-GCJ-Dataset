import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int horizontal = 0, vertical = 0, time = 0;
            boolean isPossible = false;

            horizontal = scanner.nextInt();
            vertical = scanner.nextInt();
            String path = scanner.next();

            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'N':
                        vertical++;
                        break;
                    case 'S':
                        vertical--;
                        break;
                    case 'E':
                        horizontal++;
                        break;
                    case 'W':
                        horizontal--;
                        break;
                }
                time++;

                if (time >= Math.abs(horizontal) + Math.abs(vertical)) {
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + time);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}