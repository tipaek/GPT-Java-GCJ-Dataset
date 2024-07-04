import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int query(int n) throws IOException {
        if (n < 1) return -1;
        System.out.println(n);
        System.out.flush();
        return Integer.parseInt(br.readLine());
    }

    static void solve(int t) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[] sameIndex = new boolean[N + 1];
        boolean[] comparisonResult = new boolean[N + 1];

        int initialQuery = query(1);
        ArrayList<Integer> samePairs = new ArrayList<>();
        ArrayList<Integer> diffPairs = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                sameIndex[i] = true;
                samePairs.add(i);
            } else {
                sameIndex[i] = false;
                diffPairs.add(i);
            }
        }

        int sameCmpIndex = -1;
        int diffCmpIndex = -1;
        if (!samePairs.isEmpty()) {
            sameCmpIndex = samePairs.get(0);
            comparisonResult[sameCmpIndex] = true;
            samePairs.remove(0);
        }
        if (!diffPairs.isEmpty()) {
            diffCmpIndex = diffPairs.get(0);
            comparisonResult[diffCmpIndex] = true;
            diffPairs.remove(0);
        }

        int queryCount = 1;
        int sameCmpValue = query(sameCmpIndex);
        queryCount++;
        while (!samePairs.isEmpty()) {
            if (queryCount % 10 == 1) {
                sameCmpValue = query(sameCmpIndex);
                queryCount++;
                continue;
            }
            comparisonResult[samePairs.get(0)] = (sameCmpValue == query(samePairs.get(0)));
            queryCount++;
            samePairs.remove(0);
        }

        int diffCmpValue = query(diffCmpIndex);
        queryCount++;
        while (!diffPairs.isEmpty()) {
            if (queryCount % 10 == 1) {
                diffCmpValue = query(diffCmpIndex);
                queryCount++;
                continue;
            }
            comparisonResult[diffPairs.get(0)] = (diffCmpValue == query(diffPairs.get(0)));
            queryCount++;
            diffPairs.remove(0);
        }

        if (queryCount % 10 == 0) query(1);

        int[] result = new int[N + 1];
        sameCmpValue = query(sameCmpIndex);
        diffCmpValue = query(diffCmpIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (sameIndex[i]) {
                result[i] = comparisonResult[i] ? sameCmpValue : 1 - sameCmpValue;
                result[N + 1 - i] = result[i];
            } else {
                result[i] = comparisonResult[i] ? diffCmpValue : 1 - diffCmpValue;
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(result[i]);
        System.out.println();
        br.readLine().charAt(0);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }
}