import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
            String caseStr = scanner.nextLine();
            String[] components = caseStr.split(" ");
            int x = Integer.parseInt(components[0]);
            int y = Integer.parseInt(components[1]);
            String path = components[2];

            if (x == 0 && y == 0) {
                System.out.println("Case #" + caseNum + ": 0");
                continue;
            }

            boolean found = false;
            for (int i = 1; i <= path.length(); i++) {
                char direction = path.charAt(i - 1);
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
                if (Math.abs(x) + Math.abs(y) <= i) {
                    System.out.println("Case #" + caseNum + ": " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}