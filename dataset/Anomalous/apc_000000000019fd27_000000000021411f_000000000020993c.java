package code;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Jam2020 {

    static String solveCase(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }

        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    static String echo(Scanner scanner) {
        return scanner.next();
    }

    static String decodeCase(Scanner scanner) {
        BigInteger maxCode = scanner.nextBigInteger();
        int strLen = scanner.nextInt();

        BigInteger[] sequence = new BigInteger[strLen];
        for (int i = 0; i < strLen; i++) {
            sequence[i] = scanner.nextBigInteger();
        }

        int initIndex = findInitialIndex(sequence);

        BigInteger[] codes = new BigInteger[strLen + 1];
        BigInteger gcd = sequence[initIndex].gcd(sequence[initIndex + 1]);
        codes[initIndex] = sequence[initIndex].divide(gcd);
        codes[initIndex + 1] = gcd;
        codes[initIndex + 2] = sequence[initIndex + 1].divide(gcd);

        for (int i = initIndex; i > 0; i--) {
            codes[i - 1] = sequence[i - 1].divide(codes[i]);
        }

        for (int i = initIndex + 2; i < strLen; i++) {
            codes[i + 1] = sequence[i].divide(codes[i]);
        }

        SortedSet<BigInteger> vocabulary = new TreeSet<>(Arrays.asList(codes));

        StringBuilder result = new StringBuilder();
        for (BigInteger code : codes) {
            int charIndex = 'A' + vocabulary.headSet(code).size();
            result.append((char) charIndex);
        }

        return result.toString();
    }

    private static int findInitialIndex(BigInteger[] sequence) {
        for (int i = 1; i < sequence.length; i++) {
            if (!sequence[i].equals(sequence[i - 1])) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
            System.setIn(inputStream);
        } catch (FileNotFoundException ignored) {
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solveCase(scanner));
        }
    }
}