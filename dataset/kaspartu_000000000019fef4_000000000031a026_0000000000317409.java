import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();

        for (int tc = 1; tc <= T; tc++) {
            String[] line = scanner.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            int minutes = 0;
            boolean success = false;

            while (minutes < line[2].length()) {
                if (minutes >= Math.abs(x) + Math.abs(y)) {
                    success = true;
                    break;
                }
                char c = line[2].charAt(minutes++);
                if (c == 'E') x++;
                else if (c == 'W') x--;
                else if (c == 'S') y--;
                else y++;
            }
            if (minutes >= Math.abs(x) + Math.abs(y)) success = true;
            System.out.println("Case #" + tc + ": " + (success ? minutes : "IMPOSSIBLE"));
        }
    }
}