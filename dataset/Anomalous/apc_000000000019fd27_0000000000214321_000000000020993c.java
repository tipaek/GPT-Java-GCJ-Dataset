package code;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    static String solveCase(Scanner in) {
        final int N = in.nextInt();
        final int[][] matrix = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                matrix[row][col] = in.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = 0, duplicateCols = 0;
        final int[] count = new int[N];
        
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
                    duplicateCols++;
                    break;
                }
            }
        }

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    static String echo(Scanner in) {
        return in.next();
    }

    static String processCase(Scanner in) {
        SortedSet<BigInteger> vocabulary = new TreeSet<>();
        BigInteger maxCode = in.nextBigInteger();
        int strLen = in.nextInt();

        StringBuilder result = new StringBuilder(strLen + 1);
        BigInteger[] codes = new BigInteger[strLen + 1];
        BigInteger[] src = new BigInteger[strLen];
        BigInteger prevProd = BigInteger.ZERO;
        int initIndex = -1;

        for (int i = 0; i < strLen; i++) {
            src[i] = in.nextBigInteger();
            if (i == 0) {
                prevProd = src[i];
            } else {
                if (initIndex < 0 && !prevProd.equals(src[i])) {
                    initIndex = i - 1;
                }
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
            int charIndex = 0x41 + vocabulary.headSet(code).size();
            result.append((char) charIndex);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
            System.setIn(is);
        } catch (Exception ignored) {}

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + solveCase(in));
        }
    }
}