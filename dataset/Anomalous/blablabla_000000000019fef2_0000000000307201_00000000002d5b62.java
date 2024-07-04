import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String result = findPath(x, y, 0, 0, 1, "");
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    private static String findPath(int goalX, int goalY, int currentX, int currentY, int move, String path) {
        if (currentX == goalX && currentY == goalY) {
            return path;
        }
        if (move > 10) {
            return "IMPOSSIBLE";
        }

        int jumpDistance = (int) Math.pow(2, move - 1);
        move++;

        String north = findPath(goalX, goalY, currentX, currentY + jumpDistance, move, path + "N");
        String south = findPath(goalX, goalY, currentX, currentY - jumpDistance, move, path + "S");
        String east = findPath(goalX, goalY, currentX + jumpDistance, currentY, move, path + "E");
        String west = findPath(goalX, goalY, currentX - jumpDistance, currentY, move, path + "W");

        return Stream.of(north, south, east, west)
                .filter(result -> !result.equals("IMPOSSIBLE"))
                .min(Comparator.comparingInt(String::length))
                .orElse("IMPOSSIBLE");
    }
}