import java.util.*;

public class Solution {
    static int targetX, targetY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            TreeSet<String> solutions = new TreeSet<>(Comparator.comparingInt(String::length));
            findPath(0, 0, 0, "", solutions);
            System.out.printf("Case #%d: %s\n", t, solutions.isEmpty() ? "IMPOSSIBLE" : solutions.first());
        }
        scanner.close();
    }

    private static void findPath(int currentX, int currentY, int step, String path, TreeSet<String> solutions) {
        if (!solutions.isEmpty() && step > solutions.first().length() || Math.abs(currentX + currentY) > Math.abs(targetX + targetY)) {
            return;
        }
        if (currentX == targetX && currentY == targetY) {
            solutions.add(path);
        } else {
            int jumpDistance = (int) Math.pow(2, step);
            findPath(currentX + jumpDistance, currentY, step + 1, path + "E", solutions);
            findPath(currentX - jumpDistance, currentY, step + 1, path + "W", solutions);
            findPath(currentX, currentY + jumpDistance, step + 1, path + "N", solutions);
            findPath(currentX, currentY - jumpDistance, step + 1, path + "S", solutions);
        }
    }
}