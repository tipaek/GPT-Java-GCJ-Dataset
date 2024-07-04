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
                    StringBuilder sb = new StringBuilder();
                    boolean isImpossible = false;

                    int n = sc.nextInt();
                    if (n < 2 || n > 10) {
                        output.add("Case #" + ca + ": IMPOSSIBLE");
                        for (int i = 0; i < n; i++) {
                            sc.nextInt(); // consume the inputs
                            sc.nextInt();
                        }
                        continue;
                    }

                    for (int i = 0; i < n; i++) {
                        int s = sc.nextInt();
                        int e = sc.nextInt();
                        if (s < 0 || s > 1440 || e < 0 || e > 1440) {
                            isImpossible = true;
                            break;
                        }
                        activities.add(new Activity(s, e));
                    }

                    if (isImpossible) {
                        output.add("Case #" + ca + ": IMPOSSIBLE");
                        continue;
                    }

                    int cStart = -1, cEnd = -1, jStart = -1, jEnd = -1;
                    for (Activity activity : activities) {
                        if (cEnd <= activity.start || cStart == -1) {
                            cStart = activity.start;
                            cEnd = activity.end;
                            sb.append('C');
                        } else if (jEnd <= activity.start || jStart == -1) {
                            jStart = activity.start;
                            jEnd = activity.end;
                            sb.append('J');
                        } else {
                            sb.setLength(0);
                            sb.append("IMPOSSIBLE");
                            break;
                        }
                    }

                    output.add("Case #" + ca + ": " + sb.toString());
                }

                for (String result : output) {
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            // Handle exceptions if necessary
        } finally {
            sc.close();
        }
    }
}