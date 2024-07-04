import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int caseNumber, int X, int Y) {
        String route;
        if ((X + Y) % 2 == 0) {
            route = "IMPOSSIBLE";
        } else {
            int sum = Math.abs(X) + Math.abs(Y);
            int tempSum = 0;
            int step = 1;
            List<Integer> steps = new ArrayList<>();
            
            while (tempSum < sum) {
                tempSum += step;
                steps.add(step);
                step *= 2;
            }
            route = findRoute(X, Y, steps);
        }
        System.out.println("Case #" + caseNumber + ": " + route);
    }

    private static String findRoute(int X, int Y, List<Integer> steps) {
        StringBuilder routeBuilder = new StringBuilder();
        for (int i = steps.size() - 1; i >= 0; i--) {
            int currentStep = steps.get(i);
            if (Math.abs(X) > Math.abs(Y)) {
                if (X > 0) {
                    routeBuilder.append('E');
                    X -= currentStep;
                } else {
                    routeBuilder.append('W');
                    X += currentStep;
                }
            } else {
                if (Y > 0) {
                    routeBuilder.append('N');
                    Y -= currentStep;
                } else {
                    routeBuilder.append('S');
                    Y += currentStep;
                }
            }
        }
        return routeBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            solve(caseNumber, X, Y);
        }
    }
}