import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char[] path = scanner.nextLine().trim().toCharArray();
            int currentRound = 0;
            boolean caught = false;
            int invalidRounds = 0;

            while (!caught && currentRound < path.length) {
                switch (path[currentRound]) {
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
                    default:
                        invalidRounds++;
                }

                currentRound++;

                if (currentRound - invalidRounds >= Math.abs(x) + Math.abs(y)) {
                    caught = true;
                }
            }

            currentRound -= invalidRounds;
            System.out.println("Case #" + (i + 1) + ": " + (caught ? currentRound : "IMPOSSIBLE"));
        }

        scanner.close();
    }
}