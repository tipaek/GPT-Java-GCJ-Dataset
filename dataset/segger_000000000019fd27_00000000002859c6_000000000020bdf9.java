import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void mainTmp(String[] args) {
        /*
        Case #1: CJC
        Case #2: IMPOSSIBLE
        Case #3: JCCJJ
        Case #4: CC/*/

        String data = "4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            //System.out.println("T: " + T);
            for (int i = 1; i <= T; ++i) {
                int N = Integer.parseInt(in.nextLine());
                List<Activity> activities = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    Activity activity = new Activity();
                    String[] input = in.nextLine().split(" ");
                    activity.start = Integer.parseInt(input[0]);
                    activity.end = Integer.parseInt(input[1]);
                    activity.order = j;
                    activities.add(activity);
                }

                System.out.println("Case #" + i + ": " + result(N, activities));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        //System.out.println("T: " + T);
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(in.nextLine());
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                Activity activity = new Activity();
                String[] input = in.nextLine().split(" ");
                activity.start = Integer.parseInt(input[0]);
                activity.end = Integer.parseInt(input[1]);
                activity.order = j;
                activities.add(activity);
            }

            System.out.println("Case #" + i + ": " + result(N, activities));
        }
    }

    static class Activity {
        int start;
        int end;
        int order;
        String parent;
    }

    private static String result(int N, List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.start));

        Activity latestCameronActivity = null;
        Activity latestJamieActivity = null;
        boolean impossible = false;

        for (Activity activity: activities) {
            if(latestCameronActivity == null) {
                activity.parent = "C";
                latestCameronActivity = activity;
            } else if (latestJamieActivity == null) {
                activity.parent = "J";
                latestJamieActivity = activity;
            } else {
                if (latestCameronActivity.end > activity.start) {
                    if (latestJamieActivity.end > activity.start) {
                        impossible = true;
                    } else {
                        activity.parent = "J";
                        latestJamieActivity = activity;
                    }
                } else {
                    activity.parent = "C";
                    latestCameronActivity = activity;
                }
            }
        }

        if (impossible) {
            return "IMPOSSIBLE";
        }

        activities.sort(Comparator.comparingInt(a -> a.order));

        StringBuffer buffer = new StringBuffer();
        for (Activity activity : activities) {
            buffer.append(activity.parent);
        }

        return buffer.toString();
    }
}