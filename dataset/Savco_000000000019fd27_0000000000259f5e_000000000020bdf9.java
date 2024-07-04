import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            ArrayList<Activity> activities = new ArrayList<>();
            int count = in.nextInt();
            for (int j = 0; j < count; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end));
            }
            Collections.sort(activities);

            StringBuilder result = new StringBuilder();
            Activity ja = activities.get(0);
            Activity ca = null;
            result.append('J');
            for (int j = 1; j < count; j++) {
                Activity current = activities.get(j);
                if (current.getStart() >= ja.getEnd()) {
                    ja = current;
                    result.append('J');
                }
                else if (ca == null){
                    ca = current;
                    result.append('C');
                }
                else if (current.getStart() >= ca.getEnd()) {
                    ca = current;
                    result.append('C');
                }
                else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}

class Activity implements Comparable<Activity>{
    private int start;
    private int end;

    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }

    public int compareTo(Activity a) {
        return this.start - a.start;
    }
}