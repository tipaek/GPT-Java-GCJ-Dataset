import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int caseNumber, int x, int y) {
        String route;
        if ((x + y) % 2 == 0) {
            route = "IMPOSSIBLE";
        } else {
            int totalDistance = Math.abs(x) + Math.abs(y);
            int currentSum = 0;
            int step = 1;
            List<Integer> steps = new ArrayList<>();
            while (currentSum < totalDistance) {
                currentSum += step;
                steps.add(step);
                step *= 2;
            }
            route = findRoute(x, y, steps);
        }
        System.out.println("Case #" + caseNumber + ": " + route);
    }

    public static String findRoute(int x, int y, List<Integer> steps) {
        StringBuilder route = new StringBuilder();
        for (int i = steps.size() - 1; i >= 0; i--) {
            int step = steps.get(i);
            if (Math.abs(x) > Math.abs(y)) {
                if (x > 0) {
                    route.append('E');
                    x -= step;
                } else {
                    route.append('W');
                    x += step;
                }
            } else {
                if (y > 0) {
                    route.append('N');
                    y -= step;
                } else {
                    route.append('S');
                    y += step;
                }
            }
        }
        return route.reverse().toString();
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