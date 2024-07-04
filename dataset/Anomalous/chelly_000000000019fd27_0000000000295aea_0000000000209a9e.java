import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        System.exit(-1);
        int T = readInt();
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
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

        int sameCmpIndex = -1;
        int diffCmpIndex = -1;

        if (!sameIndices.isEmpty()) {
            sameCmpIndex = sameIndices.remove(0);
            comparisonArray[sameCmpIndex] = true;
        }

        if (!diffIndices.isEmpty()) {
            diffCmpIndex = diffIndices.remove(0);
            comparisonArray[diffCmpIndex] = true;
        }

        int queryCount = 1;
        int sameCmpValue = query(sameCmpIndex);
        queryCount = processIndices(sameIndices, sameCmpIndex, comparisonArray, sameCmpValue, queryCount);

        int diffCmpValue = query(diffCmpIndex);
        queryCount = processIndices(diffIndices, diffCmpIndex, comparisonArray, diffCmpValue, queryCount);

        if (queryCount % 10 == 0) query(0);

        int[] resultArray = new int[N + 1];
        sameCmpValue = query(sameCmpIndex);
        diffCmpValue = query(diffCmpIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                resultArray[i] = comparisonArray[i] ? sameCmpValue : 1 - sameCmpValue;
                resultArray[N + 1 - i] = resultArray[i];
            } else {
                resultArray[i] = comparisonArray[i] ? diffCmpValue : 1 - diffCmpValue;
                resultArray[N + 1 - i] = 1 - resultArray[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(resultArray[i]);
        }
        System.out.println();
        System.out.flush();

        if (readChar() == 'N') System.exit(-1);
    }

    static int processIndices(List<Integer> indices, int cmpIndex, boolean[] comparisonArray, int cmpValue, int queryCount) throws IOException {
        while (!indices.isEmpty()) {
            if (queryCount % 10 == 1) {
                cmpValue = query(cmpIndex);
                queryCount++;
                continue;
            }
            comparisonArray[indices.get(0)] = (cmpValue == query(indices.get(0)));
            queryCount++;
            indices.remove(0);
        }
        return queryCount;
    }

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return readInt();
    }

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