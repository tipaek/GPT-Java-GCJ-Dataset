import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            String result = "IMPOSSIBLE";

            for (int i = 0; i < M.length(); i++) {
                char direction = M.charAt(i);
                if (direction == 'N') {
                    Y++;
                } else if (direction == 'S') {
                    Y--;
                } else if (direction == 'E') {
                    X++;
                } else if (direction == 'W') {
                    X--;
                }

                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    result = String.valueOf(i + 1);
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}