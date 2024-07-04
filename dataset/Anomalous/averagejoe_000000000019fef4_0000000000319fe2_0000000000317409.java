import java.util.Scanner;

public class Solution {

    private void solve() {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] movements = scanner.next().toCharArray();

            int distance = x + y;
            int minimumTime = -1;

            for (int i = 0; i < movements.length; i++) {
                switch (movements[i]) {
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

                distance = Math.abs(x) + Math.abs(y);
                if (distance - 1 <= i) {
                    minimumTime = i + 1;
                    break;
                }
            }

            if (minimumTime == -1) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
            } else {
                System.out.printf("Case #%d: %d%n", caseNumber, minimumTime);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}