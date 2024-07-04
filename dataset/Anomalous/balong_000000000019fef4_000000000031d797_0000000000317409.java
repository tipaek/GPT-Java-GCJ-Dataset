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

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];

            Integer minSteps = null;

            if (x == 0 && y == 0) {
                System.out.println("Case #" + caseIndex + ": 0");
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
                    System.out.println("Case #" + caseIndex + ": " + minSteps);
                    break;
                }
            }

            if (minSteps == null) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            }
        }
    }
}