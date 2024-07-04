import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int x, y, maxDistance;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            int x = in.nextInt();
            int y = in.nextInt();
            String res = calculate(x, y);
            System.out.println("Case #" + t + ": " + res);
        }
    }

    private static String calculate(int x, int y)
    {
        int maxDistance = Math.abs(x) + Math.abs(y);
        return calculate(x, y, maxDistance, 1, 0, 0, "");
    }


    private static String calculate(int x, int y, int maxDistance, int iteration, int curX, int curY, String s)
    {
        int jump = (int)Math.pow(2, iteration - 1);
        if (jump > maxDistance * 2) {
            return "IMPOSSIBLE";
        }

        if (curX == x && curY == y) {
            return s;
        }

        String[] results = new String[4];
        results[0] = calculate(x, y, maxDistance, iteration + 1, curX, curY + jump, s + 'N');
        results[1] = calculate(x, y, maxDistance, iteration + 1, curX, curY - jump, s + 'S');
        results[2] = calculate(x, y, maxDistance, iteration + 1, curX - jump, curY, s + 'W');
        results[3] = calculate(x, y, maxDistance, iteration + 1, curX + jump, curY, s + 'E');

        String solution = "";
        for (int j = 0; j < 4; j++) {
            if (results[j] != "IMPOSSIBLE" && (solution == "" || results[j].length() < solution.length())) {
                solution = results[j];
            }
        }
        if (solution == "") {
            solution = "IMPOSSIBLE";
        }

        return  solution;
    }
}
