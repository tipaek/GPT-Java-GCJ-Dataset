import java.util.*;
import java.io.*;

public class Main {
    static Scanner scanner;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            solve(t);
        }
    }

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        return scanner.nextInt();
    }

    static void solve(int t) throws IOException {
        int N = readInt();
        boolean[] sameArray = new boolean[N + 1];
        boolean[] comparisonArray = new boolean[N + 1];
        List<Integer> sameList = new ArrayList<>();
        List<Integer> diffList = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                sameArray[i] = true;
                sameList.add(i);
            } else {
                sameArray[i] = false;
                diffList.add(i);
            }
        }

        int sameComparator = -1;
        int diffComparator = -1;
        if (!sameList.isEmpty()) {
            sameComparator = sameList.remove(0);
            comparisonArray[sameComparator] = true;
        }
        if (!diffList.isEmpty()) {
            diffComparator = diffList.remove(0);
            comparisonArray[diffComparator] = true;
        }

        int queryCount = 1;
        int sameComparatorValue = query(sameComparator);
        queryCount++;
        while (!sameList.isEmpty()) {
            if (queryCount % 10 == 1) {
                sameComparatorValue = query(sameComparator);
                queryCount++;
                continue;
            }
            comparisonArray[sameList.remove(0)] = (sameComparatorValue == query(sameList.get(0)));
            queryCount++;
        }

        int diffComparatorValue = query(diffComparator);
        queryCount++;
        while (!diffList.isEmpty()) {
            if (queryCount % 10 == 1) {
                diffComparatorValue = query(diffComparator);
                queryCount++;
                continue;
            }
            comparisonArray[diffList.remove(0)] = (diffComparatorValue == query(diffList.get(0)));
            queryCount++;
        }

        if (queryCount % 10 == 0) query(1);

        int[] resultArray = new int[N + 1];
        sameComparatorValue = query(sameComparator);
        diffComparatorValue = query(diffComparator);

        for (int i = 1; i <= N / 2; i++) {
            if (sameArray[i]) {
                resultArray[i] = comparisonArray[i] ? sameComparatorValue : 1 - sameComparatorValue;
                resultArray[N + 1 - i] = resultArray[i];
            } else {
                resultArray[i] = comparisonArray[i] ? diffComparatorValue : 1 - diffComparatorValue;
                resultArray[N + 1 - i] = 1 - resultArray[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(resultArray[i]);
        }
        System.out.println();
        scanner.next();
    }

    static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine().trim());
        }
        return tokenizer.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}