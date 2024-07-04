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
            ArrayList<String> output = new ArrayList<>();
            List<Activity> activities = new ArrayList<>();
            int t = sc.nextInt();

            if (t >= 1 && t <= 100) {
                for (int caseNum = 1; caseNum <= t; caseNum++) {
                    int n = sc.nextInt();
                    if (n < 2 || n > 10) {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                        continue;
                    }

                    activities.clear();
                    boolean impossible = false;
                    for (int i = 0; i < n; i++) {
                        int s = sc.nextInt();
                        int e = sc.nextInt();
                        if (s < 0 || s > 1440 || e < 0 || e > 1440) {
                            impossible = true;
                            break;
                        }
                        activities.add(new Activity(s, e));
                    }

                    if (impossible) {
                        output.add("Case #" + caseNum + ": IMPOSSIBLE");
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    int cStart = 200000, cEnd = 200000, jStart = 200000, jEnd = 200000;
                    Activity firstActivity = activities.get(0);
                    cStart = firstActivity.start;
                    cEnd = firstActivity.end;
                    sb.append("C");

                    Activity secondActivity = activities.get(1);
                    if (secondActivity.start >= cEnd) {
                        cStart = secondActivity.start;
                        cEnd = secondActivity.end;
                        sb.append("C");
                    } else {
                        jStart = secondActivity.start;
                        jEnd = secondActivity.end;
                        sb.append("J");
                    }

                    for (int i = 2; i < activities.size(); i++) {
                        Activity currentActivity = activities.get(i);
                        if (currentActivity.start >= cEnd) {
                            cStart = currentActivity.start;
                            cEnd = currentActivity.end;
                            sb.append("C");
                        } else if (currentActivity.start >= jEnd) {
                            jStart = currentActivity.start;
                            jEnd = currentActivity.end;
                            sb.append("J");
                        } else if (currentActivity.start >= cEnd) {
                            cStart = currentActivity.start;
                            cEnd = currentActivity.end;
                            sb.append("C");
                        } else if (currentActivity.start >= jEnd) {
                            jStart = currentActivity.start;
                            jEnd = currentActivity.end;
                            sb.append("J");
                        } else {
                            sb = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }

                    output.add("Case #" + caseNum + ": " + sb.toString());
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