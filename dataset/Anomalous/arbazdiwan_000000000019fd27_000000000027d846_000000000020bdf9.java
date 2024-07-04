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
                    if (n >= 2 && n <= 10) {
                        for (int i = 0; i < n; i++) {
                            int s = sc.nextInt();
                            int e = sc.nextInt();
                            activities.add(new Activity(s, e));
                        }

                        StringBuilder schedule = new StringBuilder();
                        int cStart = 0, cEnd = 0, jStart = 0, jEnd = 0;
                        boolean impossible = false;

                        for (Activity activity : activities) {
                            if (activity.start >= cEnd) {
                                cStart = activity.start;
                                cEnd = activity.end;
                                schedule.append("C");
                            } else if (activity.start >= jEnd) {
                                jStart = activity.start;
                                jEnd = activity.end;
                                schedule.append("J");
                            } else {
                                impossible = true;
                                break;
                            }
                        }

                        if (impossible) {
                            output.add("Case #" + ca + ": IMPOSSIBLE");
                        } else {
                            output.add("Case #" + ca + ": " + schedule.toString());
                        }
                    }
                }

                for (String o : output) {
                    System.out.println(o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}