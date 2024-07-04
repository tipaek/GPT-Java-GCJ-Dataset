import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            boolean possible = false;
            int initialDistance = Math.abs(x) + Math.abs(y);
            int minimalTime = 0;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }

                int currentDistance = Math.abs(x) + Math.abs(y);
                if (currentDistance <= i + 1) {
                    minimalTime = i + 1;
                    possible = true;
                    break;
                }
            }

            if (possible) {
                output.append("Case #").append(caseNumber).append(": ").append(minimalTime).append("\n");
            } else {
                output.append("Case #").append(caseNumber).append(": IMPOSSIBLE\n");
            }

            caseNumber++;
        }

        System.out.print(output.toString());
        scanner.close();
    }
}