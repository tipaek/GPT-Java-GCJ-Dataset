import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int caseNumber, int x, int y) {
        String route;
        if ((x + y) % 2 == 0) {
            route = "IMPOSSIBLE";
        } else {
            int sum = Math.abs(x) + Math.abs(y);
            int tempSum = 0;
            int step = 1;
            List<Integer> steps = new ArrayList<>();
            while (tempSum < sum) {
                tempSum += step;
                steps.add(step);
                step *= 2;
            }
            route = findRoute(x, y, steps);
        }
        System.out.println("Case #" + caseNumber + ": " + route);
    }

    private static String findRoute(int x, int y, List<Integer> steps) {
        StringBuilder routeBuilder = new StringBuilder();
        for (int i = steps.size() - 1; i >= 0; i--) {
            int currentStep = steps.get(i);
            if (Math.abs(x) > Math.abs(y)) {
                if (x > 0) {
                    routeBuilder.append('E');
                    x -= currentStep;
                } else {
                    routeBuilder.append('W');
                    x += currentStep;
                }
            } else {
                if (y > 0) {
                    routeBuilder.append('N');
                    y -= currentStep;
                } else {
                    routeBuilder.append('S');
                    y += currentStep;
                }
            }
        }
        return routeBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            solve(caseNumber, x, y);
        }
    }
}