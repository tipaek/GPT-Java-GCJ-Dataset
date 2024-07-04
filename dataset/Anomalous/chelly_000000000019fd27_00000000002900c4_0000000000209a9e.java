import java.io.*;
import java.util.*;

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
        int initialQuery = query(1);
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

        int sameComparator = assignComparator(sameIndices, comparisonArray);
        int diffComparator = assignComparator(diffIndices, comparisonArray);

        int queryCount = 1;
        int sameComparatorValue = query(sameComparator);
        queryCount++;
        processIndices(sameIndices, sameComparatorValue, comparisonArray, queryCount);

        int diffComparatorValue = query(diffComparator);
        queryCount++;
        processIndices(diffIndices, diffComparatorValue, comparisonArray, queryCount);

        if (queryCount % 10 == 0) query(1);

        int[] result = new int[N + 1];
        sameComparatorValue = query(sameComparator);
        diffComparatorValue = query(diffComparator);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                result[i] = comparisonArray[i] ? sameComparatorValue : 1 - sameComparatorValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = comparisonArray[i] ? diffComparatorValue : 1 - diffComparatorValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

        char response = readChar();
        if (response == 'N') System.exit(0);
    }

    static int assignComparator(List<Integer> indices, boolean[] comparisonArray) {
        if (!indices.isEmpty()) {
            int comparator = indices.get(0);
            comparisonArray[comparator] = true;
            indices.remove(0);
            return comparator;
        }
        return -1;
    }

    static void processIndices(List<Integer> indices, int comparatorValue, boolean[] comparisonArray, int queryCount) throws IOException {
        while (!indices.isEmpty()) {
            if (queryCount % 10 == 1) {
                comparatorValue = query(indices.get(0));
                queryCount++;
                continue;
            }
            comparisonArray[indices.get(0)] = (comparatorValue == query(indices.get(0)));
            queryCount++;
            indices.remove(0);
        }
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