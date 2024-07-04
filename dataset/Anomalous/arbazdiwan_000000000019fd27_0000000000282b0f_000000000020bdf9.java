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
                for (int caseNum = 1; caseNum <= t; caseNum++) {
                    activities.clear();
                    int n = sc.nextInt();
                    StringBuilder schedule = new StringBuilder();
                    boolean impossible = false;

                    if (n >= 2 && n <= 10) {
                        for (int i = 0; i < n; i++) {
                            int start = sc.nextInt();
                            int end = sc.nextInt();

                            if (!(start >= 0 && start <= 1440 && end >= 0 && end <= 1440)) {
                                impossible = true;
                                break;
                            }
                            activities.add(new Activity(start, end));
                        }

                        if (impossible) {
                            output.add("Case #" + caseNum + ": IMPOSSIBLE");
                            continue;
                        }

                        int cStart = -1, cEnd = -1, jStart = -1, jEnd = -1;
                        for (Activity activity : activities) {
                            if (cEnd <= activity.start || cStart == -1) {
                                cStart = activity.start;
                                cEnd = activity.end;
                                schedule.append("C");
                            } else if (jEnd <= activity.start || jStart == -1) {
                                jStart = activity.start;
                                jEnd = activity.end;
                                schedule.append("J");
                            } else {
                                schedule = new StringBuilder("IMPOSSIBLE");
                                break;
                            }
                        }
                        output.add("Case #" + caseNum + ": " + schedule);
                    } else {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                    }
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