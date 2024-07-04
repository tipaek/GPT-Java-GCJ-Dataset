import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_case = scanner.nextInt();
        for (int testcase = 1; testcase <= num_case; testcase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x + " " + y);
            String ans = findAns(0, 0, 1, x, y, "");
            if (ans == null) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcase + ": " + ans);
            }
        }
    }

    static String findAns(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if ((Math.abs(xTarget) + Math.abs(yTarget)) < jump) {
            return null;
        }

        List<String> ansList = new ArrayList<>();
        ansList.add(findAns(x - jump, y, jump * 2, xTarget, yTarget, steps + "W"));
        ansList.add(findAns(x + jump, y, jump * 2, xTarget, yTarget, steps + "E"));
        ansList.add(findAns(x, y - jump, jump * 2, xTarget, yTarget, steps + "S"));
        ansList.add(findAns(x, y + jump, jump * 2, xTarget, yTarget, steps + "N"));

        int shortest = 0;
        String shortestAns = null;

        for (String curAns : ansList) {
            if (curAns != null) {
                if (shortest == 0) {
                    shortest = curAns.length();
                    shortestAns = curAns;
                } else {
                    if (shortest > curAns.length()) {
                        shortest = curAns.length();
                        shortestAns = curAns;
                    }
                }
            }
        }

        return shortestAns;
    }
}
