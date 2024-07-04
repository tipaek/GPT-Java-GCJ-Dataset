import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int amountCases = in.nextInt();

        for (int i = 1; i <= amountCases; ++i) {
            int amountActivities = in.nextInt();

            List<Activity> activities = new ArrayList<>();

            for (int t = 0; t < amountActivities; t++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), t));
            }

            activities.sort(Comparator.comparingInt(Activity::getStart));

            int jEnd = 0;
            int cEnd = 0;

            boolean valid = true;

            for (Activity activity : activities) {
                if (jEnd <= activity.getStart()) {
                    activity.setPerson("J");
                    jEnd = activity.getEnd();
                } else if (cEnd <= activity.getStart()) {
                    activity.setPerson("C");
                    cEnd = activity.getEnd();
                } else {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            activities.sort(Comparator.comparingInt(Activity::getId));
            StringBuilder builder = new StringBuilder();

            for (Activity activity : activities) {
                builder.append(activity.getPerson());
            }
            
            System.out.println("Case #" + i + ": " + builder.toString());
        }
    }
}

class Activity {

    private final int start;
    private final int end;
    private final int id;

    private String person;

    public Activity (int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPerson() {
        return this.person;
    }
}