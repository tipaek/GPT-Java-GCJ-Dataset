import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final int MAX_ATTEMPTS = 300;
    private static Scanner input;
    private static int A, B;
    private static int attemptsCount;
    private static final long S = 1000000000;

    private static String query(int x, int y) {
        if (attemptsCount++ == MAX_ATTEMPTS) throw new Error("Max attempts reached");
        System.out.println(x + " " + y);
        String result = input.next();
        if (result.equals("WRONG")) throw new Error("Failed response");
        return result;
    }

    private static boolean solve() {
        attemptsCount = 0;
        for (int x = -8; x <= 9; ++x) {
            for (int y = -8; y <= 8; ++y) {
                if (query(x, y).equals("CENTER")) return true;
                if (attemptsCount == MAX_ATTEMPTS) return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            String command = "python-apc /Users/apc/Desktop/Jam2020/local_testingJam2020.py 0";
            Process proc = Runtime.getRuntime().exec(command);
            System.setIn(proc.getInputStream());
            PrintStream ps = new PrintStream(proc.getOutputStream(), true);
            System.setOut(ps);
        } catch (Throwable ignored) {}

        input = new Scanner(System.in);
        int T = input.nextInt();
        A = input.nextInt();
        B = input.nextInt();
        System.err.println("tests: " + T);
        System.err.println("A = " + A + ", B = " + B);

        try {
            for (int ks = 1; ks <= T; ks++) {
                boolean s = solve();
                System.err.println("result: " + s + ", attempts: " + attemptsCount);
                if (!s) break;
            }
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}