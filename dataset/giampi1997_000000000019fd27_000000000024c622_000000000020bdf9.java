import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++){

            int n = scanner.nextInt();
            int first = -1;
            int second = -1;
            StringBuilder builder = new StringBuilder();

            ArrayList<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            ArrayList<Activity> activitiesCopy = new ArrayList<>(activities);

            Collections.sort(activitiesCopy, Comparator.comparingInt(activity -> activity.start));
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int start = activitiesCopy.get(i).start;
                int stop = activitiesCopy.get(i).stop;

                if (start >= first){
                    first = stop;
                    activitiesCopy.get(i).c = 'C';
                }
                else if (start >= second){
                    second = stop;
                    activitiesCopy.get(i).c = 'J';
                }
                else{
                    impossible = true;
                    break;
                }
            }

            if (impossible)
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            else{
                for (int i = 0; i < n; i++) {
                    builder.append(activities.get(i).c);
                }
                System.out.println("Case #" + t + ": " + builder);
            }

        }
    }
}

class Activity{
    int start, stop;
    char c;

    public Activity(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
}