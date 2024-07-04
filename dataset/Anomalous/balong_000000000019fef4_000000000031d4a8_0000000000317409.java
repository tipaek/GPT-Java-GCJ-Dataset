import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] inputs = scanner.nextLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            String path = inputs[2];

            if (x == 0 && y == 0) {
                System.out.println("Case #" + caseNumber + ": 0");
                continue;
            }

            boolean found = false;
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
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
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}