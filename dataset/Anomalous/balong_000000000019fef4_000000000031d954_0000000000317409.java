import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.nextLine();
            String[] components = input.split(" ");
            int x = Integer.parseInt(components[0]);
            int y = Integer.parseInt(components[1]);
            String path = components[2];

            Integer minSteps = null;

            if (x == 0 && y == 0) {
                System.out.println("Case #" + caseNumber + ": 0");
                continue;
            }

            for (int i = 1; i <= path.length(); i++) {
                char direction = path.charAt(i - 1);
                switch (direction) {
                    case 'S':
                        y -= 1;
                        break;
                    case 'N':
                        y += 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                    case 'W':
                        x -= 1;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= i) {
                    minSteps = i;
                    break;
                }
            }

            if (minSteps == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + minSteps);
            }
        }
    }
}