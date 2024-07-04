import java.util.*;
import java.io.*;

public class Solution {
    static Scanner scanner;

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        return scanner.nextInt();
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] sameArray = new boolean[N + 1];
        boolean[] comparisonArray = new boolean[N + 1];

        List<Integer> sameIndices = new ArrayList<>();
        List<Integer> diffIndices = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                sameArray[i] = true;
                sameIndices.add(i);
            } else {
                sameArray[i] = false;
                diffIndices.add(i);
            }
        }

        int sameComparisonIndex = -1;
        int diffComparisonIndex = -1;

        if (!sameIndices.isEmpty()) {
            sameComparisonIndex = sameIndices.remove(0);
            comparisonArray[sameComparisonIndex] = true;
        }

        if (!diffIndices.isEmpty()) {
            diffComparisonIndex = diffIndices.remove(0);
            comparisonArray[diffComparisonIndex] = true;
        }

        int queryCount = 1;
        int sameComparisonValue = query(sameComparisonIndex);
        queryCount++;

        while (!sameIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                sameComparisonValue = query(sameComparisonIndex);
                queryCount++;
                continue;
            }
            comparisonArray[sameIndices.get(0)] = (sameComparisonValue == query(sameIndices.get(0)));
            queryCount++;
            sameIndices.remove(0);
        }

        int diffComparisonValue = query(diffComparisonIndex);
        queryCount++;

        while (!diffIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                diffComparisonValue = query(diffComparisonIndex);
                queryCount++;
                continue;
            }
            comparisonArray[diffIndices.get(0)] = (diffComparisonValue == query(diffIndices.get(0)));
            queryCount++;
            diffIndices.remove(0);
        }

        if (queryCount % 10 == 0) query(1);

        int[] result = new int[N + 1];
        sameComparisonValue = query(sameComparisonIndex);
        diffComparisonValue = query(diffComparisonIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                result[i] = comparisonArray[i] ? sameComparisonValue : 1 - sameComparisonValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = comparisonArray[i] ? diffComparisonValue : 1 - diffComparisonValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(result[i]);
        System.out.println();

        String response = scanner.next();
    }

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(reader.readLine().trim());
        return tokenizer.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static float readFloat() throws IOException {
        return Float.parseFloat(next());
    }

    static boolean readBoolean() throws IOException {
        return Boolean.parseBoolean(next());
    }

    static short readShort() throws IOException {
        return Short.parseShort(next());
    }

    static byte readByte() throws IOException {
        return Byte.parseByte(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return reader.readLine().trim();
    }

    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static void print(Object o) {
        writer.print(o);
    }
}