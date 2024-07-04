import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {

            int t = Integer.parseInt(br.readLine());
            for (int q = 1; q <= t; q++) {
                int n = Integer.parseInt(br.readLine());
                ArrayList<Activity> activities = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    String[] input = br.readLine().split(" ");
                    activities.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i));
                }

                Collections.sort(activities);

                StringBuilder result = new StringBuilder();
                int endC = 0, endJ = 0;
                boolean isImpossible = false;
                boolean[] assignedToC = new boolean[n];

                for (Activity activity : activities) {
                    if (activity.start >= endC) {
                        assignedToC[activity.index] = true;
                        endC = activity.end;
                    } else if (activity.start >= endJ) {
                        endJ = activity.end;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    pw.println("Case #" + q + ": IMPOSSIBLE");
                } else {
                    for (boolean assigned : assignedToC) {
                        result.append(assigned ? "C" : "J");
                    }
                    pw.println("Case #" + q + ": " + result.toString());
                }
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            if (this.end != other.end) {
                return this.end - other.end;
            }
            return this.index - other.index;
        }
    }
}