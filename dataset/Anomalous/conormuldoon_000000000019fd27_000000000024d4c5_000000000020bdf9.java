import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private class Activity implements Comparable<Activity> {
        int index;
        int start, end;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private String solve() {
        int n = readInt();
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            int[] se = readIntArray();
            activities[i] = new Activity(i, se[0], se[1]);
        }

        Arrays.sort(activities);
        boolean[] isCameron = new boolean[n];
        isCameron[0] = true;
        int lastCameron = 0;

        for (int i = 1; i < n; i++) {
            if (activities[i].start >= activities[lastCameron].end) {
                lastCameron = i;
                isCameron[i] = true;
            }
        }

        int lastJamie = 0;
        for (int i = 1; i < n; i++) {
            if (!isCameron[i]) {
                if (lastJamie == 0) {
                    lastJamie = i;
                } else {
                    if (activities[i].start < activities[lastJamie].end) {
                        return "IMPOSSIBLE";
                    }
                    lastJamie = i;
                }
            }
        }

        boolean[] isAssignedToCameron = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isCameron[i]) {
                isAssignedToCameron[activities[i].index] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(isAssignedToCameron[i] ? 'C' : 'J');
        }

        return result.toString();
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int[] arr = new int[st.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}