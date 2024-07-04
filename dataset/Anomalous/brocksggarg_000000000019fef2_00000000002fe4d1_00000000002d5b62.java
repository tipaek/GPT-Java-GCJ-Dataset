import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            new Solution().solve(i, br);
        }
    }

    private void solve(int t, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        char[] directions = determineDirections(x, y);
        x = Math.abs(x);
        y = Math.abs(y);

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        } else {
            long b = findClosestPowerOfTwo(x + y);
            String result = calculatePath(x, y, b / 2, directions);
            if (result.equals("IMPOSSIBLE")) {
                result = calculatePath(x, y, b, directions);
            }
            System.out.println("Case #" + t + ": " + (result.equals("IMPOSSIBLE") ? "IMPOSSIBLE" : result));
        }
    }

    private char[] determineDirections(int x, int y) {
        char[] directions = {'N', 'E', 'S', 'W'};
        if (x < 0) {
            directions[1] = 'W';
            directions[3] = 'E';
        }
        if (y < 0) {
            directions[0] = 'S';
            directions[2] = 'N';
        }
        return directions;
    }

    private String calculatePath(long x, long y, long b, char[] directions) {
        StringBuilder path = new StringBuilder();
        while (b != 1) {
            if (Math.abs(x) > Math.abs(y)) {
                if (x >= 0) {
                    x -= b;
                    path.insert(0, directions[1]);
                } else {
                    x += b;
                    path.insert(0, directions[3]);
                }
            } else {
                if (y >= 0) {
                    y -= b;
                    path.insert(0, directions[0]);
                } else {
                    y += b;
                    path.insert(0, directions[2]);
                }
            }
            b /= 2;
        }
        if (x == 0 && y == 1) {
            path.insert(0, directions[0]);
        } else if (x == 0 && y == -1) {
            path.insert(0, directions[2]);
        } else if (y == 0 && x == 1) {
            path.insert(0, directions[1]);
        } else if (y == 0 && x == -1) {
            path.insert(0, directions[3]);
        } else {
            return "IMPOSSIBLE";
        }
        return path.toString();
    }

    private long findClosestPowerOfTwo(int sum) {
        long power = 1;
        while (power <= sum) {
            power *= 2;
        }
        return power;
    }
}