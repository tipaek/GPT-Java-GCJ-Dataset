import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            scanner.nextLine();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            System.out.println("Case #" + testCase + ": " + getTimeToReach(x, y, path));
        }
        scanner.close();
    }

    private static String getTimeToReach(int x, int y, String path) {
        for (int i = 0; i < path.length(); i++) {
            int time = Math.abs(x) + Math.abs(y);
            if (time <= i) {
                return String.valueOf(i);
            } else {
                switch (path.charAt(i)) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }
            }
        }
        int finalTime = Math.abs(x) + Math.abs(y);
        return finalTime <= path.length() ? String.valueOf(path.length()) : IMPOSSIBLE;
    }
}