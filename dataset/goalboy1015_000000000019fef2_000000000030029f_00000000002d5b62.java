import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            System.out.println(String.format("Case #%d: %s", tc, solve(X, Y)));
        }

        sc.close();

        // for (int X = 0; X <= 4; ++X) {
        // for (int Y = X; Y <= 4; ++Y) {
        // String result = solve(X, Y);
        // // if (result.equals("IMPOSSIBLE")) {
        // System.out.println("X: " + X + ", Y: " + Y + " -> " + result);
        // // }
        // }
        // }
    }

    static String solve(int X, int Y) {
        long currentX = Math.abs(X);
        long currentY = Math.abs(Y);

        StringBuilder moves = new StringBuilder();
        for (long mask = 1; mask <= currentX || mask <= currentY; mask *= 2) {
            int digitX = ((currentX & mask) == 0) ? 0 : 1;
            int digitY = ((currentY & mask) == 0) ? 0 : 1;

            if (digitX == 1) {
                if (digitY == 1) {
                    if (mask == 1) {
                        return "IMPOSSIBLE";
                    }

                    int prevX = ((currentX & (mask / 2)) == 0) ? 0 : 1;
                    if (prevX == 1) {
                        moves.setCharAt(moves.length() - 1, 'W');
                        moves.append('N');

                        currentX += mask / 2;
                    } else {
                        moves.setCharAt(moves.length() - 1, 'S');
                        moves.append('E');

                        currentY += mask / 2;
                    }
                } else {
                    moves.append('E');
                }
            } else {
                if (digitY == 1) {
                    moves.append('N');
                } else {
                    if (mask == 1) {
                        return "IMPOSSIBLE";
                    }

                    int prevX = ((currentX & (mask / 2)) == 0) ? 0 : 1;
                    if (prevX == 1) {
                        moves.setCharAt(moves.length() - 1, 'W');
                        moves.append('E');

                        currentX += mask;
                    } else {
                        moves.setCharAt(moves.length() - 1, 'S');
                        moves.append('N');

                        currentY += mask;
                    }
                }
            }
        }

        String result = moves.toString();
        if (X < 0) {
            result = result.replace('E', '|').replace('W', 'E').replace('|', 'W');
        }
        if (Y < 0) {
            result = result.replace('N', '|').replace('S', 'N').replace('|', 'S');
        }

        return result;
    }
}