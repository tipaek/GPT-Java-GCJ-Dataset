import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            oneRun(i);
        }
    }

    private static void oneRun(int num) throws IOException {
        String[] tokens = br.readLine().split("\\s+");
        int X = cint(tokens[0]);
        int Y = cint(tokens[1]);

        char[] sPath = tokens[2].toCharArray();
        int min = Integer.MAX_VALUE;
        for (int time = 0; time <= sPath.length; time++) {
            if (time != 0) {
                char c = sPath[time-1];
                if (c == 'N') {
                    Y++;
                } else if (c == 'E') {
                    X++;
                } else if (c == 'S') {
                    Y--;
                } else {
                    X--;
                }
            }
            if (check(X, Y, time)) {
                System.out.println(String.format("Case #%d: %d", num, time));
                return;
            }
        }
        System.out.println(String.format("Case #%d: IMPOSSIBLE", num));
    }

    private static boolean check(int x, int y, int time) {
        return Math.abs(x) + Math.abs(y) <= time;
    }


    static int cint(String s) {
        return Integer.parseInt(s);
    }
}