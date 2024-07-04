
import java.util.Scanner;


public class Solution {
    int X;
    int Y;
    int mineX;
    int mineY;
    String M;


    public Solution(int x, int y, String m) {
        X = x;
        Y = y;
        M = m;
        mineX = 0;
        mineY = 0;
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new java.io.FileInputStream("cat.in"));
        //Scanner in = new Scanner(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();
            Solution cat = new Solution(X, Y, M);
            System.out.println("Case #" + t + ": " + cat.compute());
        }
        in.close();
    }

    public String compute() {
        int steps = 0;
        //System.out.println("cat (" + X + ";" + Y + ")");
        // System.out.println("me (" + mineX + ";" + mineY + ")");
        for (char c : M.toCharArray()) {
            steps++;
            switch (String.valueOf(c)) {
                case "N":
                    Y++;
                    break;
                case "S":
                    Y--;
                    break;
                case "E":
                    X++;
                    break;
                case "W":
                    X--;
                    break;
                default:
                    break;
            }

            switch (String.valueOf(chhoseDirection(steps))) {
                case "N":
                    mineY++;
                    break;
                case "S":
                    mineY--;
                    break;
                case "E":
                    mineX++;
                    break;
                case "W":
                    mineX--;
                    break;
                default:
                    break;
            }
            //System.out.println("cat (" + X + ";" + Y + ")");
            //System.out.println("me (" + mineX + ";" + mineY + ")");

            if (X == mineX && Y == mineY) {
                return String.valueOf(steps);
            }

        }
        return "IMPOSSIBLE";
    }


    private String chhoseDirection(int steps) {
        int deltaX = X - mineX;
        int deltaY = Y - mineY;
        if (abs(deltaY) == abs(deltaX) && abs(deltaX) == 1) {
            return seeFuture(steps);
        }

        if (abs(deltaY) > abs(deltaX)) {
            return deltaY == 0 ? "" : (deltaY > 0 ? "N" : "S");
        } else { //if (abs(deltaY) < abs(deltaX)) {
            return deltaX == 0 ? "" : (deltaX > 0 ? "E" : "W");
        }
    }

    private String seeFuture(int steps) {
        if (steps < M.toCharArray().length - 1) {
            int currentY = Y;
            int currentX = X;
            switch (String.valueOf(M.charAt(steps + 1))) {
                case "N":
                    currentY++;
                    break;
                case "S":
                    currentY--;
                    break;
                case "E":
                    currentX++;
                    break;
                case "W":
                    currentX--;
                    break;
                default:
                    break;
            }

            int deltaX2 = currentX - mineX;
            int deltaY2 = currentY - mineY;
            if (abs(deltaY2) > abs(deltaX2)) {
                return deltaY2 == 0 ? "" : (deltaY2 > 0 ? "N" : "S");
            } else {
                return deltaX2 == 0 ? "" : (deltaX2 > 0 ? "E" : "W");
            }
        }
        return "";
    }


    private int abs(int x) {
        if (x < 0) {
            return x * -1;
        }
        return x;
    }
}
