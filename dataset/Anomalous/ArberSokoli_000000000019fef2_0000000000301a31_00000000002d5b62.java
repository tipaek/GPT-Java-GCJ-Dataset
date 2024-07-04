import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                String[] input = scanner.nextLine().split(" ");
                long x = Long.parseLong(input[0]);
                long y = Long.parseLong(input[1]);

                String result = findPath(x, y);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

    private static String findPath(long x, long y) {
        long absX = Math.abs(x);
        long absY = Math.abs(y);
        long maxStep = 1;

        while (maxStep <= absX || maxStep <= absY) {
            maxStep <<= 1;
        }

        maxStep >>= 1;
        StringBuilder path = new StringBuilder();

        while (maxStep > 0) {
            if (absX > absY) {
                if (x > 0) {
                    path.append("E");
                    x -= maxStep;
                } else {
                    path.append("W");
                    x += maxStep;
                }
            } else {
                if (y > 0) {
                    path.append("N");
                    y -= maxStep;
                } else {
                    path.append("S");
                    y += maxStep;
                }
            }

            absX = Math.abs(x);
            absY = Math.abs(y);
            maxStep >>= 1;
        }

        if (x != 0 || y != 0) {
            return "IMPOSSIBLE";
        }

        return path.reverse().toString();
    }
}