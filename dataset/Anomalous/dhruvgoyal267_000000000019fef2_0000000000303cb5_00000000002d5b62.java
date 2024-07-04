import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            if ((Math.abs(x - y) % 2 == 0) || ((Math.abs(x) + Math.abs(y)) % 2 == 0)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder path = new StringBuilder();
                long stepSize = 1;

                while (stepSize <= Math.abs(x) + Math.abs(y)) {
                    stepSize *= 2;
                }
                stepSize /= 2;

                while (x != 0 || y != 0) {
                    if (Math.abs(Math.abs(x) - stepSize) <= Math.abs(Math.abs(y) - stepSize) && x != 0) {
                        if (x < 0) {
                            x += stepSize;
                            path.append("W");
                        } else {
                            x -= stepSize;
                            path.append("E");
                        }
                    } else {
                        if (y < 0) {
                            y += stepSize;
                            path.append("S");
                        } else {
                            y -= stepSize;
                            path.append("N");
                        }
                    }
                    stepSize /= 2;
                }
                System.out.println("Case #" + caseNumber + ": " + path.reverse());
            }
            caseNumber++;
        }
    }
}