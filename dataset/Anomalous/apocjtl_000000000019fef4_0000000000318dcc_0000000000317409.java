import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];

            boolean reachable = false;
            int steps = 0;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);

                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    reachable = true;
                    steps = i + 1;
                    break;
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (reachable) {
                System.out.println(steps);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}