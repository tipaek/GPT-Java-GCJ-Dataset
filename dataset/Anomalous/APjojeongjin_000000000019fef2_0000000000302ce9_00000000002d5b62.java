import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            String result = findPath(x, y);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static class Step {
        long x, y;
        int power;
        String path;

        Step(long x, long y, int power, String path) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.path = path;
        }
    }

    private static String findPath(long x, long y) {
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(x, y, 0, ""));
        int error = 0;

        while (!queue.isEmpty()) {
            error++;
            if (error == 300000) break;

            Step current = queue.poll();
            long powerValue = (long) Math.pow(2, current.power);
            if (powerValue > 2000000000) break;

            if (current.x == 0 && current.y == 0) {
                return current.path;
            }

            if (Math.pow(current.x, 2) + Math.pow(current.y, 2) <= powerValue) {
                continue;
            }

            queue.add(new Step(current.x - powerValue, current.y, current.power + 1, current.path + "E"));
            queue.add(new Step(current.x + powerValue, current.y, current.power + 1, current.path + "W"));
            queue.add(new Step(current.x, current.y + powerValue, current.power + 1, current.path + "S"));
            queue.add(new Step(current.x, current.y - powerValue, current.power + 1, current.path + "N"));
        }

        return queue.isEmpty() || error == 300000 ? "IMPOSSIBLE" : "";
    }
}