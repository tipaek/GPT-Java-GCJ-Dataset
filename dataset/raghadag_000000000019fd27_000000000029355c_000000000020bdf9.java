import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                intervals[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                maxEnd = Math.max(maxEnd, intervals[i].e);
            }
            int[][] eventsFlag = getEventsFlagArray(events, maxEnd, intervals);
            int[] csArray = getCumulativeSumArray(events, maxEnd, intervals);
            if (!checkPossible(csArray)) {
                answer.append("Case #" + testCase + ": IMPOSSIBLE\n");
                continue;
            }
            int vis[] = new int[events];
            for (int i = 0; i < events; i++) {
                if (vis[i] > 0)
                    continue;
                vis[i] = 1;
                int first2Index = getFirstIndexOf2(intervals[i].s, intervals[i].e, csArray), eventIndex;
                if (first2Index != -1) {
                    eventIndex = getEventIndex(i, events, first2Index, eventsFlag);
                    if (eventIndex != -1)
                        vis[eventIndex] = 2;
                }
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

    public static int getEventIndex(int targetEvent, int events, int time, int[][] arr) {
        for (int i = 0; i < events; i++) {
            if (arr[i][time] > 0 && i != targetEvent)
                return i;
        }
        return -1;
    }

    public static int getFirstIndexOf2(int s, int e, int[] cs) {
        for (int i = s; i < e; i++)
            if (cs[i] == 2)
                return i;
        return -1;
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
                flagArray[i][j] = 1;
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

class Pair {
    public int s, e;

    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
