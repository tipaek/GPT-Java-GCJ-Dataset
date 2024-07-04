import java.util.Scanner;

public class Solution {

//    static Map<Cord, String> ansMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_case = scanner.nextInt();
        for (int testcase = 1; testcase <= num_case; testcase++) {
//            ansMap = new HashMap<>();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String ans = findAns(0, 0, 1, x, y, "");
            if (ans == null) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcase + ": " + ans);
            }
        }
    }

    static String findAns(int x, int y, int jump, int xTarget, int yTarget, String steps) {
//        if (ansMap.containsKey(new Cord(x, y, jump))) {
////            System.out.println("contains: " + x + " " + y + " : " + ansMap.get(new Pair<>(x, y)));
//            return ansMap.get(new Cord(x, y, jump));
//        }
        if (x - jump == xTarget && y == yTarget) {
            return steps + "W";
        }
        if (x == xTarget - jump && y == yTarget) {
            return steps + "E";
        }
        if (x == xTarget && y - jump == yTarget) {
            return steps + "S";
        }
        if (x == xTarget && y == yTarget - jump) {
            return steps + "N";
        }

        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if (jump - Math.abs(xTarget) > Math.abs(yTarget)) {
            return null;
        }

        int shortest = Integer.MAX_VALUE;
        String shortestAns = null;

        String ans = findAns(x, y + jump, jump * 2, xTarget, yTarget, steps + "N");
        if (ans != null) {
//            ansMap.put(new Cord(x, y, jump), ans);
            return ans;
        }
        
        ans = findAns(x - jump, y, jump * 2, xTarget, yTarget, steps + "W");
        if (ans != null) {
//            ansMap.put(new Cord(x, y, jump), ans);
            return ans;
        }
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
        ans = findAns(x + jump, y, jump * 2, xTarget, yTarget, steps + "E");
        if (ans != null) {
//            ansMap.put(new Cord(x, y, jump), ans);
            return ans;
        }
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
        ans = findAns(x, y - jump, jump * 2, xTarget, yTarget, steps + "S");
        if (ans != null) {
//            ansMap.put(new Cord(x, y, jump), ans);
            return ans;
        }
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
        
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }

//        ansMap.put(new Cord(x, y, jump), shortestAns);
//        return shortestAns;
//        ansMap.put(new Cord(x, y, jump), null);
        return null;
    }
}

class Cord {
    int x;
    int y;
    int jump;
    public Cord(int x, int y, int jump) {
        this.x = x;
        this.y = y;
        this.jump = jump;
    }
}
