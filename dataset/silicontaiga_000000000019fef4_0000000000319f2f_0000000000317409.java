import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        outer:
        for (int tt = 0; tt < t; tt++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            final String m = scanner.next();

            int step = 0;

            if (x == 0 && y == 0) {
                System.out.printf("Case #%d: %d\n", tt, step);
                continue;
            }

            for (char c : m.toCharArray()) {
                step++;
                switch (c) {
                    case 'N':
                        y += 1;
                        break;
                    case 'S':
                        y -= 1;
                        break;
                    case 'W':
                        x -= 1;
                        break;
                    case 'E':
                        x += 1;
                        break;
                }

                int dist = Math.abs(x) + Math.abs(y);
                if (dist <= step) {
                    System.out.printf("Case #%d: %d\n", tt, step);
                    continue outer;
                }
            }

            System.out.printf("Case #%d: IMPOSSIBLE\n", tt);
        }
    }
}
