import java.util.Scanner;

public class Solution {

    static Scanner sc;
    static int x;
    static int y;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        final int testCaseCount = sc.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            System.out.println("Case #" + i + ": " + process());
        }
    }

    private static String process() {
        x = sc.nextInt();
        y = sc.nextInt();
        String m = sc.nextLine().trim();

        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == 'N') {
                y++;
            } else if (m.charAt(i) == 'S') {
                y--;
            } else if (m.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
            int distance = Math.abs(x) + Math.abs(y);

            if (distance <= i + 1) {
                return String.valueOf(i + 1);
            }

        }
        return "IMPOSSIBLE";
    }
}
