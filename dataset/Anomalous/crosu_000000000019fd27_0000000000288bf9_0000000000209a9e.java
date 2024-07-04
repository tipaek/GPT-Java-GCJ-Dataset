import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static final boolean FROM_FILE = false;
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

    private static long now() {
        return System.nanoTime();
    }

    private static double round(double d, int sigDigits) {
        double q = Math.pow(10, sigDigits);
        return Math.round(d * q) / q;
    }

    private static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    private static HashSet<BigInteger> arrayToHashSet(BigInteger[] array) {
        return new HashSet<>(Arrays.asList(array));
    }

    private static HashMap<BigInteger, Character> convertCodesToLetters(HashSet<BigInteger> codes) {
        BigInteger[] sortedCodes = codes.toArray(new BigInteger[0]);
        Arrays.sort(sortedCodes);
        HashMap<BigInteger, Character> mapping = new HashMap<>();
        char ch = 'A';
        for (BigInteger code : sortedCodes) {
            mapping.put(code, ch++);
        }
        return mapping;
    }

    private static int getNth(int n) {
        writer.println("" + (n + 1));
        writer.flush();
        return Integer.parseInt(scanner.next());
    }

    private static void solveFor10() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            result.append(getNth(i));
        }
        writer.println(result);
        writer.flush();
        assert "Y".equals(scanner.next());
        scanner.next();
    }

    private static int[] extractByIndices(int[] full, int[] indices) {
        return Arrays.stream(indices).map(i -> full[i]).toArray();
    }

    private static void insertByIndices(int[] full, int[] indices, int[] byIndex) {
        for (int i = 0; i < indices.length; i++) {
            full[indices[i]] = byIndex[i];
        }
    }

    private static int[] updateForFlipsAndComplements(int[] original, int[] indices) {
        int n = indices.length;
        int[] updated = new int[n];
        Integer sameIndex = null;
        Integer differentIndex = null;

        for (int i = 0; i < n; i++) {
            if (original[i] == original[n - i - 1]) {
                sameIndex = i;
            } else {
                differentIndex = i;
            }
        }

        boolean isComplement = sameIndex != null && getNth(indices[sameIndex]) != original[sameIndex];
        boolean isFlipped = differentIndex != null &&
                ((!isComplement && getNth(indices[differentIndex]) != original[differentIndex]) ||
                        (isComplement && getNth(indices[differentIndex]) == original[differentIndex]));

        if (isFlipped) {
            for (int i = 0; i < n; i++) {
                updated[i] = original[n - i - 1];
            }
        } else {
            System.arraycopy(original, 0, updated, 0, n);
        }

        if (isComplement) {
            for (int i = 0; i < n; i++) {
                updated[i] = updated[i] == 0 ? 1 : 0;
            }
        }

        return updated;
    }

    private static void solveFor20() {
        int[] values = new int[20];
        int[] finalValues = new int[20];
        int[] middleIndices = new int[10];
        int[] outerIndices = new int[10];

        for (int i = 0; i < 10; i++) {
            middleIndices[i] = i + 5;
            outerIndices[i] = i < 5 ? i : i + 10;
        }

        Arrays.stream(middleIndices).forEach(i -> values[i] = getNth(i));
        Arrays.stream(outerIndices).forEach(i -> values[i] = getNth(i));

        int[] middle = extractByIndices(values, middleIndices);
        int[] outside = extractByIndices(values, outerIndices);

        int[] finalMiddle = updateForFlipsAndComplements(middle, middleIndices);
        int[] finalOutside = updateForFlipsAndComplements(outside, outerIndices);

        insertByIndices(finalValues, middleIndices, finalMiddle);
        insertByIndices(finalValues, outerIndices, finalOutside);

        StringBuilder result = new StringBuilder();
        for (int value : finalValues) {
            result.append(value);
        }
        writer.println(result);
        writer.flush();
        assert "Y".equals(scanner.next());
        scanner.next();
    }

    private static void solveFor100() {
        // Implementation for 100-bit problem
    }

    private static void nextCase(int b) {
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
            nextCase(b);
        }

        writer.close();
        scanner.close();
    }
}