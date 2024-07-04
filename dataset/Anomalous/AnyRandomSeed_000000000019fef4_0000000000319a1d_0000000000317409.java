import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                System.setIn(new FileInputStream(System.getProperty("user.dir") + "/src/jam2020rb_t1.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = sc.nextInt();
            for (int i = 1; i <= t; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                String s = sc.next().trim();
                System.out.printf("Case #%d: %s%n", i, solve(x, y, s));
            }
        }
    }

    private static String solve(int x, int y, String s) {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int px = x, py = y, steps = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (Math.abs(px) + Math.abs(py) <= steps) {
                return String.valueOf(steps);
            }
            if (i >= s.length()) {
                break;
            }

            switch (s.charAt(i)) {
                case 'N':
                    px += directions[0][0];
                    py += directions[0][1];
                    break;
                case 'S':
                    px += directions[1][0];
                    py += directions[1][1];
                    break;
                case 'W':
                    px += directions[2][0];
                    py += directions[2][1];
                    break;
                case 'E':
                    px += directions[3][0];
                    py += directions[3][1];
                    break;
            }
            steps++;
        }
        return "IMPOSSIBLE";
    }
}