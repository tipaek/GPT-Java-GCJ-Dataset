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
        String result = "";
        char north = 'N', east = 'E', south = 'S', west = 'W';

        if (x < 0) {
            x = -x;
            east = 'W';
            west = 'E';
        }
        if (y < 0) {
            y = -y;
            north = 'S';
            south = 'N';
        }

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        } else {
            long b = get(x + y);
            result = calculatePath(x, y, b / 2, north, east, south, west);
            if (result.equals("IMPOSSIBLE")) {
                result = calculatePath(x, y, b, north, east, south, west);
                if (result.equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + t + ": " + result);
                }
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private String calculatePath(long x, long y, long b, char north, char east, char south, char west) {
        String path = "";
        while (b != 1) {
            if (Math.abs(x) > Math.abs(y)) {
                if (x >= 0) {
                    x -= b;
                    path = east + path;
                } else {
                    x += b;
                    path = west + path;
                }
            } else {
                if (y >= 0) {
                    y -= b;
                    path = north + path;
                } else {
                    y += b;
                    path = south + path;
                }
            }
            b /= 2;
        }

        if (x == 0 && y == 1) {
            path = north + path;
        } else if (x == 0 && y == -1) {
            path = south + path;
        } else if (y == 0 && x == 1) {
            path = east + path;
        } else if (y == 0 && x == -1) {
            path = west + path;
        } else {
            return "IMPOSSIBLE";
        }

        return path;
    }

    private long get(int i) {
        long a = 1;
        while (a < i) {
            a *= 2;
        }
        return a;
    }
}