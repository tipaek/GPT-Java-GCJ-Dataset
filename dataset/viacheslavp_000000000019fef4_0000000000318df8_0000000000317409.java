import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int solve(int x, int y, String s) {
        int currentX = x, currentY = y;
        if (x == 0 && y == 0) return 0;

        for (int i = 0; i < s.length(); ++i) {
            int currentTime = i + 1;
            switch (s.charAt(i)) {
                case 'N':
                    ++currentY;
                    break;
                case 'S':
                    --currentY;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }

            int timeRequired = Math.abs(currentX) + Math.abs(currentY);
            if (timeRequired <= currentTime) return currentTime;
        }

        return -1;
    }

    public static void main(String[] params) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; ++i) {
            String[] in = reader.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            int solution = solve(x, y, in[2]);
            System.out.println(String.format("Case #%d: %s", i + 1, solution == -1 ? "IMPOSSIBLE" : solution));
        }
    }
}
