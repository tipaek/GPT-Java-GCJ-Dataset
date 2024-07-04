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
        boolean[] comparisonArray = new boolean[N + 1];
        int initialQuery = query(1);
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
            sameComparisonIndex = sameIndices.remove(0);
            comparisonArray[sameComparisonIndex] = true;
        }
        if (!differentIndices.isEmpty()) {
            differentComparisonIndex = differentIndices.remove(0);
            comparisonArray[differentComparisonIndex] = true;
        }

        int count = 1;
        int sameComparisonValue = query(sameComparisonIndex);
        count++;
        while (!sameIndices.isEmpty()) {
            if (count % 10 == 1) {
                sameComparisonValue = query(sameComparisonIndex);
                count++;
                continue;
            }
            comparisonArray[sameIndices.get(0)] = (sameComparisonValue == query(sameIndices.remove(0)));
            count++;
        }

        int differentComparisonValue = query(differentComparisonIndex);
        count++;
        while (!differentIndices.isEmpty()) {
            if (count % 10 == 1) {
                differentComparisonValue = query(differentComparisonIndex);
                count++;
                continue;
            }
            comparisonArray[differentIndices.get(0)] = (differentComparisonValue == query(differentIndices.remove(0)));
            count++;
        }

        if (count % 10 == 0) query(0);

        int[] answer = new int[N + 1];
        sameComparisonValue = query(sameComparisonIndex);
        differentComparisonValue = query(differentComparisonIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                answer[i] = comparisonArray[i] ? sameComparisonValue : 1 - sameComparisonValue;
                answer[N + 1 - i] = answer[i];
            } else {
                answer[i] = comparisonArray[i] ? differentComparisonValue : 1 - differentComparisonValue;
                answer[N + 1 - i] = 1 - answer[i];
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(answer[i]);
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
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }
}