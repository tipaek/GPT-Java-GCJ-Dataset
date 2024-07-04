import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Pair> activities = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                activities.put(i, new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            boolean[] cameronSchedule = new boolean[24 * 60];
            boolean[] jamieSchedule = new boolean[24 * 60];
            char[] result = new char[n];
            boolean isImpossible = false;

            List<Pair> sortedActivities = new ArrayList<>(activities.values());
            Collections.sort(sortedActivities);

            outerLoop:
            for (Pair activity : sortedActivities) {
                int start = activity.start;
                int end = activity.end;
                boolean isCameronBusy = false;
                boolean isJamieBusy = false;

                for (int i = start; i < end; i++) {
                    if (cameronSchedule[i]) {
                        isCameronBusy = true;
                        break;
                    }
                }

                if (!isCameronBusy) {
                    Arrays.fill(cameronSchedule, start, end, true);
                    result[getActivityIndex(activities, activity)] = 'C';
                    continue;
                }

                for (int i = start; i < end; i++) {
                    if (jamieSchedule[i]) {
                        isJamieBusy = true;
                        break;
                    }
                }

                if (!isJamieBusy) {
                    Arrays.fill(jamieSchedule, start, end, true);
                    result[getActivityIndex(activities, activity)] = 'J';
                    continue;
                }

                isImpossible = true;
                break;
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t + 1);
            } else {
                System.out.printf("Case #%d: %s\n", t + 1, new String(result));
            }
        }

        br.close();
    }

    private static int getActivityIndex(Map<Integer, Pair> activities, Pair activity) {
        for (Map.Entry<Integer, Pair> entry : activities.entrySet()) {
            if (entry.getValue().equals(activity)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return start == pair.start && end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }

    @Override
    public int compareTo(Pair other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}