import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();
            String res = calculate(x, y, path.toCharArray());
            System.out.println("Case #" + t + ": " + res);
        }
    }

    private static String calculate(int x, int y, char[] path)
    {
        if (x + y > path.length * 2) {
            return IMPOSSIBLE;
        }
        //Position[] positions = new Position[];
        int currentX = x;
        int currentY = y;
        for (int i = 0; i < path.length; i++) {
            if (path[i] ==  'S') {
                currentY--;
            } else if (path[i] == 'N') {
                currentY++;
            } else if (path[i] == 'W') {
                currentX--;
            } else {
                currentX++;
            }
            if (Math.abs(currentX) + Math.abs(currentY) <= i + 1) {
                return Integer.toString(i + 1);
            }

        }

        return IMPOSSIBLE;
    }

}
