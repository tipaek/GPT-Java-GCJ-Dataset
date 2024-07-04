package code;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Jam2020 {

    static String solveCase(Scanner scanner) {
        final int N = scanner.nextInt();
        final int[][] matrix = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = 0;
        int duplicateColumns = 0;
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < N; j++) {
                count[matrix[i][j] - 1]++;
            }
            for (int j = 0; j < N; j++) {
                if (count[j] == 0) {
                    duplicateRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < N; j++) {
                count[matrix[j][i] - 1]++;
            }
            for (int j = 0; j < N; j++) {
                if (count[j] == 0) {
                    duplicateColumns++;
                    break;
                }
            }
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    static String echo(Scanner scanner) {
        return scanner.next();
    }

    static String caseEntry(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        SortedSet<BigInteger> vocabulary = new TreeSet<>();
        BigInteger maxCode = scanner.nextBigInteger();
        int strLen = scanner.nextInt();

        BigInteger[] codes = new BigInteger[strLen + 1];
        BigInteger[] src = new BigInteger[strLen];
        BigInteger prevProd = BigInteger.ZERO;
        int initIndex = -1;

        for (int i = 0; i < strLen; i++) {
            src[i] = scanner.nextBigInteger();
            if (i == 0) {
                prevProd = src[i];
            } else if (initIndex < 0 && !prevProd.equals(src[i])) {
                initIndex = i - 1;
            }
        }

        BigInteger gcd = src[initIndex].gcd(src[initIndex + 1]);
        codes[initIndex] = src[initIndex].divide(gcd);
        codes[initIndex + 1] = gcd;
        codes[initIndex + 2] = src[initIndex + 1].divide(gcd);

        for (int i = initIndex; i >= 1; i--) {
            codes[i - 1] = src[i - 1].divide(codes[i]);
        }

        for (int i = initIndex + 2; i < strLen; i++) {
            codes[i + 1] = src[i].divide(codes[i]);
        }

        Collections.addAll(vocabulary, codes);

        for (BigInteger code : codes) {
            int charIndex = 'A' + vocabulary.headSet(code).size();
            result.append((char) charIndex);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
            System.setIn(inputStream);
        } catch (Throwable ignored) {
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solveCase(scanner));
        }
    }
}