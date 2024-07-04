
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 1; i <= numOfCases; i++) {
            final String[] testCase = in.readLine().split(" ");
            int x = Integer.parseInt(testCase[0]);
            int y = Integer.parseInt(testCase[1]);
            String moves = testCase[2];
            String result = solve(x, y, moves);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(int x, int y, String moves) {
        for (int i = 0; i < moves.length(); i++) {
            final char move = moves.charAt(i);
            if (move == 'N') {
                y++;
            } else if (move == 'S') {
                y--;
            } else if (move == 'W') {
                x--;
            } else if (move == 'E') {
                x++;
            }
            if (dist(x, y) <= i + 1) {
                return Integer.toString(i+1);
            }
        }
        return "IMPOSSIBLE";
    }

    private static int dist(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

}
