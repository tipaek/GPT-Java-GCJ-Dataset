import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }

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

        int sameCmpIndex = !sameIndices.isEmpty() ? sameIndices.remove(0) : -1;
        int diffCmpIndex = !diffIndices.isEmpty() ? diffIndices.remove(0) : -1;

        if (sameCmpIndex != -1) comparisonArray[sameCmpIndex] = true;
        if (diffCmpIndex != -1) comparisonArray[diffCmpIndex] = true;

        int queryCount = 1;
        int sameCmpValue = query(sameCmpIndex);
        queryCount++;

        for (int index : sameIndices) {
            if (queryCount % 10 == 1) {
                sameCmpValue = query(sameCmpIndex);
                queryCount++;
                continue;
            }
            comparisonArray[index] = (sameCmpValue == query(index));
            queryCount++;
        }

        int diffCmpValue = query(diffCmpIndex);
        queryCount++;

        for (int index : diffIndices) {
            if (queryCount % 10 == 1) {
                diffCmpValue = query(diffCmpIndex);
                queryCount++;
                continue;
            }
            comparisonArray[index] = (diffCmpValue == query(index));
            queryCount++;
        }

        if (queryCount % 10 == 0) query(0);

        int[] result = new int[N + 1];
        sameCmpValue = query(sameCmpIndex);
        diffCmpValue = query(diffCmpIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                result[i] = comparisonArray[i] ? sameCmpValue : 1 - sameCmpValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = comparisonArray[i] ? diffCmpValue : 1 - diffCmpValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

        if (readChar() == 'N') System.exit(0);
    }

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