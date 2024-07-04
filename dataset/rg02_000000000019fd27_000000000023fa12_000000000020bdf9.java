import java.util.*;

class Solution {

    static class Triplet implements Comparable<Triplet> {
        int activityNum;
        int startTime;
        int endTime;
        Triplet(int a, int s, int e) {
            activityNum = a;
            startTime = s;
            endTime = e;
        }
        @Override
        public int compareTo(Triplet t) {
            return this.startTime - t.startTime;
        }
    }

    public static void print(Triplet[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i].activityNum + " " + t[i].startTime + " " + t[i].endTime);
        }
    }

    public static boolean checkAnsPossible(int[] times) {
        int active = 0;
        for (int i = 0; i < 1441; i++) {
            active += times[i];
            if (active >= 3 || active < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int testCaseNum = 0;
        while (t-- > 0) {
            testCaseNum += 1;
            int n = input.nextInt();
            int[] times = new int[1441];
            Triplet[] activities = new Triplet[n];
            for (int i = 0; i < n; i++) {
                int s = input.nextInt();
                int e = input.nextInt();
                activities[i] = new Triplet(i, s, e);
                times[s] += 1;
                times[e] -= 1;
            }
            if (!checkAnsPossible(times)) {
                System.out.println("Case #" + testCaseNum + ": " + "IMPOSSIBLE");
                continue;
            }
            Arrays.sort(activities);
            // print(activities);
            char[] assigned = new char[n];
            boolean camBusy = false;
            boolean jamBusy = false;
            int camTaskEndTime = -1;
            int jamTaskEndTime = -1;
            for (int i = 0; i < n; i++) {
                Triplet activity = activities[i];
                if (!camBusy || activity.startTime >= camTaskEndTime) {
                    assigned[activity.activityNum] = 'C';
                    camTaskEndTime = activity.endTime;
                    camBusy = true;
                    continue;
                }
                if (!jamBusy || activity.startTime >= jamTaskEndTime) {
                    assigned[activity.activityNum] = 'J';
                    jamTaskEndTime = activity.endTime;
                    jamBusy = true;
                }
            }
            String ans = new String(assigned);
            System.out.println("Case #" + testCaseNum + ": " + ans);
        }
    }
}