import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(new File("./data_R1C/dataA.in"));

        int T = scan.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            Input in = readInput(scan);
            String sol = solve(in);
            System.out.println("Case #" + ks + ": " + sol);
        }
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
                return curX - 1;
            case "E":
                return curX + 1;
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