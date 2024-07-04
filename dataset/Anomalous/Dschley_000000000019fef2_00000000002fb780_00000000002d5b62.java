import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            String path = findPath(n, m);
            System.out.println("Case #" + i + ": " + path);
        }
    }

    private static String findPath(int x, int y) {
        if (!isReachable(x, y)) {
            return "IMPOSSIBLE";
        }
        
        return searchPath(0, 0, x, y, 1, new ArrayDeque<>());
    }

    private static boolean isReachable(int x, int y) {
        return (Math.abs(x) + Math.abs(y) - 1) % 2 == 0;
    }

    private static String searchPath(int currentX, int currentY, int targetX, int targetY, int jump, Deque<String> path) {
        if (currentX == targetX && currentY == targetY) {
            StringBuilder result = new StringBuilder();
            for (String step : path) {
                result.append(step);
            }
            return result.toString();
        } else if (jump > Math.abs(targetX) + Math.abs(targetY)) {
            return null;
        }

        String result;
        // Jump north
        path.push("N");
        result = searchPath(currentX, currentY + jump, targetX, targetY, jump * 2, path);
        if (result != null) return result;
        path.pop();

        // Jump south
        path.push("S");
        result = searchPath(currentX, currentY - jump, targetX, targetY, jump * 2, path);
        if (result != null) return result;
        path.pop();

        // Jump east
        path.push("E");
        result = searchPath(currentX + jump, currentY, targetX, targetY, jump * 2, path);
        if (result != null) return result;
        path.pop();

        // Jump west
        path.push("W");
        result = searchPath(currentX - jump, currentY, targetX, targetY, jump * 2, path);
        if (result != null) return result;
        path.pop();

        return null;
    }
}