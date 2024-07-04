import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testB.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double d, int sigDigits) {
        double q = Math.pow(10, sigDigits);
        return Math.round(d * q) / q;
    }

    public static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    public static class Digit implements Comparable<Digit> {
        char c;
        int count;

        public Digit(char c) {
            this.c = c;
            this.count = 1;
        }

        @Override
        public String toString() {
            return String.valueOf(c);
        }

        @Override
        public int compareTo(Digit d) {
            return Integer.compare(this.count, d.count);
        }

        public void incr() {
            this.count++;
        }
    }

    public static void nextCase(int caseNum) {
        int u = scanner.nextInt();
        HashMap<Character, Digit> counts = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            long q = scanner.nextLong();
            String m = scanner.next();

            for (char c : m.toCharArray()) {
                counts.putIfAbsent(c, new Digit(c));
                counts.get(c).incr();
            }
        }

        ArrayList<Digit> digits = new ArrayList<>(counts.values());
        Collections.sort(digits);

        StringBuilder answer = new StringBuilder();
        answer.append(digits.get(0));

        for (int i = digits.size() - 1; i >= 1; i--) {
            answer.append(digits.get(i));
        }

        writer.print("Case #" + caseNum + ": " + answer);
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            nextCase(i + 1);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}