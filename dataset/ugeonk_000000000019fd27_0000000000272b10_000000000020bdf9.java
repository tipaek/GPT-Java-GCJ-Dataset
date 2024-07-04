import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
            StringBuilder result = new StringBuilder();
            List<Activity> activities = new ArrayList<>();
            int A = Integer.parseInt(reader.readLine());
            for (int a = 0; a < A; a++) {
                Vector<Integer> line = new Vector<>();
                Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .forEach(line::add);
                activities.add(new Activity(a, line.get(0), line.get(1)));
            }

            //J
            for (int a = 0; a < A; a++) {
                List<Activity> listWithC = activities.stream().filter(item -> item.who != null && item.who.equals("J")).collect(Collectors.toList());
                int finalA = a;
                if(listWithC.stream().noneMatch(activity -> activity.intersect(activities.get(finalA)))){
                    activities.get(a).who = "J";
                }
            }

            //J
            for (int a = 0; a < A; a++) {
                if (activities.get(a).who != "J") {
                    List<Activity> listWithJWithoutC =
                            activities.stream().filter(item -> item.who != null && item.who.equals("C")).collect(Collectors.toList());
                    int finalA = a;
                    if (listWithJWithoutC.stream().noneMatch(activity -> activity.intersect(activities.get(finalA)))) {
                        activities.get(a).who = "C";
                    }
                }
            }

            if (activities.stream().anyMatch(item -> item.who == null)) {
                result.append("IMPOSSIBLE");
            } else {
                activities.forEach(item -> result.append(item.who));
            }
            System.out.println("Case #" + i + ": " + result.toString());

        }
    }

    public static class Activity {

        public int index;
        public int start;
        public int end;
        public String who;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public boolean intersect(Activity that) {
            return !((this.end <= that.start) || (that.end <= this.start));
        }
    }
}