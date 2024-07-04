import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String solve(int x, int y, int step, String path) {
        if (x == 0 && y == 0) {
            return path;
        }

        int nextStep = step * 2;

        if (x % nextStep == y % nextStep) {
            return null;
        }

        int doubleNextStep = nextStep * 2;

        if (x % nextStep == 0) {
            int newY1 = y + step;
            int newY2 = y - step;

            if (newY1 == 0) {
                String newPath = solve(x, newY1, nextStep, path + "S");
                if (newPath != null) {
                    return newPath;
                }
            }
            if (newY2 == 0) {
                String newPath = solve(x, newY2, nextStep, path + "N");
                if (newPath != null) {
                    return newPath;
                }
            }
            if (x % doubleNextStep == 0) {
                if (newY1 % doubleNextStep == 0) {
                    return solve(x, newY2, nextStep, path + "N");
                } else {
                    return solve(x, newY1, nextStep, path + "S");
                }
            } else {
                if (newY1 % doubleNextStep == 0) {
                    return solve(x, newY1, nextStep, path + "S");
                } else {
                    return solve(x, newY2, nextStep, path + "N");
                }
            }
        } else {
            if (y % nextStep != 0) {
                return null;
            }

            int newX1 = x + step;
            int newX2 = x - step;

            if (newX1 == 0) {
                String newPath = solve(newX1, y, nextStep, path + "W");
                if (newPath != null) {
                    return newPath;
                }
            }
            if (newX2 == 0) {
                String newPath = solve(newX2, y, nextStep, path + "E");
                if (newPath != null) {
                    return newPath;
                }
            }
            if (y % doubleNextStep == 0) {
                if (newX1 % doubleNextStep == 0) {
                    return solve(newX2, y, nextStep, path + "E");
                } else {
                    return solve(newX1, y, nextStep, path + "W");
                }
            } else {
                if (newX1 % doubleNextStep == 0) {
                    return solve(newX1, y, nextStep, path + "W");
                } else {
                    return solve(newX2, y, nextStep, path + "E");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            String result = solve(x, y, 1, "");

            if (result != null) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        in.close();
    }
}