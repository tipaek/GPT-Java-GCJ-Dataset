import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Math;


public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int l = in.nextInt();
            int r = in.nextInt();

            int result = 0;

            int max = (l >= r) ? l : r;
            int step = 1;
            while (max >= step) {
                int gap = max - (r + l - max);
                int d = ((int) (0.5 * (1 - 2 * step + Math.sqrt((2 * step - 1) * (2 * step - 1) + 8 * gap))));
                if (l > r) {
                    l = l - step * d - (d * (d - 1) / 2);
                } else {
                    r = r - step * d - (d * (d - 1) / 2);
                }
                max = (l >= r) ? l : r;
                step = step + d;
                if (step <= max) {
                    if (l >= r) {
                        l = l - step;
                    } else {
                        r = r - step;
                    }
                    step = step+1;
                }
                max = (l >= r) ? l : r;
            }

            System.out.println("Case #" + t + ": " + (step - 1) + " " + l + " " + r);
        }
    }

}