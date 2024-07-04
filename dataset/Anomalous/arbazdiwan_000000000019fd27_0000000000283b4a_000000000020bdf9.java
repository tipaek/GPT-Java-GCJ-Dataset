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

            if (t >= 1 && t <= 100) {
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

                    StringBuilder schedule = new StringBuilder();
                    int c_end = 0, j_end = 0;
                    boolean impossible = false;

                    for (Activity activity : activities) {
                        if (activity.start >= c_end) {
                            schedule.append('C');
                            c_end = activity.end;
                        } else if (activity.start >= j_end) {
                            schedule.append('J');
                            j_end = activity.end;
                        } else {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }

                    output.add("Case #" + ca + ": " + schedule.toString());
                }

                for (String result : output) {
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}