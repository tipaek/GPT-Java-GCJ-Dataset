import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    static void case2(Scanner in, int caseNum) {
        String src = in.next();
        StringBuilder result = new StringBuilder();
        int curLevel = 0;

        for (int i = 0; i < src.length(); ++i) {
            int digit = src.charAt(i) - '0';
            int delta = digit - curLevel;

            while (delta < 0) {
                result.append(")");
                delta++;
            }
            while (delta > 0) {
                result.append("(");
                delta--;
            }
            result.append(digit);
            curLevel = digit;
        }

        while (curLevel > 0) {
            result.append(")");
            curLevel--;
        }

        System.out.println("Case #" + caseNum + ": " + result);
    }

    static int N;
    static int K;
    static int[][] matrix;
    static int[] buf;

    static boolean checkDiagonal(int src, int dst) {
        int k = 0;
        for (int d = 0; d < N; ++d) {
            int D = (d == src) ? dst : (d == dst ? src : d);
            k += matrix[D][d];
        }
        return k == K;
    }

    static boolean swap(int src, int dst) {
        if (checkDiagonal(src, dst)) {
            System.arraycopy(matrix[src], 0, buf, 0, buf.length);
            System.arraycopy(matrix[dst], 0, matrix[src], 0, buf.length);
            System.arraycopy(buf, 0, matrix[dst], 0, buf.length);
            return true;
        }
        return false;
    }

    static void case5(Scanner in, int caseNum) {
        N = in.nextInt();
        K = in.nextInt();
        matrix = new int[N][N];
        buf = new int[N];
        boolean isOk = false;

        int start = K / N;
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
                if (!swap(i, j)) continue;
                isOk = true;
                break;
            }
        }

        System.out.println("Case #" + caseNum + ": " + (isOk ? "POSSIBLE" : "IMPOSSIBLE"));
        if (!isOk) return;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static String case1(Scanner in) {
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; ++row) {
            for (int column = 0; column < N; ++column) {
                matrix[row][column] = in.nextInt();
            }
        }

        int k = 0;
        for (int d = 0; d < N; ++d) k += matrix[d][d];

        int dupRows = 0, dupColumns = 0;
        int[] testLine = new int[N];

        for (int i = 0; i < N; ++i) {
            Arrays.fill(testLine, 0);
            for (int j = 0; j < N; ++j) {
                testLine[matrix[i][j] - 1]++;
            }
            for (int j = 0; j < N; ++j) {
                if (testLine[j] == 0) {
                    dupRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            Arrays.fill(testLine, 0);
            for (int j = 0; j < N; ++j) {
                testLine[matrix[j][i] - 1]++;
            }
            for (int j = 0; j < N; ++j) {
                if (testLine[j] == 0) {
                    dupColumns++;
                    break;
                }
            }
        }

        return k + " " + dupRows + " " + dupColumns;
    }

    static String echo(Scanner in) {
        return in.next();
    }

    static String caseEntry(Scanner in) {
        StringBuilder result = new StringBuilder();
        SortedSet<BigInteger> vocabulary = new TreeSet<>();
        BigInteger maxCode = in.nextBigInteger();
        int strLen = in.nextInt();

        BigInteger[] codes = new BigInteger[strLen + 1];
        BigInteger[] src = new BigInteger[strLen];
        BigInteger prevProd = BigInteger.ZERO;
        int initIndex = -1;

        for (int i = 0; i < strLen; ++i) {
            src[i] = in.nextBigInteger();
            if (i == 0) prevProd = src[i];
            else if (initIndex < 0 && !prevProd.equals(src[i])) initIndex = i - 1;
        }

        BigInteger gcd = src[initIndex].gcd(src[initIndex + 1]);
        codes[initIndex] = src[initIndex].divide(gcd);
        codes[initIndex + 1] = gcd;
        codes[initIndex + 2] = src[initIndex + 1].divide(gcd);

        for (int i = initIndex; i >= 1; --i) codes[i - 1] = src[i - 1].divide(codes[i]);
        for (int i = initIndex + 2; i < strLen; ++i) codes[i + 1] = src[i].divide(codes[i]);

        Collections.addAll(vocabulary, codes);

        for (BigInteger code : codes) {
            int charIndex = 'A' + vocabulary.headSet(code).size();
            result.append((char) charIndex);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
            System.setIn(is);
        } catch (Throwable ignored) {}

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            case2(in, i);
            // System.out.println("Case #" + i + ": " + case1(in));
            // case5(in, i);
            // System.out.println("Case #" + i + ": " + case1(in));
        }
    }
}