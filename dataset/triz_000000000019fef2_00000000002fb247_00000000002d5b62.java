import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            String sol = solve(0, 0, targetX, targetY, 1);
            if (sol == null)
                sol = "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", i+1, sol ));
        }
    }

    private static Object parseOne(Scanner scanner) {
        return null;
    }

    private static String solve(int currentX, int currentyY, int targetX, int targetY, int currentJump) {
        String sol = null;

        if (currentX == targetX && currentyY == targetY) {
            return "";
        }

        int nextJump = currentJump * 2;
        if (isValidMove(currentX, targetX, currentJump)) {
            String candidate = solve(currentX + currentJump, currentyY, targetX, targetY, nextJump);
            if (candidate != null && (sol == null || candidate.length() < sol.length())) {
                sol = "E" + candidate;
            }
        }
        if (isValidMove(currentX, targetX, -currentJump)) {
            String candidate = solve(currentX - currentJump, currentyY, targetX, targetY, nextJump);
            if (candidate != null && (sol == null || candidate.length() < sol.length())) {
                sol = "W" + candidate;
            }
        }
        if (isValidMove(currentyY, targetY, currentJump)) {
            String candidate = solve(currentX, currentyY + currentJump, targetX, targetY, nextJump);
            if (candidate != null && (sol == null || candidate.length() < sol.length())) {
                sol = "N" + candidate;
            }
        }
        if (isValidMove(currentyY, targetY, -currentJump)) {
            String candidate = solve(currentX, currentyY -currentJump, targetX, targetY, nextJump);
            if (candidate != null && (sol == null || candidate.length() < sol.length())) {
                sol = "S" + candidate;
            }
        }
        return sol;
    }

    private static boolean isValidMove(int currentPos, int targetPos, int distance) {
        return Math.abs(currentPos + distance) <= Math.abs(targetPos);
    }
}
