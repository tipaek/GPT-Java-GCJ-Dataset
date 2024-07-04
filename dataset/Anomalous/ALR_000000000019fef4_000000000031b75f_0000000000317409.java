import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    static class Input {
        int X;
        int Y;
        String[] M;
        int length;

        public Input(int x, int y, String[] m) {
            this.X = x;
            this.Y = y;
            this.M = m;
            this.length = m.length;
        }

        @Override
        public String toString() {
            return "Input [X=" + X + ", Y=" + Y + ", M=" + Arrays.toString(M) + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            Input in = readInput(scan);
            String solution = solve(in);
            System.out.println("Case #" + ks + ": " + solution);
        }
        scan.close();
    }

    private static String solve(Input in) {
        int time = 0;
        int curX = in.X;
        int curY = in.Y;

        while (time <= in.length) {
            if (Math.abs(curX) + Math.abs(curY) <= time) {
                return String.valueOf(time);
            }
            if (time == in.length) {
                break;
            }
            curX = nextX(curX, time, in.M);
            curY = nextY(curY, time, in.M);
            time++;
        }

        return "IMPOSSIBLE";
    }

    private static int nextY(int curY, int timeLeft, String[] m) {
        switch (m[timeLeft]) {
            case "N":
                return curY + 1;
            case "S":
                return curY - 1;
            default:
                return curY;
        }
    }

    private static int nextX(int curX, int timeLeft, String[] m) {
        switch (m[timeLeft]) {
            case "W":
                return curX + 1;
            case "E":
                return curX - 1;
            default:
                return curX;
        }
    }

    private static Input readInput(Scanner scan) {
        int X = scan.nextInt();
        int Y = scan.nextInt();
        String M = scan.next();
        return new Input(X, Y, M.split(""));
    }
}