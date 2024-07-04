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
        Scanner scanner = new Scanner(System.in);

        try {
            List<String> output = new ArrayList<>();
            List<Activity> activities = new ArrayList<>();
            int t = scanner.nextInt();

            if (t >= 1 && t <= 100) {
                for (int caseNum = 1; caseNum <= t; caseNum++) {
                    activities.clear();
                    int n = scanner.nextInt();
                    if (n < 2 || n > 10) {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                        continue;
                    }

                    boolean isValid = true;
                    for (int i = 0; i < n; i++) {
                        int start = scanner.nextInt();
                        int end = scanner.nextInt();
                        if (start < 0 || start > 1440 || end < 0 || end > 1440) {
                            isValid = false;
                            break;
                        }
                        activities.add(new Activity(start, end));
                    }

                    if (!isValid) {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                        continue;
                    }

                    StringBuilder schedule = new StringBuilder();
                    int cEnd = 0, jEnd = 0;
                    boolean possible = true;

                    for (Activity activity : activities) {
                        if (activity.start >= cEnd) {
                            schedule.append("C");
                            cEnd = activity.end;
                        } else if (activity.start >= jEnd) {
                            schedule.append("J");
                            jEnd = activity.end;
                        } else {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        output.add("Case #" + caseNum + ": " + schedule.toString());
                    } else {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                    }
                }

                for (String result : output) {
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            // Handle any exceptions
        } finally {
            scanner.close();
        }
    }
}