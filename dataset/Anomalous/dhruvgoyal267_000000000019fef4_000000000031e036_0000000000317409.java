import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String path = scanner.nextLine();
            int steps = 0;
            int currentIndex = 1;

            while (currentIndex < path.length() && y > 0) {
                steps++;
                char direction = path.charAt(currentIndex);
                if (direction == 'N') {
                    y++;
                } else if (direction == 'S') {
                    y--;
                }
                currentIndex++;
            }

            if (y == 0) {
                if (steps == x) {
                    result.append(String.format("Case #%d: %d\n", caseNumber++, steps));
                } else if (steps < x) {
                    result.append(String.format("Case #%d: IMPOSSIBLE\n", caseNumber++));
                } else {
                    result.append(String.format("Case #%d: %d\n", caseNumber++, steps - x));
                }
            } else {
                result.append(String.format("Case #%d: IMPOSSIBLE\n", caseNumber++));
            }
        }
        System.out.print(result);
    }
}