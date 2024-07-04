import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            // Read coordinates
            long x = in.nextLong();
            long y = in.nextLong();

            if ((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                long nearestPowerOfTwo = 1;
                while (nearestPowerOfTwo * 2 < Math.abs(x) + Math.abs(y)) {
                    nearestPowerOfTwo *= 2;
                }

                StringBuilder result = new StringBuilder();
                while (nearestPowerOfTwo >= 1) {
                    if (Math.abs(x) > Math.abs(y)) {
                        if (x < 0) {
                            x += nearestPowerOfTwo;
                            result.append("W");
                        } else {
                            x -= nearestPowerOfTwo;
                            result.append("E");
                        }
                    } else {
                        if (y < 0) {
                            y += nearestPowerOfTwo;
                            result.append("S");
                        } else {
                            y -= nearestPowerOfTwo;
                            result.append("N");
                        }
                    }
                    nearestPowerOfTwo /= 2;
                }

                System.out.println("Case #" + i + ": " + result.reverse().toString());
            }
        }

        in.close();
    }
}