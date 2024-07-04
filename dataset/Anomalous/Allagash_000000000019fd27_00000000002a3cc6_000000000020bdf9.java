import java.util.*;

public class Solution {

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class SortByStart implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            return Integer.compare(a.start, b.start);
        }
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int numActs = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < numActs; ++j) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end));
            }
            Collections.sort(activities, new SortByStart());

            StringBuilder output = new StringBuilder();
            Activity firstActivity = activities.get(0);
            int endC = firstActivity.end;
            int endJ = 0;
            output.append("C");

            if (numActs > 1) {
                Activity secondActivity = activities.get(1);
                if (secondActivity.start >= endC) {
                    output.append("C");
                    endC = secondActivity.end;
                } else {
                    output.append("J");
                    endJ = secondActivity.end;
                }

                for (int j = 2; j < numActs; ++j) {
                    Activity currentActivity = activities.get(j);
                    if (currentActivity.start >= endC) {
                        output.append("C");
                        endC = currentActivity.end;
                    } else if (currentActivity.start >= endJ) {
                        output.append("J");
                        endJ = currentActivity.end;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}