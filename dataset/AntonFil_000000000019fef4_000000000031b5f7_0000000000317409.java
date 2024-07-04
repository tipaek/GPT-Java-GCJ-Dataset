import java.util.Scanner;

class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();

        for (int i = 1; i <= testsCount; i++) {
            sc.nextLine();
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();
            System.out.println("Case #" + i + ": " + reachPoint(x, y, path));
        }
        sc.close();
    }

    private static String reachPoint(int x, int y, String path) {
        int i;
        int time = -1;
        for (i = 0; i < path.length(); i++) {
            time = abs(x) + abs(y);
            if (time <= i) {
                return String.valueOf(i);
            } else {
                if (path.charAt(i) == 'S') {
                    y--;
                } else if (path.charAt(i) == 'N') {
                    y++;
                } else if (path.charAt(i) == 'W') {
                    x--;
                } else if (path.charAt(i) == 'E') {
                    x++;
                }
            }
        }
        time = abs(x) + abs(y);
        return time <= i ? String.valueOf(i) : IMPOSSIBLE;
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }
}