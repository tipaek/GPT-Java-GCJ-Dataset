import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    static int[] startTimes;
    static int[] endTimes;
    static String[] jobWorkers;
    static String[] availableWorkers;

    static boolean allocateJob(int jobIndex) {
        for (int i = 0; i < availableWorkers.length; ++i) {
            if (!availableWorkers[i].isEmpty()) {
                jobWorkers[jobIndex] = availableWorkers[i];
                availableWorkers[i] = "";
                return true;
            }
        }
        return false;
    }

    static void finishJob(int jobIndex) {
        for (int i = 0; i < availableWorkers.length; ++i) {
            if (!availableWorkers[i].isEmpty()) continue;
            availableWorkers[i] = jobWorkers[jobIndex];
            break;
        }
    }

    static void handleCase3(Scanner in, int caseNumber) {
        int N = in.nextInt();
        startTimes = new int[N];
        endTimes = new int[N];
        jobWorkers = new String[N];
        availableWorkers = new String[]{"C", "J"};

        for (int i = 0; i < N; ++i) {
            startTimes[i] = in.nextInt();
            endTimes[i] = in.nextInt();
        }

        for (int currentTime = 0; currentTime <= 24 * 60; ++currentTime) {
            for (int j = 0; j < N; ++j) {
                if (endTimes[j] == currentTime) {
                    finishJob(j);
                }
            }
            for (int j = 0; j < N; ++j) {
                if (startTimes[j] == currentTime) {
                    if (!allocateJob(j)) {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        return;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String worker : jobWorkers) result.append(worker);

        System.out.println("Case #" + caseNumber + ": " + result);
    }

    static void handleCase2(Scanner in, int caseNumber) {
        String src = in.next();
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (int i = 0; i < src.length(); ++i) {
            int digit = src.charAt(i) - '0';
            int delta = digit - currentLevel;
            result.append(")".repeat(Math.max(0, -delta)));
            result.append("(".repeat(Math.max(0, delta)));
            result.append(digit);
            currentLevel += delta;
        }
        result.append(")".repeat(currentLevel));

        System.out.println("Case #" + caseNumber + ": " + result);
    }

    static int N;
    static int K;
    static int[][] matrix;
    static int[] buffer;

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
            System.arraycopy(matrix[src], 0, buffer, 0, buffer.length);
            System.arraycopy(matrix[dst], 0, matrix[src], 0, buffer.length);
            System.arraycopy(buffer, 0, matrix[dst], 0, buffer.length);
            return true;
        }
        return false;
    }

    static void handleCase5(Scanner in, int caseNumber) {
        N = in.nextInt();
        K = in.nextInt();
        matrix = new int[N][N];
        buffer = new int[N];
        boolean isPossible = false;

        int startValue = K / N;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (startValue > N) startValue -= N;
                matrix[i][j] = startValue++;
            }
            startValue--;
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

        System.out.println("Case #" + caseNumber + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
        if (!isPossible) return;

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    static String handleCase1(Scanner in) {
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                matrix[row][col] = in.nextInt();
            }
        }

        int trace = 0;
        for (int d = 0; d < N; ++d) trace += matrix[d][d];

        int duplicateRows = 0, duplicateColumns = 0;
        int[] testLine = new int[N];

        for (int i = 0; i < N; ++i) {
            Arrays.fill(testLine, 0);
            for (int j = 0; j < N; ++j) {
                testLine[matrix[i][j] - 1]++;
            }
            if (Arrays.stream(testLine).anyMatch(count -> count == 0)) {
                duplicateRows++;
            }
        }

        for (int i = 0; i < N; ++i) {
            Arrays.fill(testLine, 0);
            for (int j = 0; j < N; ++j) {
                testLine[matrix[j][i] - 1]++;
            }
            if (Arrays.stream(testLine).anyMatch(count -> count == 0)) {
                duplicateColumns++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    static String echo(Scanner in) {
        return in.next();
    }

    static String handleCaseEntry(Scanner in) {
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
            FileInputStream is = new FileInputStream(new File("path/to/your/input/file"));
            System.setIn(is);
        } catch (Throwable ignored) {}

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            handleCase3(in, i);
            // handleCase2(in, i);
            // System.out.println("Case #" + i + ": " + handleCase1(in));
            // handleCase5(in, i);
            // System.out.println("Case #" + i + ": " + handleCase1(in));
        }
    }
}