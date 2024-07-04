import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final Boolean DEBUG = false;
    private static final Boolean FROM_FILE = false;
    private static final String INPUT_FILE = "testC.in";

    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String s) {
        if (DEBUG) {
            writer.println(s);
        }
    }

    private static void debugPrint(String s) {
        if (DEBUG) {
            writer.print(s);
        }
    }

    private static long currentTime() {
        return System.nanoTime();
    }

    private static double roundToSignificantDigits(double value, int sigDigits) {
        double scale = Math.pow(10, sigDigits);
        return Math.round(value * scale) / scale;
    }

    private static void printElapsedTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = 1e-6;
        debugPrintln("Ms elapsed: " + roundToSignificantDigits(elapsed * msPerNs, 4) +
                " (" + roundToSignificantDigits(start * msPerNs, 4) + ", " +
                roundToSignificantDigits(stop * msPerNs, 4) + ")");
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    private static HashSet<BigInteger> convertArrayToHashSet(BigInteger[] array) {
        return new HashSet<>(Arrays.asList(array));
    }

    private static HashMap<BigInteger, Character> mapCodesToLetters(HashSet<BigInteger> codes) {
        BigInteger[] sortedCodes = codes.toArray(new BigInteger[0]);
        Arrays.sort(sortedCodes);

        HashMap<BigInteger, Character> mapping = new HashMap<>();
        char ch = 'A';
        for (BigInteger code : sortedCodes) {
            mapping.put(code, ch++);
        }

        return mapping;
    }

    private static void solveFor10() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            writer.println(i + 1);
            writer.flush();
            int x = Integer.parseInt(scanner.next());
            result.append(x);
        }
        writer.println(result);
        writer.flush();
        assert "Y".equals(scanner.next());
        scanner.next();
    }

    private static void solveFor20() {
        // Implementation for solving the case with b = 20
    }

    private static void solveFor100() {
        // Implementation for solving the case with b = 100
    }

    private static void handleNextCase(int b) {
        switch (b) {
            case 10:
                solveFor10();
                break;
            case 20:
                solveFor20();
                break;
            case 100:
                solveFor100();
                break;
            default:
                throw new IllegalArgumentException("Unsupported case: " + b);
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = FROM_FILE ? new Scanner(new File(INPUT_FILE)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            handleNextCase(b);
        }

        writer.close();
        scanner.close();
    }
}