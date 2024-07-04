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
            int t = sc.nextInt();

            if (t >= 1 && t <= 100) {
                for (int ca = 1; ca <= t; ca++) {
                    List<Activity> activities = new ArrayList<>();
                    int n = sc.nextInt();

                    if (n >= 2 && n <= 10) {
                        for (int i = 0; i < n; i++) {
                            int s = sc.nextInt();
                            int e = sc.nextInt();
                            activities.add(new Activity(s, e));
                        }

                        StringBuilder sb = new StringBuilder();
                        int cStart = 200000, cEnd = 200000;
                        int jStart = 200000, jEnd = 200000;

                        Activity firstActivity = activities.get(0);
                        cStart = firstActivity.start;
                        cEnd = firstActivity.end;
                        sb.append("C");

                        Activity secondActivity = activities.get(1);
                        if (!overlaps(secondActivity, cStart, cEnd)) {
                            cStart = secondActivity.start;
                            cEnd = secondActivity.end;
                            sb.append("C");
                        } else {
                            jStart = secondActivity.start;
                            jEnd = secondActivity.end;
                            sb.append("J");
                        }

                        for (int i = 2; i < activities.size(); i++) {
                            Activity activity = activities.get(i);
                            if (!overlaps(activity, cStart, cEnd)) {
                                cStart = activity.start;
                                cEnd = activity.end;
                                sb.append("C");
                            } else if (!overlaps(activity, jStart, jEnd)) {
                                jStart = activity.start;
                                jEnd = activity.end;
                                sb.append("J");
                            } else {
                                sb = new StringBuilder("IMPOSSIBLE");
                                break;
                            }
                        }

                        output.add("Case #" + ca + ": " + sb.toString());
                    } else {
                        output.add("Case #" + ca + ": IMPOSSIBLE");
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

    private static boolean overlaps(Activity activity, int start, int end) {
        return (activity.start >= start && activity.start < end) || (activity.end > start && activity.end <= end);
    }
}