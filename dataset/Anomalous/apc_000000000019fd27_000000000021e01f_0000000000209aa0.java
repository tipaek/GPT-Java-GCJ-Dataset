import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    static int N;
    static int K;
    static int[][] matrix;
    static int[] buf;

    static boolean checkDiagonal(int src, int dst) {
        int sum = 0;
        for (int d = 0; d < N; ++d) {
            int index = (d == src) ? dst : (d == dst ? src : d);
            sum += matrix[index][d];
        }
        return sum == K;
    }

    static boolean swapRows(int src, int dst) {
        if (checkDiagonal(src, dst)) {
            System.arraycopy(matrix[src], 0, buf, 0, buf.length);
            System.arraycopy(matrix[dst], 0, matrix[src], 0, buf.length);
            System.arraycopy(buf, 0, matrix[dst], 0, buf.length);
            return true;
        }
        return false;
    }

    static void handleCase(Scanner in, int caseNum) {
        N = in.nextInt();
        K = in.nextInt();
        matrix = new int[N][N];
        buf = new int[N];
        boolean isPossible = false;

        int start = (K + (N / 2)) / N;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (start > N) start -= N;
                matrix[i][j] = start++;
            }
            start--;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == j && i != 0) continue;
                if (swapRows(i, j)) {
                    isPossible = true;
                    break;
                }
            }
        }

        System.out.println("Case #" + caseNum + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
        if (!isPossible) return;

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    static String analyzeMatrix(Scanner in) {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix[i][j] = in.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < size; ++i) trace += matrix[i][i];

        int duplicateRows = 0, duplicateColumns = 0;
        int[] count = new int[size];

        for (int i = 0; i < size; ++i) {
            Arrays.fill(count, 0);
            for (int j = 0; j < size; ++j) {
                count[matrix[i][j] - 1]++;
            }
            if (Arrays.stream(count).anyMatch(c -> c == 0)) duplicateRows++;
        }

        for (int j = 0; j < size; ++j) {
            Arrays.fill(count, 0);
            for (int i = 0; i < size; ++i) {
                count[matrix[i][j] - 1]++;
            }
            if (Arrays.stream(count).anyMatch(c -> c == 0)) duplicateColumns++;
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    static String echo(Scanner in) {
        return in.next();
    }

    static String decodeMessage(Scanner in) {
        SortedSet<BigInteger> vocabulary = new TreeSet<>();
        BigInteger maxCode = in.nextBigInteger();
        int strLen = in.nextInt();

        StringBuilder result = new StringBuilder(strLen + 1);
        BigInteger[] codes = new BigInteger[strLen + 1];
        BigInteger[] src = new BigInteger[strLen];
        BigInteger prevProd = BigInteger.ZERO;
        int initIndex = -1;

        for (int i = 0; i < strLen; ++i) {
            src[i] = in.nextBigInteger();
            if (i > 0 && initIndex < 0 && !src[i].equals(prevProd)) {
                initIndex = i - 1;
            }
            prevProd = src[i];
        }

        BigInteger gcd = src[initIndex].gcd(src[initIndex + 1]);
        codes[initIndex] = src[initIndex].divide(gcd);
        codes[initIndex + 1] = gcd;
        codes[initIndex + 2] = src[initIndex + 1].divide(gcd);

        for (int i = initIndex; i >= 1; --i) {
            codes[i - 1] = src[i - 1].divide(codes[i]);
        }

        for (int i = initIndex + 2; i < strLen; ++i) {
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
            System.setIn(new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in")));
        } catch (Throwable ignored) {}

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            handleCase(in, i);
        }
    }
}