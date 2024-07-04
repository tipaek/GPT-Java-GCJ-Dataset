import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * The Oversized Pancake Flipper problem from Google Code Jam Qualification 2017.
 * https://code.google.com/codejam/contest/3264486/dashboard#s=p0
 *
 * Self-explanatory algorithm proportional to the count of pancakes
 * times the filler size.
 * We process a row from left to right. Once we have a partial row of happy
 * sides up we don't touch them any more.
 * Could be optimized by skipping to the first '-' found in the previous
 * iteration, but it is more than fast enough for the large dataset as is.
 * 
 * @author Salvo Isaja
 */
public class Solution {

    private static final boolean DEBUG = false;

    private int solve(String row, int flipperSize) {
        StringBuilder sb = new StringBuilder(row);
        int flipCount = 0;
        for (int i = 0; i <= sb.length() - flipperSize; i++) {
            char c = sb.charAt(i);
            if (c == '+') continue;
            flipCount++;
            for (int j = i; j < i + flipperSize; j++) {
                c = sb.charAt(j);
                sb.setCharAt(j, c == '+' ? '-' : '+');
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '-') {
                return -1; // impossible
            }
        }
        return flipCount;
    }

    private void scanTests(InputStream is) {
        try (Scanner scanner = new Scanner(is)) {
            int testCount = scanner.nextInt();
            for (int t = 1; t <= testCount; t++) {
                String row = scanner.next();
                int flipperSize = scanner.nextInt();
                int result = solve(row, flipperSize);
                System.out.println("Case #" + t + ": " + (result >= 0 ? result : "IMPOSSIBLE"));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long t = System.nanoTime();
        OversizedPancakeFlipper opf = new OversizedPancakeFlipper();
        opf.scanTests(DEBUG ? new FileInputStream("resources/codejam2017/qualification/A-large-practice.in") : System.in);
        System.err.println("OversizedPancakeFlipper done in " + ((System.nanoTime() - t) / 1e9) + " seconds.");
    }
}