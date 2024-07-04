import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Solution {

    static int currentAnswer;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            long x = in.nextInt(), y = in.nextInt();

            currentAnswer = Integer.MAX_VALUE;
            StringBuilder answerBuilder = new StringBuilder();
            if (!findPath(0, 0, 0, x, y, answerBuilder, 12)) {
                answerBuilder.append("IMPOSSIBLE");
            } else {
                answerBuilder.reverse();
            }

            System.out.println("Case #" + testCase + ": " + answerBuilder.toString());
        }
    }

    private static boolean findPath(long x, long y, long steps, long targetX, long targetY, StringBuilder answerBuilder, long maxSteps) {
        if (x == targetX && y == targetY) {
            answerBuilder.setLength(0);
            currentAnswer = (int) steps;
            return true;
        }
        
        if (steps == maxSteps || currentAnswer <= steps) {
            return false;
        }
        
        long distance = 1L << steps;

        if (findPath(x, y + distance, steps + 1, targetX, targetY, answerBuilder, maxSteps)) {
            answerBuilder.append("N");
            return true;
        }

        if (findPath(x, y - distance, steps + 1, targetX, targetY, answerBuilder, maxSteps)) {
            answerBuilder.append("S");
            return true;
        }

        if (findPath(x + distance, y, steps + 1, targetX, targetY, answerBuilder, maxSteps)) {
            answerBuilder.append("E");
            return true;
        }

        if (findPath(x - distance, y, steps + 1, targetX, targetY, answerBuilder, maxSteps)) {
            answerBuilder.append("W");
            return true;
        }

        return false;
    }

    private static Set<Integer> generateValidDistances() {
        Set<Integer> distances = new TreeSet<>();
        distances.add(0);
        long i = 0;
        long num = 0;
        while (true) {
            num += 1L << i;

            if (num <= 2_000_000_000L) {
                distances.add((int) num);
            } else {
                break;
            }

            i++;
        }

        return distances;
    }
}