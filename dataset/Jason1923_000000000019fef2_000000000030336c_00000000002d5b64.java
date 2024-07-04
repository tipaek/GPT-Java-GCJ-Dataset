import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    private static final boolean DEBUG = false;
    private static final String DEBUG_INPUT_PATH = "Round 1B/src/Question3/custom.in";

    private static void solve(int r, int s, int t) {
        int total = (r - 1) * (s - 1);
        int size = r * s - 1;
        System.out.println("Case #" + t + ": " + total);
        for (int a = r; a >= 2; a--) {
            for (int i = 0; i < s - 1; i++) {
                System.out.println(a + ", " + (size - a));
                size--;
            }
            size--;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(DEBUG_INPUT_PATH) : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int test = Integer.parseInt(in.nextLine());
            for (int t = 1; t <= test; t++) {

                // Custom code
                int r = in.nextInt();
                int s = in.nextInt();
                solve(r, s, t);
                // End of custom code
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}

