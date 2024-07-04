import java.util.*;
import java.io.*;

public class Solution {

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return readInt();
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] sameArray = new boolean[N + 1];
        boolean[] compareArray = new boolean[N + 1];
        List<Integer> sameIndices = new ArrayList<>();
        List<Integer> differentIndices = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                sameArray[i] = true;
                sameIndices.add(i);
            } else {
                sameArray[i] = false;
                differentIndices.add(i);
            }
        }

        int sameComparisonIndex = -1;
        int differentComparisonIndex = -1;

        if (!sameIndices.isEmpty()) {
            sameComparisonIndex = sameIndices.get(0);
            compareArray[sameComparisonIndex] = true;
            sameIndices.remove(0);
        }
        if (!differentIndices.isEmpty()) {
            differentComparisonIndex = differentIndices.get(0);
            compareArray[differentComparisonIndex] = true;
            differentIndices.remove(0);
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
            compareArray[sameIndices.get(0)] = (sameComparisonValue == query(sameIndices.get(0)));
            queryCount++;
            sameIndices.remove(0);
        }

        int differentComparisonValue = query(differentComparisonIndex);
        queryCount++;

        while (!differentIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                differentComparisonValue = query(differentComparisonIndex);
                queryCount++;
                continue;
            }
            compareArray[differentIndices.get(0)] = (differentComparisonValue == query(differentIndices.get(0)));
            queryCount++;
            differentIndices.remove(0);
        }

        if (queryCount % 10 == 0) query(0);

        int[] result = new int[N + 1];
        sameComparisonValue = query(sameComparisonIndex);
        differentComparisonValue = query(differentComparisonIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                result[i] = compareArray[i] ? sameComparisonValue : 1 - sameComparisonValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = compareArray[i] ? differentComparisonValue : 1 - differentComparisonValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(result[i]);
        System.out.println();
        readChar();
    }

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }
}