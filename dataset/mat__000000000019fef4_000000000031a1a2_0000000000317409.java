import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();

            String output = path(x, y, m);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String path(int x, int y, String m) {

        int numberOfSteps = m.length();
        int distance = Math.abs(x) + Math.abs(y);

        if (distance > numberOfSteps * 2) {
            return "IMPOSSIBLE";
        }

        int i = 0;

        while (i < numberOfSteps) {

            if (m.charAt(i) == 'S') {
                y--;
            } else if (m.charAt(i) == 'N') {
                y++;
            } else if (m.charAt(i) == 'W') {
                x--;
            } else if (m.charAt(i) == 'E') {
                x++;
            }
            i++;

            distance = Math.abs(x) + Math.abs(y);
            if (distance <= i) {
                return String.valueOf(i);
            }
        }

        return "IMPOSSIBLE";

    }


}
