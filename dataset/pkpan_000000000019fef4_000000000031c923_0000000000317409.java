import java.util.Scanner;


public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.nextLine();

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Case #" + tc + ": " + solve(x, y, path));
        }

        scanner.close();
    }

    static String solve(int x, int y, String path) {
        int xOffset, yOffset;

        if (x + y == 0) {
            return Integer.toString(0);
        }

        for (int i = 0 ; i < path.length() ; i++) {

            switch(path.charAt(i)) {
                case 'N':
                    xOffset = 0;
                    yOffset = 1;
                    break;
                case 'E':
                    xOffset = 1;
                    yOffset = 0;
                    break;
                case 'S':
                    xOffset = 0;
                    yOffset = -1;
                    break;
                default:
                case 'W':
                    xOffset = -1;
                    yOffset = 0;
                    break;
            }

            x = x + xOffset;
            y = y + yOffset;

            if ((Math.abs(x) + Math.abs(y)) <= (i+1)) {
                return Integer.toString(i+1);
            }
        }

        return "IMPOSSIBLE";
    }
}
