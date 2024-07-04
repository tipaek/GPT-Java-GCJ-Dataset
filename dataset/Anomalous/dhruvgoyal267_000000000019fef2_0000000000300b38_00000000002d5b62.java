import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            if (x == 0 && y == 0) {
                System.out.println("Case #" + (originalTestCases - testCases) + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder result = new StringBuilder();
            int power = 1;

            while (power <= Math.abs(x + y)) {
                power *= 2;
            }
            power /= 2;

            while ((x != 0 || y != 0) && power > 0) {
                if ((Math.abs(Math.abs(x) - power) <= Math.abs(Math.abs(y) - power)) && x != 0) {
                    if (x < 0) {
                        x += power;
                        result.append("W");
                    } else {
                        x -= power;
                        result.append("E");
                    }
                } else {
                    if (y < 0) {
                        y += power;
                        result.append("S");
                    } else {
                        y -= power;
                        result.append("N");
                    }
                }
                power /= 2;
            }

            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result.reverse());
        }
    }
}