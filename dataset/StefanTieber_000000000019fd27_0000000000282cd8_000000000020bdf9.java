import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int i = 0; i < numberOfSets; i++) {
                line = reader.readLine();
                parts = line.split("\\s+");
                int numberOfLines = Integer.parseInt(parts[0]);

                List<Activity> activities = new ArrayList<>();

                for (int j = 0; j < numberOfLines; j++) {
                    line = reader.readLine();
                    parts = line.split("\\s+");

                    activities.add(new Activity(Integer.parseInt(parts[0]), Integer.parseInt(parts[2])));
                }

                activities.sort(Comparator.comparing(a -> a.begin));

                String solution = solve(activities);

                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solve(List<Activity> activities) {
        for (int j = 1; j <= 2; j++) {
            int currentEnd = 0;
            for (Activity activity : activities) {
                if (activity.taken == 0 && activity.begin >= currentEnd) {
                    activity.taken = j;
                    currentEnd = activity.end;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Activity activity : activities) {
            switch (activity.taken) {
                case 0:
                    return "IMPOSSIBLE";
                case 1:
                    stringBuilder.append("C");
                    break;
                case 2:
                    stringBuilder.append("J");
                    break;
            }
        }

        return stringBuilder.toString();
    }
}

class Activity {
    public int begin;
    public int end;
    public int taken;

    public Activity(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.taken = 0;
    }
}