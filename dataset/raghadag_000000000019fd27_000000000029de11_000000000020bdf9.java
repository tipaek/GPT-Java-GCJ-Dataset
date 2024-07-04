import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            int events = Integer.parseInt(input.readLine());
            Pair[] intervals = new Pair[events];
            int maxEnd = 0;
            for (int i = 0; i < events; i++) {
                st = new StringTokenizer(input.readLine());
                intervals[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
                maxEnd = Math.max(maxEnd, intervals[i].e);
            }
            Arrays.sort(intervals);
            int[] csArray = getCumulativeSumArray(events, maxEnd, intervals);
            if (!checkPossible(csArray)) {
                answer.append("Case #" + testCase + ": IMPOSSIBLE\n");
                continue;
            }
            int vis[] = new int[events];
            int lastJTime = -1, lastCTime = -1;
            boolean imp = false;
            for (int i = 0; i < events; i++) {
                if (vis[intervals[i].index] > 0)
                    continue;
                if (intervals[i].s >= lastCTime) {
                    vis[intervals[i].index] = 1;
                    lastCTime = intervals[i].e;
                } else if (intervals[i].s >= lastJTime) {
                    vis[intervals[i].index] = 2;
                    lastJTime = intervals[i].e;
                } else {
                    imp = true;
                    break;
                }

            }
            if (imp) {
                answer.append("Case #" + testCase + ": IMPOSSIBLE\n");
                continue;
            }
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < events; i++) {
                if (vis[i] == 1)
                    s.append("C");
                else
                    s.append("J");
            }
            answer.append("Case #" + testCase + ": " + s.toString() + "\n");
        }
        System.out.println(answer);
    }

    public static boolean checkPossible(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2)
                return false;
        }
        return true;
    }

    public static int[][] getEventsFlagArray(int events, int maxEnd, Pair[] intervals) {
        int[][] flagArray = new int[events][maxEnd + 1];
        for (int i = 0; i < events; i++) {
            for (int j = intervals[i].s; j < intervals[i].e; j++) {
                flagArray[intervals[i].index][j] = 1;
            }
        }
        return flagArray;
    }

    public static int[] getCumulativeSumArray(int events, int maxEnd, Pair[] intervals) {
        int[] csArray = new int[maxEnd + 1];
        for (int i = 0; i < events; i++) {
            csArray[intervals[i].s] += 1;
            csArray[intervals[i].e] -= 1;
        }
        for (int i = 1; i <= maxEnd; i++)
            csArray[i] += csArray[i - 1];
        return csArray;
    }

}

class Pair implements Comparable<Pair> {
    public int s, e, index;

    public Pair(int s, int e, int index) {
        this.s = s;
        this.e = e;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.s - o.s == 0) {
            if (this.e - o.e == 0)
                return this.index - o.index;
            else
                return this.e - o.e;
        }
        return this.s - o.s;
    }
}
