import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = createScanner();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();


        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                Activity activity = new Activity(start, end);
                activities.add(activity);
            }

            activities.sort((a, b) -> a.start - b.start);

            Activity cameron = null;
            Activity jamie = null;
            StringBuilder sb = new StringBuilder();


            for (int j = 0; j < n; j++) {
                Activity activity = activities.get(j);
                if (cameron == null || !cameron.isOverlapped(activity)) {
                    cameron = activity;
                    sb.append("C");
                    continue;
                }

                if (jamie == null || !jamie.isOverlapped(activity)) {
                    jamie = activity;
                    sb.append("J");
                    continue;
                }

                sb.delete(0, sb.length());
                break;
            }

            if (sb.length() == 0) {
                System.out.printf("Case #%d: %s%s", i, "IMPOSSIBLE", i != t ? "\n" : "");
            } else {
                System.out.printf("Case #%d: %s%s", i, sb.toString(), i != t ? "\n" : "");
            }
        }
        in.close();
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
            File outputFile = new File(outputFileName);
            System.setOut(new PrintStream(outputFile));

            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));

        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapped(Activity activity) {
            return this.start <= activity.start && activity.start < this.end;
        }

    }
}
