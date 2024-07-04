import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            int length = directions.length();
            boolean isPossible = false;

            if (x + y > 2 * length) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            for (int i = 0; i < length; i++) {
                char direction = directions.charAt(i);
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

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.println("Case #" + caseNumber + ": " + (i + 1));
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}