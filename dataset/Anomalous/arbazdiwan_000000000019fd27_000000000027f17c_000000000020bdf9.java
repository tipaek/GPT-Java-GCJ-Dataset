import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Activity {
    public int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity [start=" + start + ", end=" + end + "]";
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            List<String> output = new ArrayList<>();
            List<Activity> activities = new ArrayList<>();
            int t = sc.nextInt();

            if (t < 1 || t > 100) {
                return;
            }

            for (int ca = 1; ca <= t; ca++) {
                activities.clear();
                int n = sc.nextInt();

                if (n < 2 || n > 10) {
                    output.add("Case #" + ca + ": IMPOSSIBLE");
                    continue;
                }

                boolean validInput = true;
                for (int i = 0; i < n; i++) {
                    int s = sc.nextInt();
                    int e = sc.nextInt();

                    if (s < 0 || s > 1440 || e < 0 || e > 1440) {
                        validInput = false;
                        break;
                    }

                    activities.add(new Activity(s, e));
                }

                if (!validInput) {
                    output.add("Case #" + ca + ": IMPOSSIBLE");
                    continue;
                }

                int c_start = -1, c_end = -1, j_start = -1, j_end = -1;
                StringBuilder sb = new StringBuilder();

                for (Activity activity : activities) {
                    if ((c_start == -1 || activity.start >= c_end) && (c_start == -1 || activity.end >= c_end)) {
                        c_start = activity.start;
                        c_end = activity.end;
                        sb.append("C");
                    } else if ((j_start == -1 || activity.start >= j_end) && (j_start == -1 || activity.end >= j_end)) {
                        j_start = activity.start;
                        j_end = activity.end;
                        sb.append("J");
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                String result = "Case #" + ca + ": " + sb.toString();
                output.add(result);
                System.out.println(result);
            }
        } catch (Exception e) {
            // Handle exception
        } finally {
            sc.close();
        }
    }
}