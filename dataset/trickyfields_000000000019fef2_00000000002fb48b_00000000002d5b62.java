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
        int jump = 1;
        StringBuilder sb = new StringBuilder();

        do {
            int nextJump = jump * 2;

            if (x % nextJump != 0 && y % nextJump != 0) {
                return "IMPOSSIBLE";
            } else if (Math.abs(x) == jump) {
                if (x > 0) {
                    sb.append("E");
                    x -= jump;
                } else {
                    sb.append("W");
                    x += jump;
                }
            } else if (Math.abs(y) == jump) {
                if (y > 0) {
                    sb.append("N");
                    y -= jump;
                } else {
                    sb.append("S");
                    y += jump;
                }
            } else {
                if (x % nextJump != 0) {
                    if ((x - jump) % nextJump == 0 && Math.abs(x - jump) != Math.abs(y)) {
                        sb.append("E");
                        x -= jump;
                    } else if ((x + jump) % nextJump == 0 && Math.abs(x + jump) != Math.abs(y)) {
                        sb.append("W");
                        x += jump;
                    } else {
                        return "IMPOSSIBLE";
                    }
                } else {
                    if ((y - jump) % nextJump == 0 && Math.abs(y - jump) != Math.abs(x)) {
                        sb.append("N");
                        y -= jump;
                    } else if ((y + jump) % nextJump == 0 && Math.abs(y + jump) != Math.abs(x)) {
                        sb.append("S");
                        y += jump;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
            jump *= 2;
        } while (x != 0 || y != 0);
        return sb.toString();
    }
}
