import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int tasks = scanner.nextInt();
            scanner.nextLine();

            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < tasks; j++) {
                String[] input = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(input[0]);
                int endTime = Integer.parseInt(input[1]);
                activities.add(new Activity(j + 1, startTime, endTime));
            }

            activities.sort(Comparator.comparingInt(a -> a.startTime));

            int cEndTime = -1;
            int jEndTime = -1;
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cEndTime <= activity.startTime) {
                    activity.assignedTo = "C";
                    cEndTime = activity.endTime;
                } else if (jEndTime <= activity.startTime) {
                    activity.assignedTo = "J";
                    jEndTime = activity.endTime;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                activities.sort(Comparator.comparingInt(a -> a.sequence));
                String result = activities.stream().map(a -> a.assignedTo).collect(Collectors.joining());
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
}

class Activity {
    int sequence;
    int startTime;
    int endTime;
    String assignedTo;

    Activity(int sequence, int startTime, int endTime) {
        this.sequence = sequence;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}