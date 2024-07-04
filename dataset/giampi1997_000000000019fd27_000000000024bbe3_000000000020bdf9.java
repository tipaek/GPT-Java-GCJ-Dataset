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

            Collections.sort(activities, Comparator.comparingInt(activity -> activity.start));
            for (int i = 0; i < n; i++) {
                int start = activities.get(i).start;
                int stop = activities.get(i).stop;

                if (start >= first){
                    first = stop;
                    builder.append('C');
                }
                else if (start >= second){
                    second = stop;
                    builder.append('J');
                }
                else{
                    builder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }


            System.out.println("Case #" + t + ": " + builder);

        }
    }
}

class Activity{
    int start, stop;

    public Activity(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
}