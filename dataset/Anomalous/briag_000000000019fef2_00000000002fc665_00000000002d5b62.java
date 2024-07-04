import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            // Read coordinates
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Check if the solution is impossible
            if ((Math.abs(x) % 2 == Math.abs(y) % 2)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                // Find the nearest power of two
                int powerOfTwo = 1;
                while (powerOfTwo * 2 < Math.abs(x) + Math.abs(y)) {
                    powerOfTwo *= 2;
                }

                StringBuilder result = new StringBuilder();
                while (powerOfTwo >= 1) {
                    if (Math.abs(x) > Math.abs(y)) {
                        if (x < 0) {
                            x += powerOfTwo;
                            result.append("W");
                        } else {
                            x -= powerOfTwo;
                            result.append("E");
                        }
                    } else {
                        if (y < 0) {
                            y += powerOfTwo;
                            result.append("S");
                        } else {
                            y -= powerOfTwo;
                            result.append("N");
                        }
                    }
                    powerOfTwo /= 2;
                }

                // Output the result in reverse order
                System.out.println("Case #" + i + ": " + result.reverse().toString());
            }
        }
    }
}