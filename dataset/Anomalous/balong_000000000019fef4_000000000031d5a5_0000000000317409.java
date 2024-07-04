import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String caseInput = scanner.nextLine();
            String[] components = caseInput.split(" ");
            int x = Integer.parseInt(components[0]);
            int y = Integer.parseInt(components[1]);
            String path = components[2];

            Integer minimumSteps = null;

            if (x == 0 && y == 0) {
                System.out.println("Case #" + caseNumber + ": " + 0);
                continue;
            }

            for (int step = 1; step <= path.length(); step++) {
                char direction = path.charAt(step - 1);
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

                if (Math.abs(x) + Math.abs(y) == step) {
                    minimumSteps = step;
                    System.out.println("Case #" + caseNumber + ": " + minimumSteps);
                    break;
                }
            }

            if (minimumSteps == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}