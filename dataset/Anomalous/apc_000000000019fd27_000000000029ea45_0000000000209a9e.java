import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static Scanner input;
    static int B;
    static int[] result;
    static StringBuilder output;
    static int attemptsCount;

    static int toFlip;
    static int toInvert;

    static int getCurrentValue(int pos) {
        if (pos < 0 || pos >= B) throw new IllegalArgumentException("Invalid index: " + pos);
        if (attemptsCount == 150) throw new IndexOutOfBoundsException("No more queries left");
        System.out.println(pos + 1);
        attemptsCount++;
        String response = input.next();
        if (response.equals("N")) throw new IllegalArgumentException("Unexpected response N");
        return Integer.parseInt(response);
    }

    static boolean transformResult(int toFlip, int toInvert, int pos) {
        if (toFlip < 0 || toInvert < 0)
            throw new IllegalStateException("toFlip: " + toFlip + ", toInvert: " + toInvert);

        if (result[pos] < 0) return false;

        if (toFlip > 0) {
            int tmp = result[pos];
            result[pos] = result[B - 1 - pos];
            result[B - 1 - pos] = tmp;
        }

        if (toInvert > 0) {
            result[pos] = 1 - result[pos];
            if (pos < B - 1 - pos) result[B - 1 - pos] = 1 - result[B - 1 - pos];
        }
        return true;
    }

    static void updateTransform(int oldLeft, int newLeft, int oldRight, int newRight) {
        if (toFlip >= 0 && toInvert >= 0) return;

        if (oldLeft == 0 && oldRight == 0 && newLeft == 0 && newRight == 0) toInvert = 0;
        if (oldLeft == 0 && oldRight == 0 && newLeft == 1 && newRight == 1) toInvert = 1;
        if (oldLeft == 0 && oldRight == 1 && newLeft == 0 && newRight == 1) {
            if (toInvert == 0) toFlip = 0;
            if (toInvert == 1) toFlip = 1;
            if (toFlip == 0) toInvert = 0;
            if (toFlip == 1) toInvert = 1;
        }
        if (oldLeft == 0 && oldRight == 1 && newLeft == 1 && newRight == 0) {
            if (toInvert == 0) toFlip = 1;
            if (toInvert == 1) toFlip = 0;
            if (toFlip == 0) toInvert = 1;
            if (toFlip == 1) toInvert = 0;
        }
        if (oldLeft == 1 && oldRight == 0 && newLeft == 0 && newRight == 1) {
            if (toInvert == 0) toFlip = 1;
            if (toInvert == 1) toFlip = 0;
            if (toFlip == 0) toInvert = 1;
            if (toFlip == 1) toInvert = 0;
        }
        if (oldLeft == 1 && oldRight == 0 && newLeft == 1 && newRight == 0) {
            if (toInvert == 0) toFlip = 0;
            if (toInvert == 1) toFlip = 1;
            if (toFlip == 0) toInvert = 0;
            if (toFlip == 1) toInvert = 1;
        }
        if (oldLeft == 1 && oldRight == 1 && newLeft == 0 && newRight == 0) toInvert = 1;
        if (oldLeft == 1 && oldRight == 1 && newLeft == 1 && newRight == 1) toInvert = 0;
    }

    static String predict() {
        Arrays.fill(result, -1);
        int pos = 0;
        while (true) {
            while (pos < B / 2 && result[pos] >= 0) pos++;
            if (pos == B / 2 && result[pos] >= 0) break;
            result[pos] = getCurrentValue(pos);
            result[B - 1 - pos] = getCurrentValue(B - 1 - pos);
            boolean willBeScrambled = (attemptsCount > 9 && attemptsCount % 10 == 0);
            if (willBeScrambled) {
                toFlip = -1;
                toInvert = -1;
                int leftMostValue = -1;
                int rightMostValue = -1;
                for (int recheckPos = 0; recheckPos < B / 2; recheckPos++) {
                    if (toFlip >= 0 && toInvert >= 0) {
                        if (!transformResult(toFlip, toInvert, recheckPos)) break;
                    } else {
                        if (leftMostValue != result[recheckPos] || rightMostValue != result[B - 1 - recheckPos]) {
                            int leftMostUpdated = getCurrentValue(recheckPos);
                            int rightMostUpdated = (recheckPos == B - 1 - recheckPos) ? leftMostUpdated : getCurrentValue(B - 1 - recheckPos);
                            updateTransform(result[recheckPos], leftMostUpdated, result[B - 1 - recheckPos], rightMostUpdated);
                            result[recheckPos] = leftMostUpdated;
                            result[B - 1 - recheckPos] = rightMostUpdated;
                        }
                    }
                }
            }
        }

        output.setLength(0);
        for (int bit : result) {
            if (bit < 0) return "";
            output.append(bit);
        }
        return output.toString();
    }

    public static void solve(Scanner input, int a, int b) {
        int m = (a + b) / 2;
        System.out.println(m);
        String s = input.next();
        if (s.equals("CORRECT")) {
            return;
        } else if (s.equals("TOO_SMALL")) {
            solve(input, m + 1, b);
        } else {
            solve(input, a, m - 1);
        }
    }

    public static void main(String[] args) {
        try {
            String command = "python-apc /Users/apc/Desktop/Jam2020/local_testingJam2020.py 2";
            Runtime run = Runtime.getRuntime();
            Process proc = run.exec(command);
            System.setIn(proc.getInputStream());
            PrintStream ps = new PrintStream(proc.getOutputStream(), true);
            System.setOut(ps);
        } catch (Throwable ignored) {}

        input = new Scanner(System.in);
        int T = input.nextInt();
        B = input.nextInt();
        System.err.println("tests: " + T);
        System.err.println("bits: " + B);
        result = new int[B];
        output = new StringBuilder(B);

        for (int ks = 1; ks <= T; ks++) {
            attemptsCount = 0;
            String s = predict();
            System.out.println(s);
            String response = input.next();
            System.err.println("result: " + s + "attempts: " + attemptsCount);
            System.err.println("response: " + response);
            if (response.equals("N")) break;
        }
    }
}