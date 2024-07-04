import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    int K, Q;
    String program;
    int[] L, R, P;
    int[] S, E;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        K = scan.nextInt();
        Q = scan.nextInt();
        program = in.readLine().trim();
        L = readArray(K);
        R = readArray(K);
        P = readArray(K);
        S = readArray(Q);
        E = readArray(Q);
        doIt();
    }

    int[] readArray(int N) throws Exception {
        int[] res = new int[N];
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        for (int i = 0; i < N; i++) {
            res[i] = scan.nextInt();
        }
        return res;
    }

    Map<Map.Entry<Integer, Integer>, Long> map;
    int[] teleport;

    void doIt() {
        map = new HashMap<>();
        teleport = new int[K];
        Map<Integer, Integer> parenCount = new HashMap<>();
        int currCount = 0;
        for (int i = 0; i < K; i++) {
            if (program.charAt(i) == '(') {
                parenCount.put(currCount, i);
                currCount++;
            } else {
                currCount--;
                int which = parenCount.remove(currCount);
                teleport[which] = i;
                teleport[i] = which;
            }
        }
        long max = findMax();
        long res = 0;
        for (int i = 0; i < Q; i++) {
            res += dist(S[i] - 1, E[i] - 1, 0, max);
        }
        System.out.println(res);
    }

    long findMax() {
        long leftMax = 0;
        for (int i = 0; i < K; i++) {
            leftMax += L[i];
        }
        long rightMax = 0;
        for (int i = 0; i < K; i++) {
            rightMax += R[i];
        }
        return Math.max(leftMax, rightMax) + 1;
    }

    long dist(int s, int e, long sofar, long max) {
        if (s == e) return sofar;
        if (sofar > max) return Long.MAX_VALUE;
        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(s, e);
        Long cached = map.get(entry);
        if (cached != null) {
            if (cached.longValue() == -1L) {
                return Long.MAX_VALUE;
            }
            return sofar + cached;
        }
        map.put(entry, -1L);
        long leftDist = Long.MAX_VALUE;
        if (s > 0) {
            leftDist = dist(s - 1, e, sofar + L[s], max);
        }
        max = Math.min(max, leftDist);
        long rightDist = Long.MAX_VALUE;
        if (s < K - 1) {
            rightDist = dist(s + 1, e, sofar + R[s], max);
        }
        max = Math.min(max, rightDist);
        long teleportDist = dist(teleport[s], e, sofar + P[s], max);
        max = Math.min(max, teleportDist);
        if (leftDist == Long.MAX_VALUE && rightDist == Long.MAX_VALUE && teleportDist == Long.MAX_VALUE) {
            map.remove(entry);
            return Long.MAX_VALUE;
        }
        map.put(entry, max);
        return max;
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
