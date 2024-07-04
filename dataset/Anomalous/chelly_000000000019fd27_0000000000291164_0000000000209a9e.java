import java.util.*;
import java.io.*;

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
        boolean[] isSame = new boolean[N + 1];
        boolean[] isSameAsCmp = new boolean[N + 1];
        ArrayList<Integer> sameIndices = new ArrayList<>();
        ArrayList<Integer> diffIndices = new ArrayList<>();

        for (int i = 1; i <= N / 2; i++) {
            int a = query(i);
            int b = query(N + 1 - i);
            if (a == b) {
                isSame[i] = true;
                sameIndices.add(i);
            } else {
                isSame[i] = false;
                diffIndices.add(i);
            }
        }

        int sameCmpIndex = -1;
        int diffCmpIndex = -1;

        if (!sameIndices.isEmpty()) {
            sameCmpIndex = sameIndices.remove(0);
            isSameAsCmp[sameCmpIndex] = true;
        }

        if (!diffIndices.isEmpty()) {
            diffCmpIndex = diffIndices.remove(0);
            isSameAsCmp[diffCmpIndex] = true;
        }

        int queryCount = 1;
        int sameCmpValue = query(sameCmpIndex);
        queryCount++;

        while (!sameIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                sameCmpValue = query(sameCmpIndex);
                queryCount++;
                continue;
            }
            isSameAsCmp[sameIndices.get(0)] = (sameCmpValue == query(sameIndices.get(0)));
            queryCount++;
            sameIndices.remove(0);
        }

        int diffCmpValue = query(diffCmpIndex);
        queryCount++;

        while (!diffIndices.isEmpty()) {
            if (queryCount % 10 == 1) {
                diffCmpValue = query(diffCmpIndex);
                queryCount++;
                continue;
            }
            isSameAsCmp[diffIndices.get(0)] = (diffCmpValue == query(diffIndices.get(0)));
            queryCount++;
            diffIndices.remove(0);
        }

        if (queryCount % 10 == 0) query(1);

        int[] result = new int[N + 1];
        sameCmpValue = query(sameCmpIndex);
        diffCmpValue = query(diffCmpIndex);

        for (int i = 1; i <= N / 2; i++) {
            if (isSame[i]) {
                if (isSameAsCmp[i]) {
                    result[i] = sameCmpValue;
                } else {
                    result[i] = 1 - sameCmpValue;
                }
                result[N + 1 - i] = result[i];
            } else {
                if (isSameAsCmp[i]) {
                    result[i] = diffCmpValue;
                } else {
                    result[i] = 1 - diffCmpValue;
                }
                result[N + 1 - i] = 1 - result[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

        if (br.readLine().charAt(0) == 'N') {
            throw new RuntimeException("Incorrect solution");
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            solve(t);
        }
    }
}