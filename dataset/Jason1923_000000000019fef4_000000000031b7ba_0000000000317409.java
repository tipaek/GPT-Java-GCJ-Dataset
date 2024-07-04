import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {
    private static final boolean DEBUG = false;
    private static final String DEBUG_INPUT_PATH = "Round 1C/src/Problem1/sample.in";

    private static String solve(int X, int Y, String M) {
        M = M.replaceAll("\\s", "");
        int moves = 0;
        int min = 9999999;
        for (char c : M.toCharArray()) {
            int distance = Math.abs(X) + Math.abs(Y);
            if (distance <= moves)
                min = Math.min(moves, min);
            if (c == 'N') {
                Y++;
                moves++;
            } else if (c == 'E') {
                X++;
                moves++;
            } else if (c == 'S') {
                Y--;
                moves++;
            } else if (c == 'W') {
                X--;
                moves++;
            }
        }
        int distance = Math.abs(X) + Math.abs(Y);
        if (distance <= moves)
            min = Math.min(moves, min);
        if (min == 9999999)
            return "IMPOSSIBLE";
        else
            return min + "";
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(DEBUG_INPUT_PATH) : System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int test = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= test; t++) {

            // Custom code
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.nextLine();
            String result = solve(X, Y, M);
            // End of custom code

            System.out.println("Case #" + t + ": " + result);
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}
