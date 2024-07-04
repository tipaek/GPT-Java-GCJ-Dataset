import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<Cord, String> ansMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int testcase = 1; testcase <= numCases; testcase++) {
            ansMap.clear();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = findPath(0, 0, 1, x, y, "");
            if (result == null) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcase + ": " + result);
            }
        }
        scanner.close();
    }

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        Cord currentCord = new Cord(x, y, jump);
        if (ansMap.containsKey(currentCord)) {
            return ansMap.get(currentCord);
        }
        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if (jump > Math.abs(xTarget - x) + Math.abs(yTarget - y)) {
            return null;
        }

        String[] directions = {"W", "E", "S", "N"};
        int[][] moves = {
            {x - jump, y}, 
            {x + jump, y}, 
            {x, y - jump}, 
            {x, y + jump}
        };

        for (int i = 0; i < 4; i++) {
            String newSteps = findPath(moves[i][0], moves[i][1], jump * 2, xTarget, yTarget, steps + directions[i]);
            if (newSteps != null) {
                ansMap.put(currentCord, newSteps);
                return newSteps;
            }
        }

        ansMap.put(currentCord, null);
        return null;
    }
}

class Cord {
    int x, y, jump;

    public Cord(int x, int y, int jump) {
        this.x = x;
        this.y = y;
        this.jump = jump;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cord cord = (Cord) obj;
        return x == cord.x && y == cord.y && jump == cord.jump;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * x + y) + jump;
    }
}