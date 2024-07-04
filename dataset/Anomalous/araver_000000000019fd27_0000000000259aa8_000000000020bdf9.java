import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final boolean FROM_FILE = false;

    private static class Activity implements Comparable<Activity> {
        int start, end, index, color;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("QR20203.in"));
            bw = new BufferedWriter(new FileWriter("QR20203.out"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String NO = "IMPOSSIBLE";

        try {
            int tests = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < tests; i++) {
                int n = Integer.parseInt(br.readLine().trim());
                Activity[] activities = new Activity[n];

                for (int j = 0; j < n; j++) {
                    String[] times = br.readLine().trim().split("\\s+");
                    activities[j] = new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1]), j);
                }

                Arrays.sort(activities);

                int[] finishes = {-1, -1};
                boolean solution = true;

                for (Activity activity : activities) {
                    if (finishes[1] <= activity.start) {
                        activity.setColor(1);
                        finishes[1] = activity.end;
                    } else if (finishes[0] <= activity.start) {
                        activity.setColor(0);
                        finishes[0] = activity.end;
                    } else {
                        solution = false;
                        break;
                    }
                }

                StringBuilder result = new StringBuilder("Case #").append(i + 1).append(": ");
                if (solution) {
                    Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.index, a2.index));
                    for (Activity activity : activities) {
                        result.append(activity.getColor() == 1 ? "C" : "J");
                    }
                } else {
                    result.append(NO);
                }

                bw.write(result.toString());
                bw.newLine();
                bw.flush();
            }
        } finally {
            br.close();
            if (FROM_FILE) {
                bw.close();
            }
        }
    }
}